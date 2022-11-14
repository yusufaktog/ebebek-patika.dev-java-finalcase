import enums.Ram;
import enums.Screen;
import enums.Storage;

public class Main {
    private final BrandService brandService;
    private final ProductService productService;

    public Main(BrandService brandService, ProductService productService) {
        this.brandService = brandService;
        this.productService = productService;
    }

    public static void main(String[] args) {
        Main main = new Main(new BrandService(), new ProductService());

        main.brandService.addBrand(new Brand("Samsung"));
        main.brandService.addBrand(new Brand("Lenovo"));
        main.brandService.addBrand(new Brand("Apple"));
        main.brandService.addBrand(new Brand("Huawei"));
        main.brandService.addBrand(new Brand("Asus"));
        main.brandService.addBrand(new Brand("HP"));
        main.brandService.addBrand(new Brand("HP"));
        main.brandService.addBrand(new Brand("Xiaomi"));
        main.brandService.addBrand(new Brand("Monster"));


        main.productService.addNotebook(new Notebook("Abra A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000008"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.addNotebook(new Notebook("Abra A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000007"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.addNotebook(new Notebook("Abra A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.addNotebook(new Notebook("Abra A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000005"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));
        main.productService.addNotebook(new Notebook("Abra A5", 10.0, 1000, 14500.0,
                main.brandService.getBrandById("0000000005"), Ram.GB8, Screen.
                PC_MEDIUM, Storage.TB1, Storage.GB256));


        main.productService.addPhone(new Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB4, Screen.PHONE_MEDIUM,
                "Black", 4000, Storage.GB256));
        main.productService.addPhone(new Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB4, Screen.PHONE_MEDIUM,
                "Black", 4000, Storage.GB256));
        main.productService.addPhone(new Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB4, Screen.PHONE_MEDIUM,
                "Black", 4000, Storage.GB256));
        main.productService.addPhone(new Phone("Note 10", 10, 250, 3500.0,
                main.brandService.getBrandById("0000000006"), Ram.GB4, Screen.PHONE_MEDIUM,
                "Black", 4000, Storage.GB256));

//        main.productService.printPhones();

        main.productService.printNotebooks();
    }
}