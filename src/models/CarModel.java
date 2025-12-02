package models;

public class CarModel {
    private String name;
    private CarYear[] years;

    public CarModel(String name, CarYear[] years) {
        this.name = name;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public CarYear[] getYears() {
        return years;
    }
}
