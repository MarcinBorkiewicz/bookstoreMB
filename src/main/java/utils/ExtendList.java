package utils;

import dataStorage.DataStorage;
import model.Author;
import model.Category;

import java.util.List;
import java.util.Scanner;

public class ExtendList {

    public void addAuthor() {

        DataStorage dataStorage = new DataStorage();
        List<Author> authorList = dataStorage.getAuthorList();

        System.out.println(generateIDOfAuthor(authorList));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of author");
        String name = scanner.next();
        String age;
        int result = -1;
        do {
            System.out.println("Please enter the age of author");
            age = scanner.next();
            if (age.matches("-?\\d+(\\.\\d+)?")) {
                result = Integer.parseInt(age);
            }
        } while ((result > 120) || (result < 0));
        Author author = new Author(generateIDOfAuthor(authorList), name, Integer.parseInt(age));
        authorList.add(author);

        }

    private int generateIDOfAuthor(List<Author> authors) {
        return authors.stream().mapToInt(x -> x.getId()).max().getAsInt() + 1;
    }


    private void addCategory() {

        DataStorage dataStorage = new DataStorage();
        List<Category> categoryList = dataStorage.getCategoryList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the category");
        String category = scanner.next();
        System.out.println("Please enter the priority of the category ");
        int priority = scanner.nextInt();

        Category category1 = new Category(generateIDOfCategory(categoryList),category, priority);
        categoryList.add(category1);

    }

    private int generateIDOfCategory(List<Category> listOfCategories) {
        return listOfCategories.stream().mapToInt(x -> x.getId()).max().getAsInt() + 1;
    }


}
