package controllers;

import models.Brand;

public class BrandController {

    public Brand[] sortSelectionDesc(Brand[] brands) {
        Brand[] a = brands;
        for (int i = 0; i < a.length - 1; i++) {
            int mx = i;
            for (int j = i + 1; j < a.length; j++)
                if (a[j].getTotalValidYears() > a[mx].getTotalValidYears())
                    mx = j;
            Brand tmp = a[i];
            a[i] = a[mx];
            a[mx] = tmp;
        }
        return a;
    }


    public Brand binarySearchByValidYears(Brand[] brands, int validYears, boolean isAscending) {
        int lo = 0, hi = brands.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int mv = brands[mid].getTotalValidYears();
            if (mv == validYears)
                return brands[mid];
            if (isAscending) {
                if (validYears < mv)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if (validYears > mv)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
        }
        return null;
    }
}
