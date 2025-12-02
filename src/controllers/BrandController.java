package controllers;

import models.Brand;

public class BrandController {

    public Brand[] sortSelectionDesc(Brand[] arr) {
        Brand[] a = arr.clone();
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

    public Brand[] sortSelectionAsc(Brand[] arr) {
        Brand[] a = arr.clone();
        for (int i = 0; i < a.length - 1; i++) {
            int mn = i;
            for (int j = i + 1; j < a.length; j++)
                if (a[j].getTotalValidYears() < a[mn].getTotalValidYears())
                    mn = j;
            Brand tmp = a[i];
            a[i] = a[mn];
            a[mn] = tmp;
        }
        return a;
    }

    public Brand[] sortInsertionDesc(Brand[] arr) {
        Brand[] a = arr.clone();
        for (int i = 1; i < a.length; i++) {
            Brand key = a[i];
            int kv = key.getTotalValidYears();
            int j = i - 1;
            while (j >= 0 && a[j].getTotalValidYears() < kv) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

    public Brand[] sortBubbleDesc(Brand[] arr) {
        Brand[] a = arr.clone();
        for (int i = 0; i < a.length - 1; i++) {
            boolean s = false;
            for (int j = 0; j < a.length - 1 - i; j++)
                if (a[j].getTotalValidYears() < a[j + 1].getTotalValidYears()) {
                    Brand t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    s = true;
                }
            if (!s)
                break;
        }
        return a;
    }

    public Brand binarySearchByValidYears(Brand[] a, int key, boolean asc) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int mv = a[mid].getTotalValidYears();
            if (mv == key)
                return a[mid];
            if (asc) {
                if (key < mv)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if (key > mv)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
        }
        return null;
    }
}
