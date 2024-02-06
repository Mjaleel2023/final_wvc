package com.Worldvision.core.models;

public class DonarsData {

    private String donarName;
    private String activityName;
    private double donorAmount;
    private String paidDate;
    private String responseObject; // If you really need to store the entire response

    public String getDonarName() {
        return donarName;
    }

    public void setDonarName(String donarName) {
        this.donarName = donarName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getDonorAmount() {
        return donorAmount;
    }

    public void setDonorAmount(double donorAmount) {
        this.donorAmount = donorAmount;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public String getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(String responseObject) {
        this.responseObject = responseObject;
    }
}
