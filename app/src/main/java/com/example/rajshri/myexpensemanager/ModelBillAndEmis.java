package com.example.rajshri.myexpensemanager;

/**
 * Created by Rajshri on 6/2/2017.
 */

public class ModelBillAndEmis {

    String title;
    String subTitle;
    String paidStatus;
    String amount;
    String date;

    ModelBillAndEmis(){
    }

    ModelBillAndEmis(String title, String subTitle,String amount, String date){
        this.title = title;
        this.subTitle = subTitle;
        this.amount = amount;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ModelBillAndEmis{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", paidStatus='" + paidStatus + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
