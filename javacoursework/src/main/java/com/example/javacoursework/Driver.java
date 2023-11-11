package com.example.javacoursework;

public class Driver {
    private int driverID;
    private String name;

    private int age;
    private int points;

    private String team;
    private String car;

    public Driver(int driverID, String name,  int age, int points, String team, String car) {
        this.driverID = driverID;
        this.name = name;
        this.age = age;
        this.points = points;
        this.team = team;
        this.car = car;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}