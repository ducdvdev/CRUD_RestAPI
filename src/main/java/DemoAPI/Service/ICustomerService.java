package DemoAPI.Service;

import DemoAPI.Model.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    ArrayList<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void delete(int id);
    ArrayList<Customer> findByName(String name);
}
