package citizen.facility;

public abstract class Material {
    private String title;
    private int yearOfPublished;
    protected String type;
    private boolean isBorrowed;
    private User user = null;

    public Material(String title, int yearOfPublished) {
        this.title = title;
        this.yearOfPublished = yearOfPublished;
        this.isBorrowed = false;
    }

    protected String getTitle() {
        return title;
    }

    protected int getYearOfPublished() {
        return yearOfPublished;
    }

    protected boolean getIsBorrowed() {
        return isBorrowed;
    }

    protected abstract String getType();
    protected abstract void getDetailInfo();

    protected void getShortInfo() {
        System.out.println("|Status: " + (this.isBorrowed ? "borrowed" : "available")
                + "|Title: " + this.title);
    };

    protected boolean setIsBorrowed(User user) {
        if (this.user == null && !isBorrowed) {
            setUser(user);
            isBorrowed = !isBorrowed;
            return true;
        } else if (isBorrowed) {
            setUser(null);
            isBorrowed = !isBorrowed;
            return true;
        } else {
            System.out.println("You aren't borrowing this material");
            return false;
        }
    };

    private void setUser(User user) {
        this.user = user;
    };
}