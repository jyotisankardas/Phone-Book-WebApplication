package com.nit.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nit.entity.ContactsDetailsEntity;

public interface ContactDetailsRepo extends JpaRepository<ContactsDetailsEntity, Integer> {
	
	@Transactional
	@Modifying
	@Query("update ContactsDetailsEntity set acctivationssw=:sw where contactId=:cid")
	public int updatebyId(String sw,Integer cid);
}
