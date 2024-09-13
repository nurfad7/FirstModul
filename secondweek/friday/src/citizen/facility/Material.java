package citizen.facility;

public abstract class Material {
    private String title;
    private int yearOfPublished;
    protected String type;
    private boolean isBorrowed;
    private User user;

    public Material(String title, int yearOfPublished) {
        this.title = title;
        this.yearOfPublished = yearOfPublished;
        this.isBorrowed = false;
    }

    protected abstract String getType();

    protected abstract void getDetailInfo();

    protected abstract void setIsBorrowed();

    protected abstract void setUser(User user);
}