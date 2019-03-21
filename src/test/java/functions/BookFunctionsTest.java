package functions;

import model.Book;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


class BookFunctionsTest {

    List<Book> bookList;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    Book book6;

    @BeforeEach
    void setUp() {
        bookList = new ArrayList<>();
        book1 = new Book(1, "Piotrus Pan", 1234,
                1988, "T", null, null);
        book2 = new Book(2, "Ogniem i mieczem", 4768,
                1987, "T", null, null);
        book3 = new Book(3, "Potop", 5563,
                1955, "T", null, null);
        book4 = new Book(4, "Kurnik", 5888,
                1936, "T", null, null);
        book5 = new Book(5, "Bagno", 3299,
                2000, "T", null, null);
        book6 = new Book(6, "Ranek", 1231,
                2015, "T", null, null);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);

    }

    @Test
    void getBookByISBN1() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book1, bookFunctions.getBooksByIsbnStream(bookList, 1234));
    }

    @Test
    void getBookByISBN2() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertNull(bookFunctions.getBooksByIsbnStream(bookList, 3245));
    }

    @Test
    void getBookByISBN3() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(null, bookFunctions.getBooksByIsbnStream(null, 1234));

    }

    @Test
    void getBookByISBN4() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book1, bookFunctions.getBookByIsbnFor(bookList, 1234));
    }

    @Test
    void getBookByISBN5() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertNull(bookFunctions.getBookByIsbnFor(bookList, 12358475));
    }

    @Test
    void getBookByISBN6() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(null, bookFunctions.getBookByIsbnFor(null, 1234));
    }

    @Test
    void getTwoLastBooksFor1() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book5);
        bookList2.add(book6);
        Assert.assertEquals(bookList2, bookFunctions.getTwoLastBooksFor(bookList2));
    }

    //    @Test
//    void getTwoLastBooksStream1() {
//        BookFunctions bookFunctions = new BookFunctions();    //TODO Poprawic
//        List<Book> bookList2 = new ArrayList<>();
//        bookList2.add(book5);
//        bookList2.add(book6);
//        Assert.assertEquals(bookList2, bookFunctions.getTwoLastBooksStream(bookList2));
//    }
    @Test
    void earliestReleasedBookFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book3, bookFunctions.earliestReleasedBook1(bookList));
    }

    @Test
    void earliestReleasedBookStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book3, bookFunctions.earliestReleasedBook2(bookList));
    }

    @Test
    void latestReleasedBookFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book6, bookFunctions.latestReleasedBook1(bookList));
    }

    @Test
    void latestReleasedBookStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book6, bookFunctions.lastestReleasedBoook2(bookList));

    }

    @Test
    void sumOfAllYearsFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(11881, bookFunctions.sumOfAllYears1(bookList));
    }

    @Test
    void sumOfAllYearsStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(11881, bookFunctions.sumOfAllYears2(bookList));
    }

    @Test
    void numberOfBooksReleasedPrior2007For() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(1, bookFunctions.numberOfBooksReleasedBefore20071(bookList));
    }

    @Test
    void numberOfBooksReleasedPrior2007Stream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(1, bookFunctions.numberOfBooksReleasedBefore20072(bookList));
    }

    @Test
    void checkIfAllBooksAreReleasedAfter2000For() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(false, bookFunctions.checkAllBooksReleasedAfter20001(bookList));
    }

    @Test
    void checkIfAllBooksAreReleasedAfter2000Stream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(true, bookFunctions.checkAllBooksReleasedAfter20002(bookList));
    }

    @Test
    void averageReleaseYearFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(2011, bookFunctions.averageReleasedYear1(bookList), 0.01);
    }
