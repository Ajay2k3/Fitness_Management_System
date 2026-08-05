package com.model;

public class Package {

    private int packageId;
    private String name;
    private double price;
    private String planIds;

    public Package() {
    }

    public Package(int packageId,
                   String name,
                   double price,
                   String planIds) {

        this.packageId = packageId;
        this.name = name;
        this.price = price;
        this.planIds = planIds;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlanIds() {
        return planIds;
    }

    public void setPlanIds(String planIds) {
        this.planIds = planIds;
    }
}