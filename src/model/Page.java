package model;

/**
 * @author dominikerlich
 * @created 08/05/2022
 * @project MP1
 */
public class Page {
    private Long id;
    private String text;
    private Book book;

    public Page(Long id, String text, Book book) {
        this.id = id;
        this.text = text;
        this.book = book;
    }

    public static Page createPage(Book book, Long id, String text) {
        if (book == null || id == null || text == null) throw new IllegalArgumentException("one of the attributes is wrong");
        Page page = new Page(id, text, book);
        book.addPage(page);
        return page;
    }

}
