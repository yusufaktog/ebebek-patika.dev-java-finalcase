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
        return "Brand ID:" + brandId + " has been deleted";
    }

    public void updateBrand(String brandId, Brand brand) {
        brands.put(brandId, brand);
    }

    public List<Brand> listAllBrands() {
        List<Brand> unsorted = new ArrayList<>(brands.values());

        unsorted.sort(Comparator.comparing(Brand::getName));

        return unsorted;
    }

}