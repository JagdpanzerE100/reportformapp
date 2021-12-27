package com.sp.p2032430assignment;

public class DataModel {

    // variables for our formName,
    // description, tracks and duration, id.
    private String formName;
    private String formEmail;
    private String formPhone;
    private String formAddress;
    private int id;

    // creating getter and setter methods
    public String getformName() {
        return formName;
    }

    public void setformName(String formName) {
        this.formName = formName;
    }

    public String getformEmail() {
        return formEmail;
    }

    public void setformEmail(String formEmail) {
        this.formEmail = formEmail;
    }

    public String getformPhone() {
        return formPhone;
    }

    public void setformPhone(String formPhone) {
        this.formPhone = formPhone;
    }

    public String getformAddress() {
        return formAddress;
    }

    public void setformAddress(String formAddress) {
        this.formAddress = formAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public DataModel(String formName, String formEmail, String formPhone, String formAddress) {
        this.formName = formName;
        this.formEmail = formEmail;
        this.formPhone = formPhone;
        this.formAddress = formAddress;
    }
}
