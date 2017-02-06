
public class BookProduct extends Product{

    public int numOfTracks;
    public BookProduct(String name, Integer price, int numOfTracks){
        this.name = name;
        this.price = price;
        this.numOfTracks = numOfTracks;
    }
}
