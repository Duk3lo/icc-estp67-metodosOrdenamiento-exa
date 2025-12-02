package models;

public class Brand {
    private final String brandName;
    private final CarModel[] models;

    public Brand(String brandName, CarModel[] models) {
        this.brandName = brandName;
        this.models = models;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getName() {
        return brandName;
    }

    public CarModel[] getModels() {
        return models;
    }

    public int getTotalValidYears() {
        if (models == null) return 0;
        int total = 0;
        for (CarModel m : models) {
            if (m == null || m.getYears() == null) continue;
            for (CarYear y : m.getYears()) {
                if (y != null && y.isValid()) total++;
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return brandName + " - Años válidos: " + getTotalValidYears();
    }
}
