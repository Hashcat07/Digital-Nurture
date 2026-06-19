public class Main {
    static void main() {
        Inventory inventory=new Inventory();

        inventory.addProduct(new Product(101, "Keyboard", 50, 799.0));
        inventory.addProduct(new Product(102, "Mouse", 75, 499.0));
        inventory.addProduct(new Product(103, "Monitor", 20, 12999.0));
        inventory.addProduct(new Product(101, "Duplicate", 1, 1.0));
        inventory.displayInventory();

        inventory.updateProduct(102, 60, 549.0);
        inventory.updateProduct(999, 10, 10.0);

        inventory.deleteProduct(103);
        inventory.deleteProduct(500);

        inventory.displayInventory();


    }



}
/*
 * EXERCISE 1: Inventory Management System
 * Data structure: HashMap<Integer, Product>  (key = productId)
 *
 * Why HashMap?
 * A hash map gives O(1) add / update / delete / lookup, which is what this module needs.
 */