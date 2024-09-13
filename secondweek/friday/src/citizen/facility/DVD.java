package citizen.facility;

public class DVD extends Material{
    private static final String TYPE = "dvd";
    private String genre;

    public DVD(String title, int yearOfPublished, String genre) {
        super(title, yearOfPublished);
        super.type = TYPE;
        this.genre = genre;
    }

    @Override
    protected String getType() {
        return TYPE;
    }

    @Override
    protected void getDetailInfo() {
        System.out.println("DVD Detail:"
                + "\nTitle: " + super.getTitle()
                + "\nGenre: " + genre
                + "\nYear: " + super.getYearOfPublished()
                + "\nStatus: " + (super.getIsBorrowed() ? "Borrowed" : "Available"));
    }
}
