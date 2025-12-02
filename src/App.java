
import controllers.BrandController;
import models.Brand;
import test.TestData;

public class App {
    public static void main(String[] args) {
        String fila = "A";

        Brand[] brands = TestData.createBrands();
        BrandController ctrl = new BrandController();
        Brand[] sorted = ctrl.sortSelectionDesc(brands);
                
        System.out.println("FILA " + fila + " - Lista ordenada:");
        for (Brand b : sorted)
            System.out.println(b);

        System.out.println("----Binario----");
        Brand brand = ctrl.binarySearchByValidYears(brands, 0, false);
        System.out.println(brand.toString());

    }
}
