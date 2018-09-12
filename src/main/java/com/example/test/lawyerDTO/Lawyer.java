package com.example.test.lawyerDTO;

public class Lawyer {
    private String name;
    private String phoneNumber;
    private String physicalAdress;
    private License license;

    public Lawyer(String name, String phoneNumber, String physicalAdress, License license) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.physicalAdress = physicalAdress;
        this.license = license;
    }

    public Lawyer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhysicalAdress() {
        return physicalAdress;
    }

    public void setPhysicalAdress(String physicalAdress) {
        this.physicalAdress = physicalAdress;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", physicalAdress='" + physicalAdress + '\'' +
                ", license=" + license +
                '}';
    }
}
