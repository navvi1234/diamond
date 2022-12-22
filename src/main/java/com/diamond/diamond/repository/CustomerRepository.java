package com.diamond.diamond.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.diamond.diamond.entity.CustomerEntity;
import com.diamond.diamond.entity.CustomerId;


public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
	
	
	@Query(value="select * from customer_details c where c.customer_name =:customerName",nativeQuery = true)
	List<CustomerEntity> findAllByCustomerName(String customerName);
	
	@Query(value="select * from customer_details c where c.invoice = :invoice",nativeQuery = true)
	List<CustomerEntity> findAllByInvoice(String invoice);
	
	
	@Query(value = "select * from customer_details", nativeQuery = true)
	List<CustomerEntity> findAllBy();
	
	@Modifying
	@Query(value = "update customer_details c set c.invoice=:newInvoice,c.customer_name=:customerName,"
			+ "c.sellDate=:sellDate,c.ammount=:ammount,c.left_ammount=:leftAmmount"
			+ " where c.invoice = :invoice", nativeQuery = true)
	int updateCustomers(String customerName,String invoice,Date sellDate,int ammount,int leftAmmount,String newInvoice);

}
