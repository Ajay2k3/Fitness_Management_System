package com.model;

import java.time.LocalDate;

public class Billing {

    private int billId;
    private int memberId;
    private int packageId;

    private LocalDate billingDate;

    private double amount;

    private double paidAmount;

    private double balanceAmount;

    private String billingStatus;

    public Billing() {

    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }

    @Override
    public String toString() {

        return "Bill ID: " + billId +
               ", Member ID: " + memberId +
               ", Package ID: " + packageId +
               ", Amount: " + amount +
               ", Paid Amount: " + paidAmount +
               ", Balance Amount: " + balanceAmount +
               ", Status: " + billingStatus;
    }
}