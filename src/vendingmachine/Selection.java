package vendingmachine;

public class Selection {
    private Product product;
    private int quantity;
    private double totalPrice;
    
    
    public Selection(){}
    
    public Selection(String id,int quantity,double totalPrice){
        product=new Product(id) {
            @Override
            String getID() {
                return id;
            }
        };
        this.quantity=quantity;
        this.totalPrice=totalPrice;
        
    }
    
    public String getProductID()
    {
        return product.getID();
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    
    public double getTotalPrice()
    {
        return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice=totalPrice;
    }
    
    public void setProductID(Product product)
    {
        this.product=product;
    }
    
    public double calcTotalPrice(double price){
        return price*quantity;
    }

}
