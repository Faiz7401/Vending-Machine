package vendingmachine;

import java.util.Random;

public class Dispense {
    
    private Selection select;
    private Payment payment;
    private Product product;
    
    public Dispense(String pid, int qty, double tprice,double tmoney, String pType){
        select=new Selection(pid,qty,tprice);
        payment=new Payment(tmoney, pType);
    }
    
    public Dispense(){
    }
    
    public String pID()
    {
        return select.getProductID();
    }
    
    public int getTotalQuantity()
    {
        return select.getQuantity();
    }
    
    public double getTotalPrice()
    {
        return select.getTotalPrice();
    }
    
    public double getPayment()
    {
        return payment.getTotalMoney();
    }
    
    public String getPaymentType()
    {
        return payment.getPymntType();
    }
    
    public char[] generateReceiptID(int len){
        
        String capital_Letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        
        String values = capital_Letter + numbers;
        
        Random rndm_method = new Random();
        
        char[] receiptID = new char[len];
        
        for(int i=0;i<len;i++){
            receiptID[i] = values.charAt(rndm_method.nextInt(values.length()));
        }
        return receiptID;
    }
    
    public String getProductName(){
        String name="";
        Product[] products = new Product[6]; //Polymorphysm
        products[0]= new Food("01","Kitkat",2.50,10,100);
        products[1]= new Food("02","Cloud9",0.50,14,120);
        products[2]= new Food("03","CadBury",1.20,15,150);
        products[3]= new Drink("04","Coke",1.50,7,150);
        products[4]= new Drink("05","100Plus",2.00,0,120);
        products[5]= new Drink("06","Fanta",2.30,19,200);
        
        for(int i=0;i<products.length;i++){
            if(select.getProductID().equals(products[i].getID())){
                name = products[i].getName();
            }
        }
        return name;
    }
    
    public double getMachineQty()
    {
        double qty=0;
        
        Product[] products = new Product[6]; //Polymorphysm
        products[0]= new Food("01","Kitkat",2.50,10,100);
        products[1]= new Food("02","Cloud9",0.50,14,120);
        products[2]= new Food("03","CadBury",1.20,15,150);
        products[3]= new Drink("04","Coke",1.50,7,150);
        products[4]= new Drink("05","100Plus",2.00,0,120);
        products[5]= new Drink("06","Fanta",2.30,19,200);
        
        for(int i=0;i<products.length;i++){
            if(select.getProductID().equals(products[i].getID())){
                qty = products[i].getQuantityInMachine();
            }
        }
        return qty;
    }
    
    public double calcChange(){
        return payment.getTotalMoney()-select.getTotalPrice();
    }
    
    public String messageChange(){
        if((payment.getTotalMoney()-select.getTotalPrice())==0){
            return "Enjoy Your Food!!";
        }if(payment.getPymntType().equals("PayPal")){
            return "Your change will be auto deductated on your PayPal Account";
        } else {
            return "Please take your coins at the coin dispenser";
        }
    }
    
    public int deductQtyProduct(){
        int qty=0;
        
        Product[] products = new Product[6]; //Polymorphysm
        products[0]= new Food("01","Kitkat",2.50,10,100);
        products[1]= new Food("02","Cloud9",0.50,14,120);
        products[2]= new Food("03","CadBury",1.20,15,150);
        products[3]= new Drink("04","Coke",1.50,7,150);
        products[4]= new Drink("05","100Plus",2.00,0,120);
        products[5]= new Drink("06","Fanta",2.30,19,200);
        
        for(int i=0;i<products.length;i++){
            if(select.getProductID().equals(products[i].getID())){
                qty=select.getQuantity()-product.quantityInMachine;
            }
        }
        return qty;
    }
}
