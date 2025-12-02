import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import controllers.BrandController;
import models.Brand;

public class Main {
    public static void main(String[] args) {
        String fila = "A";
        int s1 = 8, s2 = 10;
        File f = new File("student.env");
        if (f.exists()) {
            try (FileInputStream fis = new FileInputStream(f)) {
                Properties p = new Properties();
                p.load(fis);
                if (p.getProperty("FILA_ESTUDIANTE") != null)
                    fila = p.getProperty("FILA_ESTUDIANTE").trim().toUpperCase();
                if (p.getProperty("SEARCH1") != null)
                    s1 = Integer.parseInt(p.getProperty("SEARCH1").trim());
                if (p.getProperty("SEARCH2") != null)
                    s2 = Integer.parseInt(p.getProperty("SEARCH2").trim());
            } catch (Exception e) {
                /* ignore */ }
        }

        Brand[] brands = TestData.createBrands();
        BrandController ctrl = new BrandController();
        Brand[] sorted;
        switch (fila) {
            case "B":
                sorted = ctrl.sortSelectionAsc(brands);
                break;
            case "C":
                sorted = ctrl.sortInsertionDesc(brands);
                break;
            case "D":
                sorted = ctrl.sortBubbleDesc(brands);
                break;
            default:
                sorted = ctrl.sortSelectionDesc(brands);
                break;
        }

        System.out.println("FILA " + fila + " - Lista ordenada:");
        for (Brand b : sorted)
            System.out.println(b);

        boolean asc = fila.equals("B");
        System.out.println("\nBuscar " + s1 + ": " + (ctrl.binarySearchByValidYears(sorted, s1, asc)));
        System.out.println("Buscar " + s2 + ": " + (ctrl.binarySearchByValidYears(sorted, s2, asc)));
    }
}
