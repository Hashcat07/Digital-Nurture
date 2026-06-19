public class SearchAlgorithms {
    public Product linearSearch(Product[] products,int productId){
        for(int i=0;i<products.length;i++){
            if(products[i].getProductId()==productId){
                return products[i];
            }
        }
        return null;
    }
    public Product binarySearch(Product[] products ,int productId){
        int low=0;
        int high=products.length;

        while(low<=high){
            int mid=low+(high-low)/2;
            int midId=products[mid].getProductId();
            if(midId==productId)
                return products[mid];
            else if (midId>productId) {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return null;
    }
}
