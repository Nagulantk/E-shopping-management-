package Model;

public class Address {
    private int flatNo;
    private String streetName;
    private String townName;
    private String districtName;

    public Address(int flatNo, String streetName, String townName, String districtName, String stateName, int pinCode) {
        this.flatNo = flatNo;
        this.streetName = streetName;
        this.townName = townName;
        this.districtName = districtName;
        this.stateName = stateName;
        this.pinCode = pinCode;
    }

    private String stateName;
    private int pinCode;

    public int getFlatNo() {
        return flatNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getTownName() {
        return townName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getStateName() {
        return stateName;
    }

    public int getPinCode() {
        return pinCode;
    }
}
