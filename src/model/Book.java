package model;

import util.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dominikerlich
 * @created 24/03/2022
 * @project MP1
 */
public class Book implements Serializable {
    // class extent
    private static List<Book> books = new ArrayList<>();
    // composition
    private static Set<Page> allPages = new HashSet<>();
    private Long id;
    // mandatory attribute
    private String title;
    //complex attribute
    private Author primaryAuthor;
    private List<Author> secondaryAuthors = new ArrayList<>();
    // multi-value attribute
    private List<String> publishingHouses;
    private int numberOfPages;
    private Double bookPrice;
    // optional attribute
    private Integer numberOfCopiesSold;
    private Library library;
    // class attribute
    private static List<String> allKnownPublishingHouses;
    // composition
    private List<Page> pages = new ArrayList<>();

    public void addPage(Page page) {
        if (page == null) throw new IllegalArgumentException("page cannot be null");
        if (pages.contains(page) && allPages.contains(page))
            throw new IllegalArgumentException("This page is already assigned to different book");

        pages.add(page);
        allPages.add(page);
    }

    public static List<String> getAllKnownPublishingHouses() {
        return new ArrayList<>(allKnownPublishingHouses);
    }

    public List<Page> getPages() {
        return new ArrayList<>(this.pages);
    }

    public static void setAllKnownPublishingHouses(List<String> allKnownPublishingHouses) {
        if (allKnownPublishingHouses == null || allKnownPublishingHouses.contains(null) || allKnownPublishingHouses.isEmpty())
            throw new IllegalArgumentException("wrong list of all known authors");
        allKnownPublishingHouses.forEach(knowAuthor -> {
            if (!Utils.validateString(knowAuthor)) {
                throw new IllegalArgumentException("wrong publishing house");
            }
        });
        Book.allKnownPublishingHouses = allKnownPublishingHouses;
    }

    public Book(Long id, String title, Author primaryAuthor, Double bookPrice, int numberOfPages, List<String> publishingHouses, Library library) {
        setId(id);
        setPrimaryAuthor(primaryAuthor);
        setTitle(title);
        setBookPrice(bookPrice);
        setNumberOfPages(numberOfPages);
        setPublishingHouses(publishingHouses);
        setLibrary(library);
        books.add(this);
    }

    public Book(Long id, String title, Author primaryAuthor, Double bookPrice, int numberOfPages, List<String> publishingHouses, Library library, List<Page> pages) {
        setId(id);
        setPrimaryAuthor(primaryAuthor);
        setTitle(title);
        setBookPrice(bookPrice);
        setNumberOfPages(numberOfPages);
        setPublishingHouses(publishingHouses);
        setLibrary(library);
        setPages(pages);
        books.add(this);
    }

    public Book(Long id, String title, Author primaryAuthor, Double bookPrice, int numberOfPages, int numberOfCopiesSold, List<String> publishingHouses, Library library) {
        setId(id);
        setTitle(title);
        setPrimaryAuthor(primaryAuthor);
        setBookPrice(bookPrice);
        setNumberOfPages(numberOfPages);
        setNumberOfCopiesSold(numberOfCopiesSold);
        setPublishingHouses(publishingHouses);
        setLibrary(library);
        books.add(this);
    }

    public Book(Long id, String title, Author primaryAuthor, List<Author> secondaryAuthors, Double bookPrice, int numberOfPages, List<String> publishingHouses, Library library) {
        setId(id);
        setTitle(title);
        setPrimaryAuthor(primaryAuthor);
        setSecondaryAuthors(secondaryAuthors);
        setBookPrice(bookPrice);
        setNumberOfPages(numberOfPages);
        setPublishingHouses(publishingHouses);
        setLibrary(library);
        books.add(this);
    }

    public Book(Long id, String title, Author primaryAuthor, List<Author> secondaryAuthors, Double bookPrice, int numberOfPages, int numberOfCopiesSold, List<String> publishingHouses, Library library) {
        setId(id);
        setTitle(title);
        setPrimaryAuthor(primaryAuthor);
        setSecondaryAuthors(secondaryAuthors);
        setBookPrice(bookPrice);
        setNumberOfPages(numberOfPages);
        setNumberOfCopiesSold(numberOfCopiesSold);
        setPublishingHouses(publishingHouses);
        setLibrary(library);
        books.add(this);
    }

