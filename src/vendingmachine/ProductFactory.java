
package vendingmachine;

public class ProductFactory {
    
public Product getProduct(String id){
        Product obj = null; //interface object
        
        if (id.equalsIgnoreCase("01,02,03")){//input parameter
            obj = new Food(); //polymorphism
        }
        else if (id.equalsIgnoreCase("04,05,06")){
            obj = new Drink();
        }
        else {
            System.out.println("Invalid Input!!");            
        }        
        return obj; //return selected concrete object     
    }
}

