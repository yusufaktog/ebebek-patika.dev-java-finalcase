import com.sun.source.doctree.TextTree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private final Map<String, Phone> phones;
    private final Map<String, Notebook> notebooks;

    public ProductService() {
        this.phones = new LinkedHashMap<>();
        this.notebooks = new LinkedHashMap<>();

    }

    public Phone getPhoneById(String phoneId) {
        return phones.get(phoneId);
    }

    public void addPhone(Phone phone) {
        phones.put(phone.getId(), phone);
    }

    public String deletePhoneById(String phoneId) {
        phones.remove(phoneId);
        return "Phone ID:" + phoneId + " has been deleted";
    }

    public void updatePhone(String phoneId, Phone phone) {
        phones.put(phoneId, phone);
    }

    public List<Phone> listAllPhones() {
        return new LinkedList<>(phones.values());
    }

    public List<Phone> filterPhonesByBrandName(String brandName) {
        return listAllPhones().stream().filter(phone -> phone.getBrand().getName().equals(brandName)).
                collect(Collectors.toList());
    }

    public Notebook getNotebookById(String notebookId) {
        return notebooks.get(notebookId);
    }

    public void addNotebook(Notebook phone) {
        notebooks.put(phone.getId(), phone);
    }

    public String deleteNotebookById(String notebookId) {
        notebooks.remove(notebookId);
        return "Notebook ID:" + notebookId + " has been deleted";
    }

    public void updateNotebook(String notebookId, Notebook phone) {
        notebooks.put(notebookId, phone);
    }

    public List<Notebook> listAllNotebooks() {
        return new LinkedList<>(notebooks.values());
    }

    public List<Notebook> filterNotebooksByBrandName(String brandName) {
        return listAllNotebooks().stream().filter(phone -> phone.getBrand().getName().equals(brandName)).
                collect(Collectors.toList());
    }

    public void printPhones() {

        System.out.println("-----------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s", "PHONE ID", "NAME", "PRICE", "DISCOUNT",
                "BRAND NAME", "STORAGE", "SCREEN SIZE", "BATTERY", "RAM", "COLOR");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------");
        listAllPhones().forEach(phone -> {

            System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s", phone.getId(), phone.getName(),
                    phone.getPrice(), phone.getDiscount(), phone.getBrand().getName(), phone.getStorage().toString(),
                    phone.getScreenSize(), phone.getBattery(), phone.getRam().toString(), phone.getColor());
            System.out.println();

        });
    }

    public void printNotebooks() {

        System.out.println("-----------------------------------------------------------------------------------------" +
                "----------------------------------------------------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s %15s", "Notebook ID", "NAME", "PRICE", "DISCOUNT",
                "BRAND NAME", "HDD","SSD", "SCREEN SIZE", "RAM");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------" +
                "----------------------------------------------------------");
        listAllNotebooks().forEach(notebook -> {

            System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s %15s", notebook.getId(), notebook.getName(),
                    notebook.getPrice(), notebook.getDiscount(), notebook.getBrand().getName(),
                    notebook.getHdd().toString(), notebook.getSsd().toString(), notebook.getScreenSize(),
                    notebook.getRam().toString());
            System.out.println();

        });
    }

}