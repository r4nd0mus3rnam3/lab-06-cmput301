package com.example.code;

/**
* This is a class that defines a City.
*/
public class City implements Comparable {
    private String name;
    private String province;

    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.name.compareTo(city.getName()); // this.city refers to the city name
    }

}

