package part4.portfolio.user;

public class CreateUser {

    private String name;
    private String pass;

    public CreateUser(String name, String pass){
        this.name = name;
        this.pass = pass;
    }

    public void setName(){this.name = name;}
    public String getName(){return name;}

    public void setPass(){this.name = pass;}
    public String getPass(){return pass;}

}
