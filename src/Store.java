import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.*;


abstract class Store implements StoreCapable {

    ArrayList<Product> products;

    public Store(){
        this.products = new ArrayList<Product>();
    }


    public ArrayList<Product> getAllProduct(){

        return products;

    }

    public void storeCDProduct(String name, int price, int size){
        Product cd = new CDProduct(name, price, size);
        store(cd);

    }

    public void storeBookProduct(String name, int price, int size){
        Product book = new BookProduct(name, price, size);
        store(book);

    }

    private void  saveToXml(Product product){

        try{
            File inputFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            Element root = doc.getDocumentElement();

            Element newProduct = doc.createElement("Product");

            newProduct.setAttribute("name", product.name);
            newProduct.setAttribute("price", Integer.toString(product.price));

            root.appendChild(newProduct);
            DOMSource source = new DOMSource(doc);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("input.xml");
            transformer.transform(source, result);


        }catch (Exception e){
            e.printStackTrace();
        }


    }

    protected abstract void storeProduct(Product product);



    protected void createProduct(String type, String name, int price, int size){

        if (type == "CD"){
            storeCDProduct(name, price, size);
        }else if(type == "Book"){
            storeBookProduct(name, price, size);
        }else System.out.println("Wrong type");

    }

    public ArrayList<Product> loadProducts(){
        products.clear();
        try{
            File inputFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i <nodeList.getLength() ; i++) {
                Node node = nodeList.item(i);
                String name = node.getAttributes().getNamedItem("name").getNodeValue();
                int price = Integer.parseInt(node.getAttributes().getNamedItem("price").getNodeValue());
                Product product = new CDProduct(name, price);

                products.add(product);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return products;

    }

    public void store(Product product){

        saveToXml(product);
        storeProduct(product);

    }


}
