import entity.Brand;
import entity.Notebook;
import entity.Phone;
import enums.Color;
import enums.Ram;
import enums.Screen;
import enums.Storage;
import exception.EntityNotFoundException;
import service.BrandService;
import service.NotebookService;
import service.PhoneService;

import java.util.*;
import java.util.List;

public class Main {
    private final BrandService brandService;
    private final PhoneService phoneService;
    private final NotebookService notebookService;

    public Main(BrandService brandService, PhoneService phoneService, NotebookService notebookService) {
        this.brandService = brandService;
        this.phoneService = phoneService;
        this.notebookService = notebookService;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose an option: ");
        return scanner.nextLine();
    }

    public String showPanelOptions(String panelName) {
        System.out.println("===================================");
        System.out.println("Welcome To The " + panelName + " Panel");
        System.out.println("===================================");
        System.out.printf("""
                        1) Add %s\s
                        2) Get %s By Id\s
                        3) Show %s List\s
                        4) Delete %s By Id\s
                        5) Filter By Brand
                        0) MAIN MENU
                        """,
                panelName, panelName, panelName, panelName);
        return getInput();
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

                    this.phoneService.addPhone(new Phone(
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
                System.out.print("Phone ID:");
                this.phoneService.printPhones(List.of(this.phoneService.getPhoneById(scanner.nextLine())));
                break;
            case "3":
                this.phoneService.printPhones(this.phoneService.listAllPhones());
                break;
            case "4":
                System.out.print("Phone ID:");
                this.phoneService.deletePhoneById(scanner.nextLine());
                break;
            case "5":
                System.out.print("Brand Name:");
                this.phoneService.printFilteredPhones(scanner.nextLine());
                break;
            case "0":
                return false;
            default:
                System.out.println("Invalid Option");
                break;
        }
        return true;

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
                    this.notebookService.addNotebook(new Notebook(
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
                System.out.print("Notebook ID:");
                this.notebookService.printNotebooks(List.of(this.notebookService.getNotebookById(scanner.nextLine())));
                break;
            case "3":
                this.notebookService.printNotebooks(this.notebookService.listAllNotebooks());
                break;
            case "4":
                System.out.print("Notebook ID:");
                this.notebookService.deleteNotebookById(scanner.nextLine());
                break;
            case "5":
                System.out.print("Brand Name:");
                this.notebookService.printFilteredNotebooks(scanner.nextLine());
                break;
            case "0":
                return true;
            default:
                System.out.println("Invalid Option");
                break;
        }
        return false;
    }

    static final String options = "1) Notebook Panel\n2) Phone Panel \n3) Show Brands \n0) Exit";

    public static void main(String[] args) {
        Main main = new Main(new BrandService(), new PhoneService(), new NotebookService());

        main.brandService.addBrand(new Brand("Samsung"));
        main.brandService.addBrand(new Brand("Lenovo"));
        main.brandService.addBrand(new Brand("Apple"));
        main.brandService.addBrand(new Brand("Huawei"));
        main.brandService.addBrand(new Brand("Casper"));
        main.brandService.addBrand(new Brand("Asus"));
        main.brandService.addBrand(new Brand("HP"));
        main.brandService.addBrand(new Brand("Xiaomi"));
        main.brandService.addBrand(new Brand("Monster"));

        while (true) {
            System.out.println("---------");
            System.out.println("MAIN MENU");
            System.out.println("---------");
            System.out.println(options);

            switch (main.getInput()) {
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
                case "0":
                    return;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }

    }

    private <T> T convertToEnumType(String value, String enumName, T[] values) {
        if (enumTypeExist(values, value)) {
            return Arrays.stream(values)
                    .filter(ram -> ram.toString().equalsIgnoreCase(value))
                    .toList().get(0);
        } else {
            throw new EntityNotFoundException("We do not have any products with this feature in our store yet. " +
                    enumName + ": " + value +
                    "\nIn this category, we only have the following options:\n" + Arrays.toString(values));
        }
    }

    private boolean enumTypeExist(Object[] list, String value) {
        return Arrays.stream(list).anyMatch(o -> o.toString().equalsIgnoreCase(value));
    }

}