    // class method
    public static Book findBookById(long id) {
        return books.stream().filter(book -> book.id.equals(id)).findAny().orElseThrow(() -> new IllegalArgumentException("cannot find book with id " + id));
    }

    public static List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", primaryAuthor=" + primaryAuthor.toString() + ", numberOfPages=" + numberOfPages + ", bookPrice=" + bookPrice + ", numberOfCopiesSold=" + numberOfCopiesSold + '}';
    }

    public Author getPrimaryAuthor() {
        return primaryAuthor;
    }

    public List<String> getPublishingHouses() {
        return new ArrayList<>(this.publishingHouses);
    }

    public void addPublishingHouse(String publishingHouse) {
        if (!Utils.validateString(publishingHouse)) throw new IllegalArgumentException("invalid publishing house name");
        if (publishingHouses == null) publishingHouses = new ArrayList<>();
        this.publishingHouses.add(publishingHouse);
    }

    public void setPrimaryAuthor(Author primaryAuthor) {
        if (primaryAuthor == null) throw new IllegalArgumentException("Author cannot be null");
        this.primaryAuthor = primaryAuthor;
    }

    public int getNumberOfCopiesSold() {
        return this.numberOfCopiesSold;
    }

    public void setPages(List<Page> pages) {
        if (pages == null) throw new IllegalArgumentException("pages cannot be null");
        pages.forEach(page -> {
            if (page == null) throw new IllegalArgumentException("page cannot be null");
        });
        this.pages = pages;
    }

    public void setNumberOfCopiesSold(Integer numberOfCopiesSold) {
        if (numberOfCopiesSold != null && numberOfCopiesSold < 0)
            throw new IllegalArgumentException("number of copies sold cannnot be less than 0");
        this.numberOfCopiesSold = numberOfCopiesSold;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) throw new IllegalArgumentException("id cannot be less or equal to 0");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Double getBookPrice() {
        return bookPrice;
    }


    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        if (library == null) throw new IllegalArgumentException("library cannot be null");
        this.library = library;
    }

    public void setBookPrice(Double bookPrice) {
        if (bookPrice == null) throw new IllegalArgumentException("book price cannot be null");
        if (bookPrice <= 0.0) throw new IllegalArgumentException("book price cannot be less or equal to 0");
        this.bookPrice = bookPrice;
    }

    public double getMoneyEarn() {
        if (numberOfCopiesSold == null) throw new IllegalArgumentException("number of copies sold must be provided");
        return this.numberOfCopiesSold * this.bookPrice;
    }

    public void setTitle(String title) {
        if (!Utils.validateString(title)) throw new IllegalArgumentException("title is incorrect");
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages <= 0) throw new IllegalArgumentException("numberOfPages cannot be less or equal to 0");
        this.numberOfPages = numberOfPages;
    }

    public List<Author> getSecondaryAuthors() {
        return secondaryAuthors;
    }

    public void setSecondaryAuthors(List<Author> secondaryAuthors) {
        if (secondaryAuthors == null) throw new IllegalArgumentException("cannot set secondary authors to null");
        if (secondaryAuthors.isEmpty() && getSecondaryAuthors().contains(null))
            throw new IllegalArgumentException("cannot set empty list of secondary authors");
        secondaryAuthors.forEach(secondaryAuthor -> {
            if (secondaryAuthor == null) throw new IllegalArgumentException("secondary authour cannot be null");
        });
        this.secondaryAuthors = secondaryAuthors;
    }

    public static void saveToFile(String filePath, List<Book> object) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void appendToFile(String filePath, Book object) {
        List<Book> allBooks = Book.readFromFile(filePath);
        allBooks.add(object);
        Book.saveToFile(filePath, allBooks);
    }

    public static List<Book> readFromFile(String filePath) {
        List<Book> readBooks = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filePath); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            readBooks = (ArrayList<Book>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        books = readBooks;
//        if (books.isEmpty()) books = readBooks;
//        readBooks.forEach(book -> {
//            if (!books.contains(book)) books.add(book);
//        });
//        books.addAll(readBooks);
        return books;
    }

    private void setPublishingHouses(List<String> publishingHouses) {
        if (this.publishingHouses == null) this.publishingHouses = new ArrayList<>(publishingHouses);
        publishingHouses.forEach(this::addPublishingHouse);
    }

    public void deleteBook() {
        allPages.clear();
        pages.clear();
    }

}



