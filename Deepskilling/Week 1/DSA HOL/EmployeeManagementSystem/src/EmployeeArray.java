public class EmployeeArray {
    private Employee[] employees;
    private int count;

    EmployeeArray(int capacity){
        employees=new Employee[capacity];
        count=0;
    }

    void addEmployee(Employee employee){
        if (count == employees.length){
            System.out.println("Array is full. Cannot add"+employee.getName());
            return;
        }
        employees[count]=employee;
        count++;
        System.out.println("Added: "+employee);
    }

    int searchById(int employeeId){
        for(int i=0;i<count;i++){
            if(employees[i].getEmployeeId()==employeeId){
                return i;
            }
        }
        return -1;
    }

    void traverse(){
        System.out.println("---All Employees---");
        if(count==0){
            System.out.println("(none)");
        }
        else{
            for(int i=0;i<count;i++){
                System.out.println(employees[i]);
            }
        }
    }

    void deleteById(int employeeId){
        int index=searchById(employeeId);
        if(index==-1){
            System.out.println("No Employee with id "+employeeId);
            return;
        }
        Employee removed=employees[index];
        for(int i=index;i<count-1;i++){
            employees[i]=employees[i+1];
        }
        employees[count-1]=null;
        count--;
        System.out.println("Deleted: "+ removed);
    }
}
