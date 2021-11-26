package com.nit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nit.domain.ContactDomain;
import com.nit.service.ContactManagementService;

@Controller
public class ViewContactsController {
	@Autowired
	private ContactManagementService contactmgnservice;

	/**
	 * this method is used for edit existing contact details
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editContact(HttpServletRequest req, Model model) {
		int parseInt = Integer.parseInt(req.getParameter("contactId"));
		ContactDomain contactByID = contactmgnservice.getContactByID(parseInt);
		model.addAttribute("beans", contactByID);
		 return "contact";

	}

	/**
	 * this method is used for soft delet 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delet", method = RequestMethod.GET )
	public String deleteContact(HttpServletRequest req, Model model) {
		int parseInt = Integer.parseInt(req.getParameter("contactId"));
		contactmgnservice.deletContactByID(parseInt);

		return "redirect:/getalldata";
	}
}
