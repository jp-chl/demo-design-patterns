package com.jpvr.demodesignpatterns.collections.model;

public class Country {

    private String name;
    private int population;
    private String continent;

    public Country(String name, int population, String continent) {
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    public Country(Country country) {

        this.name = country.name;
        this.population = country.population;
        this.continent = country.continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
} // end class Country
