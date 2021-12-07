package com.cg.service;
import java.util.List;

import com.cg.exception.CustomerNotFoundException;
import com.cg.model.Customer;
public interface ICustomerService {
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException;
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	public Customer validateCustomer(String username,String password);
}
