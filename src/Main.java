import entity.Brand;
import entity.Notebook;
import enums.Ram;
import enums.Screen;
import enums.Storage;
import service.BrandService;
import service.NotebookService;
import service.PhoneService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public String showNotebookPanel() {
        showPanelOptions("Notebook");
        return getInput();
    }

    public String showPhonePanel() {
        showPanelOptions("Phone");
        return getInput();
    }

    public void showPanelOptions(String panelName) {
        System.out.println("===================================");
        System.out.println("Welcome To The " + panelName + " Panel");
        System.out.println("===================================");
        System.out.printf("1) Add %s \n2) Get %s By Id \n3) Show %s List \n4) Delete %s By Id \n5) Filter By Brand\n" +
                        "0) MAIN MENU\n",
                panelName, panelName, panelName, panelName);
    }

    public boolean handleNotebookOperations(String option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case "1":
                System.out.println("!! Type all the input separated with commas !!");
                System.out.println("Fields => Name,     Discount, stock,  price,  brand name, ram,  screen size, hdd, ssd");
                System.out.println("Example => Abra A5,  15,       1 000,  10000,  Monster,    8GB,    15.6, " +
                        "1(TB || GB || None),  256(TB || GB || None)");

                String[] input = scanner.nextLine().split(",");
                input = Arrays.stream(input).map(String::trim).toArray(String[]::new);

                if (input.length == 1) {
                    System.out.println("Your input does not contain ',' please separate your input with ',' ");
                    break;
                }
                if (input.length != 9) {
                    System.out.println("Input Miss match, required 8 inputs got " + input.length);
                    break;
                }
                this.notebookService.addNotebook(new Notebook(
                        input[0],
                        Double.parseDouble(input[1]),
                        Integer.parseInt(input[2]),
                        Double.parseDouble(input[3]),
                        brandService.getBrandByName(input[4]),
                        handleRam(input[5]),
                        handleScreen(input[6]),
                        handleHdd(input[7]),
                        handleSsd(input[8])
                ));
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
                return false;
            default:
                System.out.println("Invalid Option");
                break;
        }
        return true;
    }

    /*    Asus X415ma Celeron, 0,500,5799,Asus,4GB,15.6,128GB,None
        Abra A5, 10, 1000, 10000, Monster, 16GB, 15.6, 1TB, 256GB*/
    private Storage handleSsd(String s) {
        return Arrays.stream(Storage.values()).filter(screen -> screen.toString().equalsIgnoreCase(s)).toList().get(0);

    }

    private Storage handleHdd(String s) {
        return Arrays.stream(Storage.values()).filter(screen -> screen.toString().equalsIgnoreCase(s)).toList().get(0);

    }

    private Screen handleScreen(String s) {
        return Arrays.stream(Screen.values()).filter(screen -> screen.toString().equalsIgnoreCase(s)).toList().get(0);
    }

    private Ram handleRam(String s) {
        return Arrays.stream(Ram.values()).filter(ram -> ram.toString().equalsIgnoreCase(s)).toList().get(0);
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


        main.notebookService.addNotebook(new Notebook("Abra A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000008"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.notebookService.addNotebook(new Notebook("Tulpar A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000007"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.notebookService.addNotebook(new Notebook("Xsbith A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.notebookService.addNotebook(new Notebook("Excalibur A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000005"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.notebookService.addNotebook(new Notebook("Celeron A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000005"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));

        while (true) {
            System.out.println("---------");
            System.out.println("MAIN MENU");
            System.out.println("---------");
            System.out.println(options);


            switch (main.getInput()) {
                case "1":
                    while (true) {
                        String option = main.showNotebookPanel();
                        if (!main.handleNotebookOperations(option))
                            break;
                    }
                    break;
                case "2":
                    main.showPhonePanel();
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


/*


        main.notebookService.addPhone(new Notebook.Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB4, Screen.PHONE_MEDIUM,
                "Black", 4000, Storage.GB256));
        main.notebookService.addPhone(new Notebook.Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB4, Screen.PHONE_MEDIUM,
                "Black", 4000, Storage.GB256));
        main.notebookService.addPhone(new Notebook.Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB4, Screen.PHONE_MEDIUM,
                "Black", 4000, Storage.GB256));
        main.notebookService.addPhone(new Notebook.Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB4, Screen.PHONE_MEDIUM,
                "Black", 4000, Storage.GB256));

//        main.notebookService.printPhones();

        main.notebookService.printNotebooks();*/
    }
}