package com.nit.domain;

import lombok.Data;

@Data
public class ContactDomain {
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long phoneNo;

}
