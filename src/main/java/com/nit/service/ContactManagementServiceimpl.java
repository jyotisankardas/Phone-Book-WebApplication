package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.domain.ContactDomain;
import com.nit.entity.ContactsDetailsEntity;
import com.nit.repositery.ContactDetailsRepo;


@Service
public class ContactManagementServiceimpl implements ContactManagementService {

	@Autowired
	private ContactDetailsRepo contactRepo;

	/**
	 * This method is used for save the Contactdetails in database
	 */
	@Override
	public boolean saveContact(ContactDomain contactdomain) {
		ContactsDetailsEntity entity = new ContactsDetailsEntity();
		BeanUtils.copyProperties(contactdomain, entity);
		entity.setAcctivationssw("Y");

		ContactsDetailsEntity save = contactRepo.save(entity);
		return save.getContactId() > 0;
	}

	/**
	 * This method is used for show all contact details
	 */
	@Override
	public List<ContactDomain> getAllContact() {
		List<ContactsDetailsEntity> findAll = contactRepo.findAll();
		List<ContactsDetailsEntity> collect = findAll.stream().filter(entity-> "Y".equals(entity.getAcctivationssw())).collect(Collectors.toList());
		List<ContactDomain> domain = new ArrayList<>();
		if (!collect.isEmpty()) {
			collect.forEach(find -> {
				ContactDomain cdomain = new ContactDomain();
				BeanUtils.copyProperties(find, cdomain);
				domain.add(cdomain);

			});
		}

		return domain;
	}

	/**
	 * This method is used for show contact details specific given id
	 */
	@Override
	public ContactDomain getContactByID(Integer contactId) {
		ContactDomain domain = null;
		Optional<ContactsDetailsEntity> optional = contactRepo.findById(contactId);
		if (optional.isPresent()) {
			domain = new ContactDomain();
			ContactsDetailsEntity enity = optional.get();
			BeanUtils.copyProperties(enity, domain);
			System.out.println("Hii Bosss");
		}
		return  domain;
	}

	

	/**
	 * This method is used for delete contact specific given id
	 */

	@Override
	public void deletContactByID(Integer contactId) {
		 contactRepo.updatebyId("N", contactId);
		
		
	}

}
