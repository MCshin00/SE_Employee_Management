package Entity;

public class User extends Member_Entity{
    String Birthdate;
    String BusinessNum;
    public static String CurrentUserID = "user";

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public String getBusinessNum() {
        return BusinessNum;
    }

    public void setBusinessNum(String businessNum) {
        BusinessNum = businessNum;
    }
}
