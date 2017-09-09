package com.achal.spring.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.achal.spring.dao.AdvertisementDAO;
import com.achal.spring.dao.CategoryDAO;
import com.achal.spring.dao.OfferDAO;
import com.achal.spring.dao.UserDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Advertisement;
import com.achal.spring.pojo.Category;
import com.achal.spring.pojo.User;

@Controller
@RequestMapping("/manage.htm")
public class ManageController {

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryDAO categories = null;
        List categoryList = null;
        List advList = new ArrayList();
        
        try {
            categories = new CategoryDAO();
            categoryList = categories.list();

            Iterator categIterator = categoryList.iterator();

            while (categIterator.hasNext())
            {
                Category category = (Category) categIterator.next();

                Iterator advIterator = category.getAdverts().iterator();

                while (advIterator.hasNext())
                {
                    Advertisement advert = (Advertisement) advIterator.next();
                    advList.add(advert);
                }
            }
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("ManagePlaces", "advertisement", advList);
        return mv;
    }
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("advertisement") Advertisement advertisement, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long n = Long.parseLong(request.getParameter("id"));			
		  
		try{
			AdvertisementDAO advertisementDao = new AdvertisementDAO();
			advertisementDao.delete(n);
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

		JSONObject obj = new JSONObject();
        obj.put("successmsg", "Advertisement with AdvertisementID:" + request.getParameter("id") + " Has Been Deleted Successfully");
        PrintWriter out = response.getWriter();
        out.println(obj);
        return null;
    }
	
	
}
