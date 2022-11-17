import entity.Brand;
import entity.Notebook;
import entity.Phone;
import enums.*;
import exception.EntityNotFoundException;
import service.BrandService;
import service.ProductService;

import java.util.*;
import java.util.List;

import static enums.EnumHandler.convertToEnumType;

public class Main {
    private final BrandService brandService;
    private final ProductService productService;
    static final String options = """
            1) Notebook Panel
            2) Phone Panel\s
            3) Show Brands\s
            4) Get Product By Id\s
            5) Delete Product By Id\s
            6) Filter All Products By Brand Name\s
            0) Exit""";

    public Main(BrandService brandService, ProductService productService) {
        this.brandService = brandService;
        this.productService = productService;
    }

    public String getInput(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine();
    }

    public String showPanelOptions(String panelName) {
        System.out.println("===================================");
        System.out.println("Welcome To The " + panelName + " Panel");
        System.out.println("===================================");
        System.out.printf("""
                        1) Add %s\s
                        2) Show %s List\s
                        3) Filter By Brand\s
                        0) MAIN MENU
                        """,
                panelName, panelName);
        return getInput("Choice: ");
    }

    public boolean handlePhoneOperations(String option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                System.out.println("!! Type all the input separated with commas !!");
                System.out.println("Fields  => Name,    Discount, stock, price, brand name, ram, screen size, color," +
                        "battery, storage");
                System.out.println("Example => Note 10, 5,        1000,  3500,  Xiaomi,     4GB , 6.3,        Black," +
                        "3200,  64GB ");
                // get rid of whitespaces
                String[] input = scanner.nextLine().split(",");
                input = Arrays.stream(input).map(String::trim).toArray(String[]::new);

                if (input.length <= 1) {
                    System.out.println("Your input does not contain ',' please separate your input with ',' ");
                    break;
                }

                if (input.length != 10) {
                    System.out.println("Input Miss match, required 10 inputs got " + input.length);
                    break;
                }

                try {

                    this.productService.createProduct(new Phone(
                            input[0],
                            Double.parseDouble(input[1]),
                            Integer.parseInt(input[2]),
                            Double.parseDouble(input[3]),
                            brandService.getBrandByName(input[4]),
                            convertToEnumType(input[5], Ram.class.getSimpleName(), Ram.values()),
                            convertToEnumType(input[6], Screen.class.getSimpleName(), Screen.values()),
                            convertToEnumType(input[7], Color.class.getSimpleName(), Color.values()),
                            Integer.parseInt(input[8]),
                            convertToEnumType(input[9], Storage.class.getSimpleName(), Storage.values()))

                    );
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input...");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "2":
                this.productService.printFilteredProducts(Category.PHONE);
                break;
            case "3":
                System.out.print("Brand Name:");
                try {
                    this.productService.printFilteredProducts(scanner.nextLine(), Category.PHONE);

                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "0":
                return true;
            default:
                System.out.println("Invalid Option");
                break;
        }
        return false;

    }

    public boolean handleNotebookOperations(String option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                System.out.println("!! Type all the input separated with commas !!");
                System.out.println("Fields  => Name,     Discount, stock,  price,  brand name, ram,  screen size," +
                        " hdd, ssd");
                System.out.println("Example => Abra A5,  15,       1 000,  10000,  Monster,    8GB,    15.6, " +
                        "1(TB || GB || None),  256(TB || GB || None)");

                // get rid of whitespaces
                String[] input = scanner.nextLine().split(",");
                input = Arrays.stream(input).map(String::trim).toArray(String[]::new);

                if (input.length == 1) {
                    System.out.println("Your input does not contain ',' please separate your input with ',' ");
                    break;
                }
                if (input.length != 9) {
                    System.out.println("Input Miss match, required 9 inputs got " + input.length);
                    break;
                }

                try {
                    this.productService.createProduct(new Notebook(
                            input[0],
                            Double.parseDouble(input[1]),
                            Integer.parseInt(input[2]),
                            Double.parseDouble(input[3]),
                            brandService.getBrandByName(input[4]),
                            convertToEnumType(input[5], Ram.class.getSimpleName(), Ram.values()),
                            convertToEnumType(input[6], Screen.class.getSimpleName(), Screen.values()),
                            convertToEnumType(input[7], Storage.class.getSimpleName(), Storage.values()),
                            convertToEnumType(input[8], Storage.class.getSimpleName(), Storage.values())

                    ));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input...");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "2":
                this.productService.printFilteredProducts(Category.NOTEBOOK);
                break;
            case "3":
                System.out.print("Brand Name:");
                try {
                    this.productService.printFilteredProducts(scanner.nextLine(), Category.NOTEBOOK);

                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            case "0":
                return true;
            default:
                System.out.println("Invalid Option");
                break;
        }
        return false;
    }

    public static void main(String[] args) {
        Main main = new Main(new BrandService(), new ProductService());

        // manually create default brands
        main.brandService.addBrand(new Brand("Samsung"));
        main.brandService.addBrand(new Brand("Lenovo"));
        main.brandService.addBrand(new Brand("Apple"));
        main.brandService.addBrand(new Brand("Huawei"));
        main.brandService.addBrand(new Brand("Casper"));
        main.brandService.addBrand(new Brand("Asus"));
        main.brandService.addBrand(new Brand("HP"));
        main.brandService.addBrand(new Brand("Xiaomi"));
        main.brandService.addBrand(new Brand("Monster"));

        main.productService.createProduct(new Notebook("Abra A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("B0000000009"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.createProduct(new Notebook("Tulpar A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("B0000000009"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.createProduct(new Notebook("Xsbith A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("B0000000006"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.createProduct(new Notebook("Excalibur A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("B0000000005"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.createProduct(new Notebook("Celeron A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("B0000000005"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.createProduct(new Phone("Note 8", 10, 250, 3500.0,
                main.brandService.getBrandById("B0000000008"), Ram.GB4, Screen.PHONE_MEDIUM,
                Color.BLACK, 4000, Storage.GB256));
        main.productService.createProduct(new Phone("Note 10 Pro", 10, 250, 3500.0,
                main.brandService.getBrandById("B0000000008"), Ram.GB4, Screen.PHONE_MEDIUM,
                Color.GREEN, 4000, Storage.GB256));
        main.productService.createProduct(new Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("B0000000001"), Ram.GB4, Screen.PHONE_MEDIUM,
                Color.BLUE, 4000, Storage.GB256));
        main.productService.createProduct(new Phone("Note 21", 10, 250, 3500.0,
                main.brandService.getBrandById("B0000000002"), Ram.GB4, Screen.PHONE_MEDIUM,
                Color.YELLOW, 4000, Storage.GB256));
        main.productService.createProduct(new Phone("Note 2", 10, 250, 3500.0,
                main.brandService.getBrandById("B0000000004"), Ram.GB4, Screen.PHONE_MEDIUM,
                Color.YELLOW, 4000, Storage.GB256));
        main.productService.createProduct(new Phone("Note 1", 10, 250, 3500.0,
                main.brandService.getBrandById("B0000000003"), Ram.GB4, Screen.PHONE_MEDIUM,
                Color.YELLOW, 4000, Storage.GB256));
        while (true) {
            System.out.println("---------");
            System.out.println("MAIN MENU");
            System.out.println("---------");
            System.out.println(options);

            switch (main.getInput("Choose an option: ")) {
                case "1":
                    while (true) {
                        String option = main.showPanelOptions("Notebook");
                        if (main.handleNotebookOperations(option))
                            break;
                    }

                    break;
                case "2":
                    while (true) {
                        String option = main.showPanelOptions("Phone");
                        if (main.handlePhoneOperations(option))
                            break;
                    }

                    break;
                case "3":
                    main.brandService.printBrands();
                    break;

                case "4":
                    try {
                        main.productService.printProduct(
                                main.productService.getProductById(main.getInput("Product ID: ")));
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "5":
                    try {
                        main.productService.deleteProductById(main.getInput("Product ID: "));

                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "6":
                    main.productService.printFilteredProducts(main.getInput("Brand: "), Category.NONE);

                    break;
                case "0":
                    return;

                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }

    }
}