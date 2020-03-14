package example.pojo;

public class UserInfo {

    private int UserID;
    private String userName;
    private String UserType;
    private String creditMax;
    private String Address;
    private String Tel;
    private String cashDoller;


    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getCreditMax() {
        return creditMax;
    }

    public void setCreditMax(String creditMax) {
        this.creditMax = creditMax;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getCashDoller() {
        return cashDoller;
    }

    public void setCashDoller(String cashDoller) {
        this.cashDoller = cashDoller;
    }
}
