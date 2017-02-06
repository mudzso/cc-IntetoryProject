import java.util.ArrayList;

public class StorageManager{

    private StoreCapable storage;

    public void addStorage(StoreCapable storage){
        this.storage = storage;
    }

    public void addCDProduct(String name, int price, int tracks){

        storage.storeCDProduct(name,price,tracks);
    }

    public void addBookProduct(String name, int price, int size){

        storage.storeBookProduct(name,price,size);
    }

    public String listProducts(){

        String productList = "";
        ArrayList<Product>products = storage.getAllProduct();

        for (Product product : products){
            productList += product.name + "/n";

        }

        return productList;
    }

    public int getTotalProductPrice(){
        int totalProductPrice = 0;
        ArrayList<Product>products = storage.getAllProduct();
        for(Product product : products){
            totalProductPrice += product.price;


        }
        return totalProductPrice;

    }
}
