package service;

import entity.Phone;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneService {
    private final Map<String, Phone> phones;

    public PhoneService() {
        this.phones = new HashMap<>();
    }

    public Phone getPhoneById(String phoneId) {
        return phones.get(phoneId);
    }

    public void addPhone(Phone phone) {
        phones.put(phone.getId(), phone);
        System.out.println("Phone ID: " + phone.getId() + " has been created");

    }

    public void deletePhoneById(String phoneId) {
        var result = phones.remove(phoneId);
        System.out.println(result != null ? "Phone ID: " + phoneId + " has been deleted" : " Product Not Found...");
    }

    public void updatePhone(String phoneId, Phone phone) {
        phones.put(phoneId, phone);
    }

    public List<Phone> listAllPhones() {
        return new LinkedList<>(phones.values());
    }

    public List<Phone> filterPhonesByBrandName(String brandName) {
        return listAllPhones().stream().filter(phone -> phone.getBrand().getName().equalsIgnoreCase(brandName)).
                collect(Collectors.toList());
    }

    public void printPhones(List<Phone> phones) {
        if (phones.isEmpty()) {
            System.out.println("There are no products in the list yet...");
            return;
        }
        System.out.println("-----------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s", "PHONE ID", "NAME", "PRICE", "DISCOUNT",
                "BRAND NAME", "STORAGE", "SCREEN SIZE", "BATTERY", "RAM", "COLOR");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------");
        phones.forEach(phone -> {

            System.out.printf("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s", phone.getId(), phone.getName(),
                    phone.getPrice(), phone.getDiscount(), phone.getBrand().getName(), phone.getStorage().toString(),
                    phone.getScreenSize(), phone.getBattery(), phone.getRam().toString(), phone.getColor());
            System.out.println();

        });
    }

    public void printFilteredPhones(String filter) {
        printPhones(filterPhonesByBrandName(filter));
    }
}
