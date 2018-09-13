package com.example.test.lawyerDTO;

public class Lawyer {
    private String name;
    private String phoneNumber;
    private String physicalAddress;
    private License license;

    public Lawyer(String name, String phoneNumber, String physicalAddress, License license) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.physicalAddress = physicalAddress;
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

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
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
                ", physicalAddress='" + physicalAddress + '\'' +
                ", license=" + license +
                '}';
    }
}
