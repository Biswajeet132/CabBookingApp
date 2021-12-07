package com.cg.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.exception.CustomerNotFoundException;
import com.cg.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//	public Customer insertCustomer(Customer customer);
//	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
//	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException;
//	public List<Customer> viewCustomers();
//	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
//	public Customer validateCustomer(String username,String password);
}
