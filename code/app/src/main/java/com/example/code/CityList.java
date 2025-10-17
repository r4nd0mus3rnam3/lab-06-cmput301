package com.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks if a given city exists in the list.
     * @param city The city to check for.
     * @return boolean Returns true if the city is in the list, false otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This method deletes a city from the list.
     * @param city The city to be deleted.
     * @throws IllegalArgumentException if the city does not exist in the list.
     */
    public void delete(City city) {
        if (!hasCity(city)) {
            throw new IllegalArgumentException("City does not exist in the list.");
        }
        cities.remove(city);
    }

    /**
     * This method returns the number of cities in the list.
     * @return int The count of cities.
     */
    public int countCities() {
        return cities.size();
    }
}
