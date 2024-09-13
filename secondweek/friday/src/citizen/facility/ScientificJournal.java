package citizen.facility;

public class ScientificJournal extends Material {
    private static final String TYPE = "journal";
    private String author;
    private String field;
    private String numberOfISSN;

    public ScientificJournal(String title, int yearOfPublished, String author, String field, String numberOfISSN) {
        super(title, yearOfPublished);
        super.type = TYPE;
        this.author = author;
        this.field = field;
        this.numberOfISSN = numberOfISSN;
    }

    @Override
    protected String getType() {
        return TYPE;
    }

    @Override
    protected void getDetailInfo() {
        System.out.println("Scientific Journal Detail:"
                + "\nTitle: " + super.getTitle()
                + "\nAuthor: " + author
                + "\nYear: " + super.getYearOfPublished()
                + "\nISSN: " + numberOfISSN
                + "\nClassification: " + field
                + "\nStatus: " + (super.getIsBorrowed() ? "Borrowed" : "Available"));
    }
}
