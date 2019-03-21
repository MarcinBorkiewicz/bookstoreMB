package functions;


import model.Book;

import java.util.*;
import java.util.stream.Collectors;


public class BookFunctions {
    public Book getBookByIsbnFor(List<Book> bookList, int isbn) {

        Book book = null;
        if (bookList == null) {
            return null;
        } else {
            for (Book b : bookList) {
                if (b.getIsbnNumber() == isbn) {
                    book = b;
                }
            }
        }
        return book;
    }

    public Book getBooksByIsbnStream(List<Book> bookList, int isbn) {
        Book book = null;
        if (bookList == null) {
            return null;
        } else {
            book = bookList.stream()
                    .findFirst()
                    .filter(x -> x.getIsbnNumber() == isbn)
                    .orElse(null);
            return book;
        }
    }

    public List<Book> getTwoLastBooksFor(List<Book> bookList) {
        if (bookList == null) {
            return null;
        } else {
            return bookList.subList(bookList.size() - 2, bookList.size());
        }
    }

    public List<Book> getTwoLastBooksStream(List<Book> bookList) {
        if (bookList == null) {
            return null;
        } else {
            return bookList.stream().skip(4).collect(Collectors.toList());
        }
    }

    public Book earliestReleasedBook1(List<Book> bookList) {
        Book book = bookList.get(0);
        for (Book book1 : bookList) {
            if (book1.getYear() < book.getYear()) {
                book = book1;
            }
        }
        return book;
    }

    public Book earliestReleasedBook2(List<Book> bookList) {
        return bookList.stream()
                .sorted(Comparator.comparing(x -> x.getYear()))
                .findFirst().get();

    }

    public Book latestReleasedBook1(List<Book> bookList) {
        Book book = bookList.get(0);
        for (Book book1 : bookList) {
            if (book1.getYear() > book.getYear()) {
                book = book1;
            }
        }
        return book;
    }

    public Book lastestReleasedBoook2(List<Book> bookList) {
        return bookList.stream()
                .max(Comparator.comparing(x -> x.getYear()))
                .get();
    }

    public int sumOfAllYears1(List<Book> bookList) {
        int sum = 0;
        for (Book book1 : bookList) {
            sum = sum + book1.getYear();
        }
        return sum;
    }

    public int sumOfAllYears2(List<Book> bookList) {
        return bookList.stream()
                .mapToInt(x -> x.getYear()).sum();
    }

    public int numberOfBooksReleasedBefore20071(List<Book> bookList) {
        int count = 0;
        for (Book book1 : bookList) {
            if (book1.getYear() > 2007) {
                count++;
            }
        }
        return count;
    }

    public int numberOfBooksReleasedBefore20072(List<Book> bookList) {
        return (int) bookList.stream()
                .filter(x -> x.getYear() > 2007)
                .mapToInt(x -> x.getYear())
                .count();
    }

    public boolean checkAllBooksReleasedAfter20001(List<Book> bookList) {
        boolean result = true;
        for (Book book1 : bookList) {
            if (book1.getYear() < 2001) {
                result = false;
            }
        }
        return result;
    }

    public boolean checkAllBooksReleasedAfter20002(List<Book> bookList) {
        return bookList.stream()
                .anyMatch(x -> x.getYear() < 2001);
    }

    public double averageReleasedYear1(List<Book> bookList) {
        double average = 0;
        int a = 0;
        for (Book book1 : bookList) {
            average = average + book1.getYear();
        }
        return average / a;
    }

    public double averageReleasedBooks(List<Book> bookList) {
        return bookList.stream()
                .mapToDouble(x -> x.getYear())
                .average().getAsDouble();
    }

    public boolean checkAnyBooksReleasedBefore20031(List<Book> bookList) {
        boolean result = false;
        for (Book book1 : bookList) {
            if (book1.getYear() < 2003) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkAnyBooksReleasedBefore20032(List<Book> bookList) {
        return bookList.stream()
                .anyMatch(x -> x.getYear() < 2003);
    }

    public List<Book> getBooksStartedWithCAndReleasedAfter20071(List<Book> bookList) {
        List<Book> bookList2 = new ArrayList<>();
        for (Book book1 : bookList) {
            if ((book1.getYear() > 2007) && (book1.getTitle().startsWith("C"))) {
                bookList2.add(book1);
            }
        }
        return bookList2;
    }

    public List<Book> getBooksStartedWithCAndReleasedAfter20072(List<Book> bookList) {
        return bookList.stream()
                .filter(x -> x.getYear() > 2007)
                .filter(x -> x.getTitle().startsWith("C"))
                .collect(Collectors.toList());

    }

    public List<Book> add100Years1(List<Book> bookList) {
        for (Book book1 : bookList) {
            book1.setYear(book1.getYear() + 100);
        }
        return bookList;
    }

    public List<Book> add100Years2(List<Book> bookList) {
        return bookList.stream()
                .map(book -> new Book(book.getId(), book.getTitle(), book.getIsbnNumber(), book.getYear() + 100,
                        book.getBezel(), book.getAuthors(), book.getCategory())).collect(Collectors.toList());
    }

    public List<String> getBooksYearDivBy21(List<Book> bookList) {
        List<String> bookList2 = new ArrayList<>();
        for (Book book1 : bookList) {
            if (book1.getYear() % 2 == 0) {
                bookList2.add(book1.getTitle());
            }
        }
        return bookList2;

    }

    public List<String> getBooksYearDivBy22(List<Book> bookList) {
        return bookList.stream()
                .filter(x -> x.getYear() % 2 == 0)
                .map(x -> x.getTitle())
                .collect(Collectors.toList());
    }

    public Map<Integer, Book> getMapOfBooksAndIsbn1(List<Book> bookList) {
        Map<Integer, Book> mapOfBooksAndIsbn = new TreeMap<>();
        for (Book book1 : bookList) {
            mapOfBooksAndIsbn.put(book1.getIsbnNumber(), book1);
        }
        return mapOfBooksAndIsbn;
    }

    public Map<Integer, Book> getMapOfBooksAndIsbn2(List<Book> bookList) {
        return bookList.stream()
                .collect(Collectors.toMap(x -> x.getIsbnNumber(), x -> x));
    }

//    public List<Book> sortBooksFromOldest1(List<Book> bookList) {
//        Collections.sort();
//    }

//    public List<Book> sortBooksFromOldest2 (List<Book> bookList) {
//
//    }



}








