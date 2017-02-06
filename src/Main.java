
public class Main{

    public static void main (String[] args){
        StorageManager manager = new StorageManager();
        StoreCapable store = new PersistentStore();
        manager.addStorage(store);
        manager.addBookProduct("asd", 1231, 234);
    }
}
