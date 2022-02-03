package chap_02.Record;

public class Book extends Record{
    private String author;
    private String title;
    public Book(){
        super();
        author = "not given";
        title = "not given";
    }
    public Book (int klic, String author,String title){
        super(klic);
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s\n", super.toString(), "Key", getKey(),"Author: ",getAuthor(),"Title: ",getTitle());
    }

    @Override
    public int getKey() {
        return super.getKey();
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}


