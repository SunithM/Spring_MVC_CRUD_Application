package com.suni.springdemo.dao;

import java.util.List;

import com.suni.springdemo.entity.Customer;

public interface CustomerDAO {
public List<Customer> getCustomers(int sortField);

public void saveCustomer(Customer theCustomer);

public Customer getCustomer(int theId);

public void deleteCustomer(int theId);
}
