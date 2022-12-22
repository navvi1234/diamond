package com.diamond.diamond.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.diamond.diamond.entity.CreditEntity;

public interface CreditRepository extends JpaRepository<CreditEntity, String> {


	@Query(value="select * from credit_details c where c.customer_name =:customerName",nativeQuery = true)
	List<CreditEntity> findAllByCustomerName(String customerName);
	
	@Query(value="select * from credit_details c where c.invoice = :invoice",nativeQuery = true)
	List<CreditEntity> findAllByInvoice(String invoice);
	
	@Query(value = "select * from credit_details c where c.transaction_id= :id", nativeQuery = true)
	List<CreditEntity> findAllById(String id);
	
	@Modifying
	@Query(value = "delete from credit_details c where c.invoice = :invoice", nativeQuery = true)
	void deleteAllByInvoice(String invoice);
}
