package org.w3_heroku_automation;

public class Monitor {
    private String manufacturer;
    private double screenSize;
    private double price;
    private int yearOfManufacturing;
    private int maximumRefreshRate;

    public Monitor(String manufacturer, double screenSize, double price, int yearOfManufacturing, int maximumRefreshRate) {
        this.manufacturer = manufacturer;
        this.screenSize = screenSize;
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.maximumRefreshRate = maximumRefreshRate;
    }

    public int calculateMonitorAge(){
        return 2025-this.yearOfManufacturing;
    }
    public double calculateDiscount(){
        if(this.calculateMonitorAge()>3){
            return this.price*0.2;
        }
        return this.price;
    }
    public boolean isPremiumMonitor(){
        return this.manufacturer.equals("Dell") && this.screenSize>=27 && this.maximumRefreshRate>=120;
    }

}