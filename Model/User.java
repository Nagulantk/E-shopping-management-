package Model;

abstract public class User {
    private String userName;
    private String passWord;
    private long phoneNumber;
    private Address address;
    private String emailId;
    private Enums.Gender gender;

    public User(String userName,String passWord,long phoneNumber,Address address,String emailId,Enums.Gender gender)
    {
        this.userName = userName;
        this.passWord=passWord;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.emailId=emailId;
        this.gender=gender;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Enums.Gender getGender() {
        return gender;
    }

    public void setGender(Enums.Gender gender) {
        this.gender = gender;
    }


}
