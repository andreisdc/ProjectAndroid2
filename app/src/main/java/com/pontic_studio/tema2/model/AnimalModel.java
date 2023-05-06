package com.pontic_studio.tema2.model;

public class AnimalModel extends Object {
    String name;
    String continent;

    public AnimalModel(String name, String continent)
    {
        this.name = name;
        this.continent = continent;
    }

    public String getName()
    {
        return name;
    }

    public String getContinent()
    {
        return continent;
    }


}
