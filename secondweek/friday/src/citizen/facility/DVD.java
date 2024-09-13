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
