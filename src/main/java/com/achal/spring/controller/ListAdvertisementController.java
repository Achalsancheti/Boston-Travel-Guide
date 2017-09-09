package com.achal.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.achal.spring.dao.CategoryDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Advertisement;
import com.achal.spring.pojo.Category;

@Controller
@RequestMapping("/listadverts.htm")
public class ListAdvertisementController {
	
	@RequestMapping(method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("viewAdverts", "adverts", advList);
        return mv;
    }
	

}
