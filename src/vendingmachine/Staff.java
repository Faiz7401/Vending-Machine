
package vendingmachine;

public class Staff {
    private String username;
    private String password;
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public boolean verification(){
        if("Admin01".equals(username) && "123456".equals(password)){
                return true;
        }else{
            return false;
        }
    }
}
