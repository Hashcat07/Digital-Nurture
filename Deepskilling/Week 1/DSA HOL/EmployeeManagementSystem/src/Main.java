public class Main {
    static void main() {
        EmployeeArray staff = new EmployeeArray(5);

        staff.addEmployee(new Employee(1, "Arjun", "Developer", 60000));
        staff.addEmployee(new Employee(2, "Divya", "Tester", 55000));
        staff.addEmployee(new Employee(3, "Karthik", "Manager", 90000));
        staff.traverse();

        int idx = staff.searchById(2);

        System.out.println("Search id 2 -> index " + idx);
        staff.deleteById(2);
        staff.deleteById(99);
        staff.traverse();
    }

}
/*
 * EXERCISE 4: Employee Management System (ARRAY based)
 * Stores employees in a fixed-size array with a count of how many are used.
 *
 * add      : O(1)  -> place at the next free slot
 * search   : O(n)  -> linear scan by employeeId
 * traverse : O(n)  -> visit every element
 * delete   : O(n)  -> find it, then shift the rest left to fill the gap
 */