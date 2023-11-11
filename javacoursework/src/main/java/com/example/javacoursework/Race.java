package com.example.javacoursework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Race  {
    private String date;
    private String location;
    private String firstPlace;
    private String secondPlace;
    private String thirdPlace;

    private String otherDrivers;


    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    public Race(String date, String location, String firstPlace, String secondPlace, String thirdPlace, String otherDrivers ){
        this.date = String.valueOf(LocalDate.parse(date, dateFormatter));
        this.location = location;
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.thirdPlace = thirdPlace;
        this.otherDrivers = otherDrivers;
    }
    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public String getThirdPlace() {
        return thirdPlace;
    }

    public String getOtherDrivers(){
        return otherDrivers;
    }

    //setters

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public void setThirdPlace(String thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public void setOtherDrivers(String otherDrivers){
        this.otherDrivers=otherDrivers;
    }

}
