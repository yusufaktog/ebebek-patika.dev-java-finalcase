package service;

import entity.Notebook;

import java.util.*;

import java.util.stream.Collectors;

public class NotebookService {

    private final Map<String, Notebook> notebooks;

    public NotebookService() {
        this.notebooks = new HashMap<>();
    }

    public Notebook getNotebookById(String notebookId) {
        return notebooks.get(notebookId);
    }

    public void addNotebook(Notebook notebook) {
        notebooks.put(notebook.getId(), notebook);
        System.out.println("Notebook: " + notebook.getId() + " has been created");

    }

    public void deleteNotebookById(String notebookId) {
        notebooks.remove(notebookId);
        System.out.println("Notebook ID: " + notebookId + " has been deleted");
    }

    public void updateNotebook(String notebookId, Notebook notebook) {
        notebooks.put(notebookId, notebook);
    }

    public List<Notebook> listAllNotebooks() {
        return new LinkedList<>(notebooks.values());
    }

    public List<Notebook> filterNotebooksByBrandName(String brandName) {
        return listAllNotebooks().stream().filter(notebook -> notebook.getBrand().getName().equalsIgnoreCase(brandName))
                .collect(Collectors.toList());
    }

    public void printNotebooks(List<Notebook> notebooks) {

        System.out.println("-----------------------------------------------------------------------------------------" +
                "-------------------------------------------------------");
        System.out.printf("%15s %25s %15s %15s %15s %10s %10s %15s %10s", "Notebook ID", "NAME", "PRICE",
                "DISCOUNT", "BRAND NAME", "HDD", "SSD", "SCREEN SIZE", "RAM");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------" +
                "-------------------------------------------------------");
        notebooks.forEach(notebook -> {

            System.out.printf("%15s %25s %15s %15s %15s %10s %10s %15s %10s", notebook.getId(), notebook.getName(),
                    notebook.getPrice(), notebook.getDiscount(), notebook.getBrand().getName(),
                    notebook.getHdd().toString(), notebook.getSsd().toString(), notebook.getScreenSize(),
                    notebook.getRam().toString());
            System.out.println();

        });
    }


    public void printFilteredNotebooks(String brand) {
        printNotebooks(filterNotebooksByBrandName(brand));
    }
}
