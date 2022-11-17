package service;

import entity.Notebook;
import entity.Phone;
import entity.Product;
import enums.Category;
import enums.EnumHandler;
import exception.EntityNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService implements Service {

    private final Map<String, Object> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    @Override
    public Object getProductById(String productId) {
        var result = products.get(productId);
        if (result == null) {
            throw new EntityNotFoundException("ERR: Product ID : " + productId + " not found!");
        }
        return result;
    }

    @Override
    public <T extends Product> void createProduct(T product) {
        System.out.println("INFO: " + "Product ID: " + product.getId() + " has been created");
        products.put(product.getId(), product);
    }

    @Override
    public void deleteProductById(String productId) {
        var result = products.remove(productId);
        if (result == null) {
            throw new EntityNotFoundException("ERR: Product ID : " + productId + " not found!");
        }
        System.out.println("INFO: Product ID:" + productId + " has been deleted!");

    }

    @Override
    public <T extends Product> void updateProduct(T product, String productId) {
        var result = products.put(productId, product);

        if (result == null) {
            throw new EntityNotFoundException("ERR: Product ID: " + productId + " not found!");
        }
    }

    @Override
    public List<Object> listAllProducts(Category category) {
        return products.values().stream().filter(o -> o.toString().contains(category.toString())).toList();
    }

    @Override
    public List<Object> filterByBrand(String brandName) {

        return products.values().stream()
                .map(o -> ((Product) o)).filter(product -> product.getBrand().getName().equalsIgnoreCase(brandName))
                .map(p -> ((Object) p)).toList();
    }

    @Override
    public List<Object> filterByCategory(Category category) {
        return products.values().stream()
                .filter(o -> o.toString().contains(category.toString())).toList();
    }

    @Override
    public void printFilteredProducts(String brandFilter, Category categoryFilter) { // validate brand
        var list = filterByBrand(brandFilter)
                .stream().filter(o -> o.toString().contains(categoryFilter.toString())).toList();

        if (list.isEmpty()) {
            System.out.printf("There are no products in the list with Category: '%s' and Brand: '%s' yet...\n",
                    categoryFilter.toString(), brandFilter);
            return;
        }

        if (categoryFilter.toString().equalsIgnoreCase("Notebook"))
            printNotebooksTableFormatted(list);

        else if (categoryFilter.toString().equalsIgnoreCase("Phone"))
            printPhonesTableFormatted(list);
        else
            printProducts(list);
    }

    @Override
    public void printFilteredProducts(Category categoryFilter) {
        var list = filterByCategory(categoryFilter);

        if (list.isEmpty()) {
            System.out.printf("There are no products in the list with Category: '%s' yet...\n", categoryFilter);
            return;
        }

        if (categoryFilter.toString().equalsIgnoreCase("Notebook"))
            printNotebooksTableFormatted(list);

        else if (categoryFilter.toString().equalsIgnoreCase("Phone"))
            printPhonesTableFormatted(list);

        else
            printProducts(list);
    }

    @Override
    public void printProducts(List<Object> products) {
        if (products.isEmpty()) {
            System.out.println("WARN: There are no products in the list yet...");
            return;
        }
        products.forEach(System.out::println);
    }

    @Override
    public void printProduct(Object product) {
        if (product.toString().contains(Category.NOTEBOOK.toString())) {
            printNotebooksTableFormatted(List.of(product));
        } else if (product.toString().contains(Category.PHONE.toString())) {
            printPhonesTableFormatted(List.of(product));
        } else {
            System.out.println(product);
        }
    }

    public void printNotebooksTableFormatted(List<Object> list) {

        System.out.println("-----------------------------------------------------------------------------------------" +
                "-------------------------------------------------------");
        System.out.printf("%15s %25s %15s %15s %15s %10s %10s %15s %10s", "Notebook ID", "NAME", "PRICE",
                "DISCOUNT", "BRAND NAME", "HDD", "SSD", "SCREEN SIZE", "RAM");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------" +
                "-------------------------------------------------------");
        list.stream().map(o -> ((Notebook) o)).forEach(notebook -> {

            System.out.printf("%15s %25s %15s %15s %15s %10s %10s %15s %10s", notebook.getId(), notebook.getName(),
                    notebook.getPrice(), notebook.getDiscount(), notebook.getBrand().getName(),
                    notebook.getHdd().toString(), notebook.getSsd().toString(), notebook.getScreenSize().toString(),
                    notebook.getRam().toString());
            System.out.println();

        });
    }

    public void printPhonesTableFormatted(List<Object> list) {

        System.out.println("-----------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s", "PHONE ID", "NAME", "PRICE", "DISCOUNT",
                "BRAND NAME", "STORAGE", "SCREEN SIZE", "BATTERY", "RAM", "COLOR");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------");
        list.stream().map(o -> ((Phone) o)).forEach(phone -> {

            System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s", phone.getId(), phone.getName(),
                    phone.getPrice(), phone.getDiscount(), phone.getBrand().getName(), phone.getStorage().toString(),
                    phone.getScreenSize().toString(), phone.getBattery(), phone.getRam().toString(), phone.getColor());
            System.out.println();

        });
    }


}
