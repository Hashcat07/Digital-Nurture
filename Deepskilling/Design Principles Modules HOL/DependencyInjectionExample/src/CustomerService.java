public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomerName(int id) {
        String name = customerRepository.findCustomerById(id);
        System.out.println("Customer found: " + name);
    }
}