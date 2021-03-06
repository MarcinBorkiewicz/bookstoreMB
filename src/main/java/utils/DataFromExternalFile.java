package utils;

import model.Author;
import model.Book;
import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DataFromExternalFile {
    private static List<Book> listOfBooksFromFile = new ArrayList<>();
    private static List<Author> listOfAuthorsFromFile = new ArrayList<>();
    private static List<Category> listOfCategoriesFromFile = new ArrayList<>();
    private static BufferedReader reader;

    public static void readDataFromExternalFiles(String fileCategories, String fileAuthors, String fileBooks) {
        readFile(DataType.CATEGORY, fileCategories);
        readFile(DataType.AUTHOR, fileAuthors);
        readFile(DataType.BOOK, fileBooks);
        DataPresenting.showData(listOfBooksFromFile, listOfAuthorsFromFile, listOfCategoriesFromFile);
    }

    private BufferedReader openAnExternalFile(String file) {
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            return new BufferedReader(isr);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private static String[] splitLine() {
        String line = null;
        try {
            line = reader.readLine();
            return line.split(";");
        } catch (IOException e) {
            return null;
        }
    }

    public static void readFile(DataType dataType, String file) {
        DataFromExternalFile dataFromExternalFile;
        try {
            reader = new DataFromExternalFile().openAnExternalFile(file);
            while (reader.ready()) {
                switch (dataType) {
                    case CATEGORY:
                        readCategoryFile();
                        break;
                    case AUTHOR:
                        readAuthorFile();
                        break;
                    case BOOK:
                        readBookFile();
                }
            }
        } catch (NullPointerException | IOException e) {
            System.out.println("At least one out of three files does not exist. Please ensure all files are uploaded.");
            System.exit(1);
        }
    }

    public static void readCategoryFile() {
        String[] stringArray = splitLine();
        listOfCategoriesFromFile.add(new Category(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
    }

    public static void readAuthorFile() {
        String[] stringArray = splitLine();
        listOfAuthorsFromFile.add(new Author(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
    }

    public static void readBookFile() {
        try {
            String[] stringArray = splitLine();
            Category category = getCategory(stringArray[stringArray.length - 1]);

            List<Author> authorsInTheBook = getAuthors(stringArray[5]);

            Book book = new Book(
                    Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2]),
                    Integer.valueOf(stringArray[3]), stringArray[4], authorsInTheBook, category);
            listOfBooksFromFile.add(book);
        } catch (NullPointerException e) {
            System.out.println("Books weren't found. Please ensure 'books' file exists.");
            System.exit(1);
        }
    }

    private static Category getCategory(String s) {
        try {
            int categoryId = Integer.parseInt(s);
            return listOfCategoriesFromFile.stream()
                    .filter(x -> x.getId() == categoryId)
                    .findFirst().get();
        } catch (NoSuchElementException e) {
            System.out.println("Category wasn't assigned to the book. Please ensure 'category' file exists.");
            System.exit(1);
            return null;
        }
    }

    private static List<Author> getAuthors(String s) {
        String[] authorID = s.split(",");
        List<Author> authorsInTheBook = new ArrayList<>();
        try {

            for (int i = 0; i < authorID.length; i++) {
                int finalI = i;
                authorsInTheBook.add(listOfAuthorsFromFile.stream()
                        .filter(x -> x.getId() == Integer.valueOf(authorID[finalI]))
                        .findFirst().get());
            }
        } catch (NoSuchElementException e) {
            System.out.println("Authors weren't assigned to the book. Please ensure 'authors' file exists.");
            System.exit(1);
            return null;
        }

//        for (int i = 0; i < authorID.length; i++) {
//            for (Author listOfAuthor : listOfAuthorsFromFile) {
//                if (listOfAuthor.getId() == Integer.parseInt(authorID[i])) {
//                    authorsInTheBook.add(listOfAuthor);
//                }
//            }
//        }
        return authorsInTheBook;
    }
}
