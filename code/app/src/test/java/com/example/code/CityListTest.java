package com.example.code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City existingCity = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(existingCity));

        City nonExistingCity = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(nonExistingCity));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City cityToRemove = new City("Edmonton", "Alberta");

        // Ensure the city is there before deleting
        assertTrue(cityList.hasCity(cityToRemove));
        assertEquals(1, cityList.countCities());

        // Delete the city and verify it's gone
        cityList.delete(cityToRemove);
        assertFalse(cityList.hasCity(cityToRemove));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City nonExistingCity = new City("Vancouver", "British Columbia");

        // Verify that trying to delete a non-existent city throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(nonExistingCity);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Saskatoon", "Saskatchewan"));
        assertEquals(2, cityList.countCities());

        cityList.delete(new City("Edmonton", "Alberta"));
        assertEquals(1, cityList.countCities());
    }

}

