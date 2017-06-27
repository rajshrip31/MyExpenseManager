package com.example.rajshri.myexpensemanager;

/**
 * Created by Rajshri on 6/2/2017.
 */

public class ModelSpendAreas {

    String icon;
    String title;
    String amount;
    String colorCode;
    String percentage;

    ModelSpendAreas(){

    }

    ModelSpendAreas(String icon, String title, String amount, String colorCode, String percentage){
        this.icon = icon;
        this.title = title;
        this.amount = amount;
        this.colorCode = colorCode;
        this.percentage = percentage;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "ModelSpendAreas{" +
                "icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", amount='" + amount + '\'' +
                ", colorCode='" + colorCode + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}
