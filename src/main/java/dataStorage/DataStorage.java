package dataStorage;

import model.Author;
import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DataStorage {

    private static List<Book> bookList = new ArrayList<>();
    private static List<Author> authorList = new ArrayList<>();
    private static List<Category> categoryList = new ArrayList<>();

    public static List<Book> getBookList() {
        return bookList;
    }

    public static void setBookList(List<Book> bookList) {
        DataStorage.bookList = bookList;
    }

    public static List<Author> getAuthorList() {
        return authorList;
    }

    public static void setAuthorList(List<Author> authorList) {
        DataStorage.authorList = authorList;
    }

    public static List<Category> getCategoryList() {
        return categoryList;
    }

    public static void setCategoryList(List<Category> categoryList) {
        DataStorage.categoryList = categoryList;
    }
}
