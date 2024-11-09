package vendingmachine;

public abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected int quantityInMachine;
    
    public Product(String id, String name, double price,int quantityInMachine)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantityInMachine=quantityInMachine;
    }

    Product(String id) {
        this.id=id;
    }
    
    Product() {
        id="";
        name="";
        price=0.00;
        quantityInMachine=0;
    }

    abstract String getID();
    
    public String getName()
    {
        return name;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int getQuantityInMachine()
    {
        return quantityInMachine;
    }
    
    public void setID(String id)
    {
        this.id=id;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public void setPrice(double price)
    {
        this.price=price;
    }
    
    public void setQuantityInMachine(int quantityInMachine)
    {
        this.quantityInMachine=quantityInMachine;
    }
    
    ///////////////////////////////////////
    public String displayStatus()
    {
        if (quantityInMachine>0) //Control Statement
        {
            return("Available");
        }
        else
        {
            return("Not Available");
        }
    };
}

