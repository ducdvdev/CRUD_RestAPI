package DemoAPI.Controller;

import DemoAPI.Model.Customer;
import DemoAPI.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/customers")
public class CustomerControler {
    @Autowired
    private ICustomerService customerService;


    @GetMapping
    public ResponseEntity<ArrayList<Customer>> findAllCustomer(){
        ArrayList<Customer> ListCustomer=customerService.findAll();
        if(ListCustomer.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ListCustomer,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable int id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> edit(@PathVariable int id,@RequestBody Customer customer){
        Customer customer1=customerService.findById(id);
        if(customer1 !=null){
            customer.setId(id);
            customerService.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/find/{name}")
    public ResponseEntity<ArrayList<Customer>> findByName(@PathVariable String name){
       return new ResponseEntity<>(customerService.findByName(name),HttpStatus.OK);
    }

}
