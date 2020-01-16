package com.nit.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.domain.ContactDomain;
import com.nit.service.ContactManagementService;
import com.nit.utility.EmailUtility;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactManagementService contactService;

	@Autowired
	private EmailUtility emailutility;

	/**
	 * this method is used for lunch form static dynamic page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayContactFormpage(Model model) {

		ContactDomain contactDomain = new ContactDomain();

		model.addAttribute("beans", contactDomain);

		return "contact";

	}

	/**
	 * this method is used for handle from vale
	 * 
	 * @param contactdomain
	 * @param redirectattribute
	 * @return
	 * @throws IOException
	 */

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handlesubmitBtn(@ModelAttribute(value = "beans") ContactDomain contactdomain,
			RedirectAttributes redirectattribute) throws IOException {
		String msg;
		String sub = "Welcome to TeakLeads!!!";
		boolean saveContact = contactService.saveContact(contactdomain);
		if (saveContact) {
			msg = "Contact details are saved";
			emailutility.sendMail(contactdomain.getContactEmail(), sub, createEmailBody(contactdomain));
			System.out.println(createEmailBody(contactdomain));
		} else
			msg = "Contact details are not saved";

		redirectattribute.addFlashAttribute("msg", msg);

		return "redirect:/doubleposting";

	}

	/**
	 * this method is used for preventing doubleposting
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doubleposting", method = RequestMethod.GET)
	public String preventDoublePosting(Model model) {

		model.addAttribute("beans", new ContactDomain());
		return "contact";
	}

	/**
	 * this method used for fetch all data in database
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getalldata")
	public String viewAllcontacts(Model model) {

		List<ContactDomain> allContact = contactService.getAllContact();
		model.addAttribute("contactList", allContact);

		return "viewContact";
	}

	private String createEmailBody(ContactDomain domain) throws IOException {
		File file = new File("emailContent.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder builder = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			if (line.contains("${name}")) {
				line = line.replace("${name}", domain.getContactName());
			}
			if (line.contains("${Frnd_Name}")) {
				line = line.replace("${Frnd_Name}", "Ashok");
			}
			builder.append(line);
			line = reader.readLine();
			
		}
		reader.close();
		return builder.toString();

	}

}
