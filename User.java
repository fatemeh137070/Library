import netscape.security.Privilege;

public class User {
    String name;
    String phonenumber;
    String Email;
    String password;
    public User(String name,String phonenumber,String password,String Email){
        this.Email=Email;
        this.name=name;
        this.phonenumber=phonenumber;
        this.password=password;
    }




    @Override
    public String toString(){

        return name + ":" + phonenumber + ":" + password + ":" + Email ;
    }
}