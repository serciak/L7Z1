package com.company;

public class Client {
    private int caseTime;
    private final int arrivalTime;

    public Client(int arrivalTime, int caseTime) {
        this.arrivalTime = arrivalTime;
        this.caseTime = caseTime;
    }

    public int getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(int caseTime) {
        this.caseTime = caseTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
}
