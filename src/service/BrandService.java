package service;

import entity.Brand;
import exception.EntityNotFoundException;

import java.util.*;


public class BrandService {
    private final Map<String, Brand> brands;

    public BrandService() {
        brands = new HashMap<>();
    }

    public Brand getBrandById(String brandId) {
        var result = brands.get(brandId);
        if (result == null)
            throw new EntityNotFoundException("Brand Not Found");
        return result;
    }

    public void addBrand(Brand brand) {
        brands.put(brand.getId(), brand);
    }

    public void deleteBrandById(String brandId) {
        var result = brands.remove(brandId);
        System.out.println(result != null ? "Brand ID:" + brandId + " has been deleted" : "Brand Not Found");
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
        if (brands.isEmpty()) {
            System.out.println("There are no brands in the store yet");
            return;
        }
        System.out.println("=============================");
        System.out.println("-----------------------------");
        System.out.println("ID \t\t\t|\tNAME\t\t ");
        System.out.println("-----------------------------");
        listAllBrands().forEach(brand -> {
            System.out.printf("%s\t|\t%s\n", brand.getId(), brand.getName());
        });
        System.out.println("=============================");

    }

    public Brand getBrandByName(String brandName) {

        if (brands.values().stream().noneMatch(brand -> brand.getName().equalsIgnoreCase(brandName))) {
            throw new EntityNotFoundException("Brand: " + "'" + brandName + "'" + " Not Found!");
        }

        return brands.values().stream().filter(brand -> brand.getName().equalsIgnoreCase(brandName)).toList().get(0);

    }
}