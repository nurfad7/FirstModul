package citizen.facility;

public class Book extends Material{
    private static final String TYPE = "book";
    private String author;

    public Book(String title, int yearOfPublished, String author) {
        super(title, yearOfPublished);
        super.type = TYPE;
        this.author = author;
    }

    @Override
    protected String getType() {
        return "";
    }

    @Override
    protected void getDetailInfo() {

    }

    @Override
    protected void setIsBorrowed() {

    }

    @Override
    protected void setUser(User user) {

    }
}