//
//    @Test
//    void averageReleaseYearStream() {
//        BookFunctions bookFunctions = new BookFunctions();
//        Assert.assertEquals(2011, bookFunctions.averageReleaseYearStream(testListOfBooks), 0.01);
//    }
//
    @Test
    void checkIfAnyBookIsReleasedBefore2003For() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(true, bookFunctions.checkAnyBooksReleasedBefore20031(bookList));
    }

    @Test
    void checkIfAnyBookIsReleasedBefore2003Stream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(true, bookFunctions.checkAnyBooksReleasedBefore20032(bookList));
    }

    @Test
    void getBooksStartingWithCAndReleasedAfter2007for() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> booklist2 = new ArrayList<>();
        booklist2.add(book1);
        booklist2.add(book4);
        Assert.assertEquals(booklist2, bookFunctions.getBooksStartedWithCAndReleasedAfter20071(bookList));

    }

    @Test
    void getBooksStartingWithCAndReleasedAfter2007stream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book4);
        Assert.assertEquals(bookList2, bookFunctions.getBooksStartedWithCAndReleasedAfter20072(bookList));
    }

    @Test
    void add100YearsFor() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);
        bookList2.add(book3);
        bookList2.add(book4);
        bookList2.add(book5);
        bookList2.add(book6);
        Assert.assertEquals(book3.getYear() + 100, bookFunctions.add100Years1(bookList).get(2).getYear());
    }

    @Test
    void add100YearsStream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);
        bookList2.add(book3);
        bookList2.add(book4);
        bookList2.add(book5);
        bookList2.add(book6);
        Assert.assertEquals(book3.getYear() + 100, bookFunctions.add100Years2(bookList2).get(2).getYear());
    }

    @Test
    void getBooksDivisibleBy2For() {
        BookFunctions bookFunctions = new BookFunctions();
        List<String> bookList2 = new ArrayList<>();
        bookList2.add(book1.getTitle());
        bookList2.add(book2.getTitle());
        bookList2.add(book3.getTitle());
        bookList2.add(book6.getTitle());
        Assert.assertEquals(bookList2, bookFunctions.getBooksYearDivBy21(bookList));
    }

    @Test
    void getBooksDivisibleBy2Stream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<String> bookList2 = new ArrayList<>();
        bookList2.add(book1.getTitle());
        bookList2.add(book2.getTitle());
        bookList2.add(book3.getTitle());
        bookList2.add(book6.getTitle());
        Assert.assertEquals(bookList2, bookFunctions.getBooksYearDivBy22(bookList));
    }

    @Test
    void getMapOfIsbnAndBooksFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Map<Integer, Book> mapOfBooksAndIsbn = new TreeMap<>();
        mapOfBooksAndIsbn.put(1231, book1);
        mapOfBooksAndIsbn.put(1232, book2);
        mapOfBooksAndIsbn.put(1233, book3);
        mapOfBooksAndIsbn.put(1234, book4);
        mapOfBooksAndIsbn.put(1235, book5);
        mapOfBooksAndIsbn.put(1236, book6);
        Assert.assertEquals(mapOfBooksAndIsbn, bookFunctions.getMapOfBooksAndIsbn1(bookList));
    }

    @Test
    void getMapOfIsbnAndBooksStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Map<Integer, Book> mapOfBooksAndIsbn = new TreeMap<>();
        mapOfBooksAndIsbn.put(1231, book1);
        mapOfBooksAndIsbn.put(1232, book2);
        mapOfBooksAndIsbn.put(1233, book3);
        mapOfBooksAndIsbn.put(1234, book4);
        mapOfBooksAndIsbn.put(1235, book5);
        mapOfBooksAndIsbn.put(1236, book6);
        Assert.assertEquals(mapOfBooksAndIsbn, bookFunctions.getMapOfBooksAndIsbn2(bookList));
    }

