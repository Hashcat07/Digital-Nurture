public class CustomerRepositoryImpl implements CustomerRepository{
    @Override
    public String findCustomerById(int id) {
        if(id==1)return "Rohul";
        if(id==2)return "Rahul";
        return "Unknown";
    }
}
