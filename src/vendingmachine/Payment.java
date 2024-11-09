package vendingmachine;

public class Payment {
    private double money;
    private String pymntType;
    private double totalMoney;
    
    public Payment(){}
    
    public Payment(double totalMoney,String pymntType){
        this.totalMoney=totalMoney;
        this.pymntType=pymntType;
    }
    
    public Payment(double money)
    {
        this.money=money;
    }
    
    public double getMoney()
    {
        return money;
    }
    
    public void setMoney(double money)
    {
        this.money=money;
    }
    
    public double getTotalMoney()
    {
        return totalMoney;
    }
    
    public void setTotalMoney(double totalMoney)
    {
        this.totalMoney=totalMoney;
    }
    
    public void setPymntType(String pymntType){
        this.pymntType=pymntType;
    }
    
    public String getPymntType()
    {
        return pymntType;
    }
    
    public double totalMoney(){
        switch ((int)money) {
            case 10:
                money=0.1;
                break;
            case 20:
                money=0.2;
                break;
            case 50:
                money=0.5;
                break;
            case 1:
                money=1;
                break;
            case 5:
                money=5;
                break;
            default:
                money=0;
                break;
        }
        return money;
    }

}