//    @Test
//    void sortBooksFromNewestFor() {
//        BookFunctions bookFunctions = new BookFunctions();
//        List<Book> bookList2 = new ArrayList<>();
//        bookList2.add(book6);
//        bookList2.add(book5);
//        bookList2.add(book4);
//        bookList2.add(book2);
//        bookList2.add(book1);
//        bookList2.add(book3);
//        Assert.assertEquals(bookList2, bookFunctions.sortBooksFromNewestFor(testListOfBooks));
//    }
//
//    @Test
//    void sortBooksFromNewestStream() {
//        BookFunctions bookFunctions = new BookFunctions();
//        List<Book> tempListOfBooks = new ArrayList<>();
//        tempListOfBooks.add(book6);
//        tempListOfBooks.add(book5);
//        tempListOfBooks.add(book4);
//        tempListOfBooks.add(book2);
//        tempListOfBooks.add(book1);
//        tempListOfBooks.add(book3);
//        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromNewestStream(testListOfBooks));
//    }
//
//    @Test
//    void sortBooksFromOldestFor() {
//        BookFunctions bookFunctions = new BookFunctions();
//        List<Book> tempListOfBooks = new ArrayList<>();
//        tempListOfBooks.add(book3);
//        tempListOfBooks.add(book1);
//        tempListOfBooks.add(book2);
//        tempListOfBooks.add(book4);
//        tempListOfBooks.add(book5);
//        tempListOfBooks.add(book6);
//        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromOldestFor(testListOfBooks));
//    }
//
//    @Test
//    void sortBooksFromOldestStream() {
//        BookFunctions bookFunctions = new BookFunctions();
//        List<Book> tempListOfBooks = new ArrayList<>();
//        tempListOfBooks.add(book3);
//        tempListOfBooks.add(book1);
//        tempListOfBooks.add(book2);
//        tempListOfBooks.add(book4);
//        tempListOfBooks.add(book5);
//        tempListOfBooks.add(book6);
//        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromOldestStream(testListOfBooks));
//    }
//
//    @Test
//    void getListOfListsOfBooksFor() {
//        BookFunctions bookFunctions = new BookFunctions();
//        List<List<Book>> mainTempListOfBooks = new ArrayList<>();
//        List<Book> firstTempListOfBooks = new ArrayList<>();
//        List<Book> secondTempListOfBooks = new ArrayList<>();
//        List<Book> thirdTempListOfBooks = new ArrayList<>();
//        firstTempListOfBooks.add(book1);
//        firstTempListOfBooks.add(book2);
//        secondTempListOfBooks.add(book3);
//        secondTempListOfBooks.add(book4);
//        thirdTempListOfBooks.add(book5);
//        thirdTempListOfBooks.add(book6);
//        mainTempListOfBooks.add(firstTempListOfBooks);
//        mainTempListOfBooks.add(secondTempListOfBooks);
//        mainTempListOfBooks.add(thirdTempListOfBooks);
//        System.out.println(testListOfBooks.get(2));
//        Assert.assertEquals(mainTempListOfBooks, bookFunctions.getListOfListsOfBooksFor(testListOfBooks));
//
//    }
//
//    @Test
//    void getListOfListsOfBooksStream() {
//        BookFunctions bookFunctions = new BookFunctions();
//        List<List<Book>> mainTempListOfBooks = new ArrayList<>();
//        List<Book> firstTempListOfBooks = new ArrayList<>();
//        List<Book> secondTempListOfBooks = new ArrayList<>();
//        List<Book> thirdTempListOfBooks = new ArrayList<>();
//        firstTempListOfBooks.add(book1);
//        firstTempListOfBooks.add(book2);
//        secondTempListOfBooks.add(book3);
//        secondTempListOfBooks.add(book4);
//        thirdTempListOfBooks.add(book5);
//        thirdTempListOfBooks.add(book6);
//        mainTempListOfBooks.add(firstTempListOfBooks);
//        mainTempListOfBooks.add(secondTempListOfBooks);
//        mainTempListOfBooks.add(thirdTempListOfBooks);
//        Assert.assertEquals(mainTempListOfBooks, bookFunctions.getListOfListsOfBooksStream(testListOfBooks));
//    }
    }




