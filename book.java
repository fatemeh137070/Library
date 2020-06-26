public class book {
    String nameBook;
    String author;
    String pagenumber;
    public book(String nameBook,String author,String pagenumber){
        this.nameBook=nameBook;
        this.author=author;
        this.pagenumber=pagenumber;
    }

    @Override
    public String toString() {
        return nameBook + ":" + author + ":" + pagenumber ;

    }
}

