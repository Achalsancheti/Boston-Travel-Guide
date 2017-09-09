package com.achal.spring.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.achal.spring.controller.AdvertisementValidator;
import com.achal.spring.dao.AdvertisementDAO;
import com.achal.spring.dao.CategoryDAO;
import com.achal.spring.dao.UserDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Advertisement;
import com.achal.spring.pojo.Category;
import com.achal.spring.pojo.User;

@Controller
@RequestMapping("/addadvertisement.htm")
public class AddAdvertisementController extends SimpleFormController {

	@Autowired
	@Qualifier("advertValidator")

	AdvertisementValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("advertisement")Advertisement advertisement,BindingResult result) throws Exception{

		File file;
	       String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
	       String path = null;
	       if(check.equalsIgnoreCase("\\")) {
	    	   path = getServletContext().getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
	    }
	    
	        if(check.equalsIgnoreCase("/")) {
	        	path = getServletContext().getRealPath("").replace("build/","");
	       path += "/"; //Adding trailing slash for Mac systems.

	    }
	       
	        if(advertisement.getPhoto() != null){
	          String fileNameWithExt=System.currentTimeMillis()+advertisement.getPhoto().getOriginalFilename();
	          file=new File(path+fileNameWithExt);
	          String context = getServletContext().getContextPath();
	          
	          advertisement.getPhoto().transferTo(file);
	          advertisement.setPhotoName(context + "/" + fileNameWithExt);

	    
		validator.validate(advertisement, result);
		if(result.hasErrors())
		{
			return "AddAdvertise";
		}
		
		String username = advertisement.getPostedBy();   //get posting user from addAdvertForm
        String categoryTitle = advertisement.getCategory_name();   //get category user from addAdvertForm
        String title = advertisement.getTitle();      //get advert title user from addAdvertForm
        String message = advertisement.getMessage(); 
        String location = advertisement.getLocation();
        String phoneNumber = advertisement.getPhoneNumber();
        String photoName = advertisement.getPhotoName();
        String status = advertisement.getStatus();
        String recommendation = advertisement.getRecommendation();
        
        try {
            UserDAO users = new UserDAO();
            CategoryDAO categories = new CategoryDAO();
            AdvertisementDAO adverts = new AdvertisementDAO();
        
          //searhing from database
            User user = users.get(username);

            //searching from database
            Category category = categories.get(categoryTitle);

            //insert a new advert
            Advertisement adv = adverts.create(title, message, user,category.getId(),category.getTitle(),location,phoneNumber,photoName, status, recommendation);

            category.addAdvert(adv);
            categories.save(category);
            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        return "AddedAdvertisement";
	        }
	        return "AddAdvertise";
    }

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("advertisement") Advertisement advertisement, BindingResult result) {

		return "AddAdvertise";
	}

}
