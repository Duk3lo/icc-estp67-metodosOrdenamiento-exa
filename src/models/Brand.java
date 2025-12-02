package models;

public class Brand {
    private String name;
    private CarModel[] models;

    public Brand(String name, CarModel[] models) {
        this.name = name;
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public CarModel[] getModels() {
        return models;
    }

    public int getTotalValidYears() {
        int total = 0;
        if (models == null) return 0;
        for (CarModel model : models) {
            if (model == null || model.getYears() == null) continue;
            for (CarYear cy : model.getYears()) {
                if (cy != null && cy.isValid()) total++;
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return name + " - Años válidos: " + getTotalValidYears();
    }
}
