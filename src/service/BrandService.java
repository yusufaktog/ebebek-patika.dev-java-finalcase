package service;

import entity.Brand;

import java.util.*;


public class BrandService {
    private final Map<String, Brand> brands;

    public BrandService() {
        brands = new HashMap<>();
    }

    public Brand getBrandById(String brandId) {
        return brands.get(brandId);
    }

    public void addBrand(Brand brand) {
        brands.put(brand.getId(), brand);
    }

    public String deleteBrandById(String brandId) {
        brands.remove(brandId);
        return "product.Brand ID:" + brandId + " has been deleted";
    }

    public void updateBrand(String brandId, Brand brand) {
        brands.put(brandId, brand);
    }

    public List<Brand> listAllBrands() {
        List<Brand> unsorted = new ArrayList<>(brands.values());

        unsorted.sort(Comparator.comparing(Brand::getName));

        return unsorted;
    }

    public void printBrands() {
        System.out.println("=============================");
        System.out.println("ID \t\t\t|\tNAME\t\t ");
        System.out.println("-----------------------------");
        listAllBrands().forEach(brand -> {
            System.out.printf("%s\t|\t%s\n", brand.getId(), brand.getName());
        });
        System.out.println("=============================");

    }

    public Brand getBrandByName(String brandName) {
        final Brand[] brand = new Brand[1];
        brands.forEach((s1, b) -> {
            if(b.getName().equals(brandName))
                brand[0] =  b;
        });
        return brand[0];
    }
}