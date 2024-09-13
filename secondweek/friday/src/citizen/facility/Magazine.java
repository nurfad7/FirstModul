package citizen.facility;

import java.time.Month;

public class Magazine extends Material{
    private static final String TYPE = "magazine";
    private Month monthOfPublished;

    public Magazine(String title, int yearOfPublished, Month monthOfPublished) {
        super(title, yearOfPublished);
        super.type = TYPE;
        this.monthOfPublished = monthOfPublished;
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
