package vendingmachine;


public class Drink extends Product{ //Inheritance
    private int litter;
    
    public Drink(String id, String name, double price,int quantityInMachine, int litter) {
        super(id, name, price, quantityInMachine);
        this.litter=litter;
    }

    public Drink() {
        
    }
    
     public int getLitter()
    {
        return litter;
    }
    
    public void setLitter(int litter)
    {
        this.litter=litter;
    }
    
    @Override
    public String getID()
    {
        return id;
    }
}