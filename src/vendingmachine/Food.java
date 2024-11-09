package vendingmachine;


public class Food extends Product{ //Inheritance
    private int weight;

    public Food(String id, String name, double price,int quantityInMachine ,int weight) 
    {
        super(id, name, price, quantityInMachine);
        this.weight=weight;
    }

    public Food() {
        
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public void setWeight(int weight)
    {
        this.weight=weight;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getID()
    {
        return id;
    }
}

