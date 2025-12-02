import models.Brand;
import models.CarModel;
import models.CarYear;

public class TestData {
        public static Brand[] createBrands() {
                return new Brand[] {
                                new Brand("Honda", new CarModel[] {
                                                new CarModel("Civic",
                                                                new CarYear[] { new CarYear(2018, true),
                                                                                new CarYear(2019, false) }),
                                                new CarModel("Accord",
                                                                new CarYear[] { new CarYear(2017, true),
                                                                                new CarYear(2020, true) })
                                }),
                                new Brand("Toyota", new CarModel[] {
                                                new CarModel("Corolla",
                                                                new CarYear[] { new CarYear(2016, true),
                                                                                new CarYear(2019, true) }),
                                                new CarModel("Camry",
                                                                new CarYear[] { new CarYear(2015, false),
                                                                                new CarYear(2021, true) })
                                }),
                                new Brand("Ford", new CarModel[] {
                                                new CarModel("Mustang", new CarYear[] { new CarYear(2016, true) }),
                                                new CarModel("F150", new CarYear[] { new CarYear(2019, true) })
                                })
                };
        }
}