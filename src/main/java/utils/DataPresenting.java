package utils;

import model.Author;
import model.Book;
import model.Category;

import java.util.List;

public class DataPresenting {
    static void showData(List<Book> listOfBooks, List<Author> listOfAuthors, List<Category> listOfCategories) {
        DataPresenting dataPresenting = new DataPresenting();
        dataPresenting.showBooks(listOfBooks);
    }

    public void showCategories(List<Category> categoryList) {
        for (Category c : categoryList) {
            System.out.println(c.toString());
        }
    }

    public void showAuthors(List<Author> listOfAuthors) {
        for (Author a : listOfAuthors) {
            System.out.println(a.toString());
        }
    }

    public void showBooks(List<Book> bookList) {
        for (Book b : bookList) {
            System.out.println(b.toString());
        }
    }
}
