package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "contact_info")
public class ContactsDetailsEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "contact_Id",length = 10)
	private Integer contactId;
	
	@Column(name = "contact_name",length = 20)
	private String contactName;
	
	@Column(name = "contact_email",length = 35)
	private String contactEmail;
	
	@Column(name = "contact_phno",length=11)
	private long phoneNo;
	
	@Column(name = "asw",length = 5)
	private String acctivationssw;
	
	
	
	
	
	
	
	
	
	
	

}
