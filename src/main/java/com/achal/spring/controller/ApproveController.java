package com.achal.spring.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.achal.spring.dao.AdvertisementDAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Advertisement;

@Controller
@RequestMapping("/approve.htm")
public class ApproveController {
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("advert") Advertisement advertisement, HttpServletRequest request, HttpServletResponse response) throws Exception {
		  advertisement.setTitle(request.getParameter("atitle"));
        
		try{
			String status="Approved";
  			AdvertisementDAO advertisementDAO = new AdvertisementDAO();
  			advertisementDAO.approve(status,advertisement.getTitle());
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

		JSONObject obj = new JSONObject();
        obj.put("successmsg", request.getParameter("atitle") + " Has Been Approved Successfully");
        PrintWriter out = response.getWriter();
        out.println(obj);
        return null;
    }
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdvertisementDAO advertDAO=null;
		List adList = new ArrayList();   
        
		try{
			advertDAO = new AdvertisementDAO();
			adList = advertDAO.approvelist();
			
		}catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("ApprovedPlaces", "adList", adList);
        return mv;
    }

}
