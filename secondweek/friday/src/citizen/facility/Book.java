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
        return TYPE;
    }

    @Override
    protected void getDetailInfo() {
        System.out.println("Book Detail:"
                + "\nTitle: " + super.getTitle()
                + "\nAuthor: " + author
                + "\nYear: " + super.getYearOfPublished()
                + "\nStatus: " + (super.getIsBorrowed() ? "Borrowed" : "Available"));
    }
}
