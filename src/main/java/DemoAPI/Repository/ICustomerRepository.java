package DemoAPI.Repository;

import DemoAPI.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
    public ArrayList<Customer> findCustomersByLastNameContaining(String name);
}
