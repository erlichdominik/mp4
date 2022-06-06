package model;

/**
 * @author dominikerlich
 * @created 04/05/2022
 * @project MP1
 */

import java.util.List;

/**
 * optional attribute
 */
public class PublishingHouse {
    private Long id;
    private String name;
    private List<Author> authors;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (name.isEmpty()) throw new IllegalArgumentException("name cannot be empty");
        this.name = name;
    }

    public List<Author> getAuthors() {
        if (authors == null) throw new IllegalArgumentException("authors are null");
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        if (authors == null) throw new IllegalArgumentException("authors cannot be null");
        authors.forEach(author -> {
            if (author == null) throw new IllegalArgumentException("author cannot be null");
        });
        this.authors = authors;
    }

    public void addAuthour(Author author) {
        if (author == null) throw new IllegalArgumentException("author cannot be null");
        this.authors.add(author);
        author.addPublishingHouse(this);
    }
}
