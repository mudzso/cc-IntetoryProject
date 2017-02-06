
public class CDProduct extends Product{

    public int pageSize;

    public CDProduct(String name, Integer price, int pageSize){
        this.name = name;
        this.price = price;
        this.pageSize = pageSize;

    }
    public CDProduct(String name, Integer price){
        this.name = name;
        this.price = price;
    }



}
