public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);
        service.printCustomerName(1);
        service.printCustomerName(2);
        service.printCustomerName(99);
    }
}