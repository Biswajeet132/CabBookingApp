package com.cg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.CustomerNotFoundException;
import com.cg.model.Customer;
import com.cg.repository.ICustomerRepository;

@Service

public class ICustomerImplementation implements ICustomerService {

	private ICustomerRepository iCustomerRepository;
	
	
	@Autowired
	public ICustomerImplementation(ICustomerRepository iCustomerRepository) {
		this.iCustomerRepository = iCustomerRepository;
	}

	@Override
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return iCustomerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
		// TODO Auto-generated method stub
		if(iCustomerRepository.findById(customer.getCustomerId()).isEmpty())
		{
			throw new CustomerNotFoundException();
		}
		return iCustomerRepository.save(customer);
	}

	@Override
	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException{
		// TODO Auto-generated method stub
		if(iCustomerRepository.findById(customerId).isEmpty())
		{
			throw new CustomerNotFoundException();
		}
		else
		{
			Customer deleteCustomer=iCustomerRepository.findById(customerId).get();
			iCustomerRepository.deleteById(customerId);
			return deleteCustomer;
		}
	}

	@Override
	public List<Customer> viewCustomers() {
		// TODO Auto-generated method stub
		return iCustomerRepository.findAll();
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		if(iCustomerRepository.findById(customerId).isEmpty())
		{
			throw new CustomerNotFoundException();
		}
		else
		{
			Customer findCustomerById=iCustomerRepository.findById(customerId).get();
			return findCustomerById;
		}
	
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
