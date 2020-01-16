package com.nit.service;


import java.util.List;

import com.nit.domain.ContactDomain;

public interface ContactManagementService {
	
	public boolean saveContact(ContactDomain contactdomain);
	
	public List<ContactDomain> getAllContact();
	
	public ContactDomain getContactByID(Integer contactId);
	
	
	
	public void deletContactByID(Integer contactId);
	
	
}
