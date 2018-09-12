package com.example.test.lawyerDTO;

public class License {
    private String state;
    private String memberClass;

    public License(String state, String memberClass) {
        this.state = state;
        this.memberClass = memberClass;
    }

    public License() {}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(String memberClass) {
        this.memberClass = memberClass;
    }

    @Override
    public String toString() {
        return "License{" +
                "state='" + state + '\'' +
                ", memberClass='" + memberClass + '\'' +
                '}';
    }
}
