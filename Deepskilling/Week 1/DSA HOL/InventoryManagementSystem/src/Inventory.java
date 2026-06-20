import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<Integer,Product> map;

    public Inventory(){
        map=new HashMap<>();
    }

    void addProduct(Product product){
        if(map.containsKey(product.getProductId())){
            System.out.println("Product with the id"+product.getProductId()+" already exists");
        }
        else{
            map.put(product.getProductId(),product);
            System.out.println("Product: "+product +" added successfully");
        }
    }

    void updateProduct(int productId, int newQuantity,double newPrice ){
        if(map.containsKey(productId)){
            Product temp=map.get(productId);
            temp.setPrice(newPrice);
            temp.setQuantity(newQuantity);
            System.out.println("Updated: "+temp);
        }
        else{
            System.out.println("Product not found");
        }
    }

    void deleteProduct(int productId){
        if(map.containsKey(productId)){
            Product removed=map.remove(productId);
            System.out.println("Removed Successfully: "+removed);
        }
        else{
            System.out.println("No Product found with this id");
        }
    }

    void displayInventory(){
        System.out.println("--Inventory--");
        if(map.isEmpty()){
            System.out.println("Inventory Empty");
        }
        else{
            for(Product product:map.values()){
                System.out.println(product);
            }
        }
    }
}
