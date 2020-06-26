import java.util.ArrayList;

public class LibraryList {

    protected String  userName;
    protected String BookName;
    protected ArrayList<String> books = new ArrayList<String>();


    public LibraryList(String userName,ArrayList<String> books ){
        this.userName =userName;
        this.books=books;

    }
    @Override
    public String toString(){

        return userName + ":" + BookName.toString()  ;
    }

}
