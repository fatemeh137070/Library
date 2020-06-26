import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean isAlive;
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<book> books = new ArrayList<book>();
    private static ArrayList<LibraryList> libraryList =new ArrayList<>();
    private static Scanner sc = new Scanner( System.in );

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        System.out.println( "WELCOME TO LibraryList" );
        isAlive = true;
        while (isAlive) {
            System.out.println( "\nBooks Manager: bm" + "\nUsers Manager: um" +"\nLibrarys List: ly");
            String input = sc.nextLine();
            String result = routInput( input );
            System.out.println( result );

        }
        sc.close();
    }


    public static String routInput(String input) {
        input = input.toLowerCase();
        switch (input) {
            case"/bm":
                return bookManager();
            case"/um":
                return userManager();
            case"/ly":
                return LibraryList();
            case"/au":
                return addUserProcess();
            case"/la":
                return addLibraryListProcess();
            case "/lu":
                return showUserList();
            case "/ll":
                return showLibraryList();
            case "/eu":
                return EditUserList();
            case "/ld":
                return RemoveLibrary();
            case "/du":
                return RemoveUser();
            case"/ab":
                return addBookProcess();
            case "/lb":
                return showBookList();
            case "/eb":
                return EditBookList();
            case "/db":
                return RemoveBook();
            case "/exit":
                return exit();
            default:
                return wronginput();

        }
    }



    private static String LibraryList() {
        System.out.println( "\nLibrarys List: " + "\nAdd user book: la"+ "\nDelete user book: ld"+ "\nShow List users book: ll");

        String input = sc.nextLine();
        String result = routInput( input );
        System.out.println( result );
        return "";
    }

    private static String  bookManager() {
        System.out.println( "\nBooks Manager: " + "\nAdd: ab"+ "\nEdit: eb"+ "\nDelete: db"+ "\nShow List: lb");

        String input = sc.nextLine();
        String result = routInput( input );
        System.out.println( result );
        return "";
    }

    private static String  userManager() {
        System.out.println( "\nUsers Manager: " + "\nAdd: au"+ "\nEdit: eu"+ "\nDelete: du"+ "\nShow List: lu");

        String input = sc.nextLine();
        String result = routInput( input );
        System.out.println( result );
        return "";
    }
    private static String RemoveLibrary() {
        System.out.println( "Enter user name:" );
        String name = sc.nextLine();
        int index = -1;
        ArrayList<String> bookList =new ArrayList<>();

        for (int i = 0; i<libraryList.size(); i++) {
            if (libraryList.get( i ).userName.equals( name )) {
                index = i;
                System.out.println( "books of "+ name+ " : " + "\n-------------------\n" );
                bookList = libraryList.get(i).books;
                for(int j=0;j<bookList.size();j++){
                    System.out.println( j + "-" + bookList.get(j) );
                }
            }
        }

        if (index == -1) {
            return "this user not exist or books count for this user is 0";
        } else {
            System.out.println( "Select a book from " + name + " books :" );
            String book = sc.nextLine();
            if(!bookList.contains(book))
                return "the book "+ book + " not exist in list books " + name;

            bookList.remove(book);

            libraryList.get( index ).userName = name;
            libraryList.get( index ).books = bookList;

            return "Successfully remove the book " + book + " from list books "+ name;
        }
    }

    private static String showLibraryList() {

        String result = "";
        if (libraryList.size() == 0) {
            return  "Library list is empty";
        } else {
            for (int i = 0; i<libraryList.size(); i++) {
                LibraryList n = libraryList.get( i );
                result += "\n-----------------\n" + libraryList.get( i ).userName+ " \nBooks: \n";
                if(libraryList.get( i ).books.size() == 0)
                    result += "books list empty \n";
                else {
                    for(int j=0;j<libraryList.get( i ).books.size();j++){
                        result +=libraryList.get( i ).books.get(j) + "\n";
                    }
                }

            }
        }
        return result;
    }



    private static String addLibraryListProcess() {
        System.out.println( "Enter user name:" );
        String userName = sc.nextLine();
        System.out.println( "Enter user BookName:" );
        String BookName = sc.nextLine();

        int existUser=-1;
        for(int i=0;i<users.size();i++){
            if(users.get(i).name.equals( userName)){
                existUser=i;
            }
        }
        if(existUser==-1){
            return "this user not exist in users list";
        }
        ArrayList<String> bookList =new ArrayList<>();
        for(int i=0;i<libraryList.size();i++){
            if(libraryList.get(i).userName.equals(userName)){
                bookList = libraryList.get(i).books;
                bookList.add(BookName);
                libraryList.get(i).userName = userName;
                libraryList.get(i).books = bookList;
                return "the book "+ BookName + " added for " + userName;
            }
        }
        bookList.add(BookName);
        LibraryList l = new LibraryList ( userName, bookList );
        libraryList.add( l );
        return "the book "+ BookName + " added for " + userName;
    }

    private static String addUserProcess() {
        System.out.println( "Enter user name:" );
        String name = sc.nextLine();
        System.out.println( "Enter user password:" );
        String password = sc.nextLine();
        System.out.println( "Enter user email:" );
        String emil = sc.nextLine();
        System.out.println( "Enter user phonNumber:" );
        String phonNumber = sc.nextLine();
        User u = new User( name, password, emil, phonNumber );
        users.add( u );
        return "new user added";
    }

    private static String addBookProcess() {
        System.out.println( "Enter book name:" );
        String nameBook = sc.nextLine();
        System.out.println( "Enter author name:" );
        String autherName = sc.nextLine();
        System.out.println( "Enter page number:" );
        String pageNumber = sc.nextLine();
        book b = new book( nameBook, autherName,pageNumber );
        books.add( b );
        return "new book added";
    }

    private static String EditBookList() {
        System.out.println( "Enter book name:" );
        String name = sc.nextLine();
        int toEditIndex = -1;
        for (int i = 0; i<books.size(); i++) {
            book b = books.get( i );
            if (b.nameBook.equals( name )) {
                toEditIndex = i;

            }

        }
        if (toEditIndex == -1) {
            return "book not foun";
        } else {
            System.out.println( "Enter book name:" );
            String nameBook = sc.nextLine();
            System.out.println( "Enter author name:" );
            String autherName = sc.nextLine();
            System.out.println( "Enter page number:" );
            String pageNumber = sc.nextLine();
            books.get( toEditIndex ).nameBook = nameBook;
            books.get( toEditIndex ).author = autherName;
            books.get( toEditIndex ).pagenumber = pageNumber;
            return "book edited";
        }

    }

    private static String showBookList() {
        String result = "";
        if (books.size() == 0) {
            result = "no book found";

        } else {
            for (int i = 0; i<books.size(); i++) {
                book b = books.get( i );
                result += b + "\n";

            }
        }
        return result;
    }

    private static String RemoveBook() {
        System.out.println( "Enter book name:" );
        String name = sc.nextLine();
        int toRemoveIndex = -1;
        for (int i = 0; i<books.size(); i++) {
            book b = books.get( i );
            if (b.nameBook.equals( name )) {
                toRemoveIndex = i;

            }

        }
        if (toRemoveIndex == -1) {
            return "book not foun";
        } else {
            books.remove( toRemoveIndex );
            return "book removed";
        }

    }

    private static String wronginput() {
        return "input wrong";
    }

    private static String RemoveUser() {
        System.out.println( "Enter user name:" );
        String name = sc.nextLine();
        int toRemoveIndex = -1;
        for (int i = 0; i<users.size(); i++) {
            User u = users.get( i );
            if (u.name.equals( name )) {
                toRemoveIndex = i;

            }

        }
        if (toRemoveIndex == -1) {
            return "user not foun";
        } else {
            users.remove( toRemoveIndex );
            return "user removed";
        }

    }

    private static String EditUserList() {
        System.out.println( "Enter user name:" );
        String name = sc.nextLine();
        int toEditIndex = -1;
        for (int i = 0; i<users.size(); i++) {
            User u = users.get( i );
            if (u.name.equals( name )) {
                toEditIndex = i;

            }

        }
        if (toEditIndex == -1) {
            return "user not foun";
        } else {
            System.out.println( "Enter user name:" );
            String newName = sc.nextLine();
            System.out.println( "Enter user password:" );
            String newPassword = sc.nextLine();
            System.out.println( "Enter user email:" );
            String newEmil = sc.nextLine();
            System.out.println( "Enter user phonNumber:" );
            String newPhonNumber = sc.nextLine();
            users.get( toEditIndex ).name = newName;
            users.get( toEditIndex ).password = newPassword;
            users.get( toEditIndex ).Email = newEmil;
            users.get( toEditIndex ).phonenumber = newPhonNumber;
            return "user edited";
        }

    }

    private static String exit() {
        isAlive = false;
        return "bye";
    }


    private static String showUserList() {
        String result = "";
        if (users.size() == 0) {
            result = "no usre found";

        } else {
            for (int i = 0; i<users.size(); i++) {
                User u = users.get( i );
                result += u + "\n";

            }
        }
        return result;
    }
}


