package citizen.facility;

public class ScientificJournal extends Material {
    private static final String TYPE = "scientific journal";
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
