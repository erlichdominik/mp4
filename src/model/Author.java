package model;

import java.util.List;

/**
 * @author dominikerlich
 * @created 24/03/2021
 * @project MP1
 */

public class Author extends Person {
    private long id;

    // many to many

    private List<PublishingHouse> publishingHouses;

    public Author(long id, Person person) {
        super(person.getName(), person.getSurname());
        setId(id);
    }

    public void addPublishingHouse(PublishingHouse publishingHouse) {
        if (publishingHouse == null) throw new IllegalArgumentException("publishing house cannot be null");
        this.publishingHouses.add(publishingHouse);
        publishingHouse.addAuthour(this);
    }

    public List<PublishingHouse> getPublishingHouses() {
        if (publishingHouses == null) throw new IllegalArgumentException("publishing houses are null");
        return publishingHouses;
    }

    public void setPublishingHouses(List<PublishingHouse> publishingHouses) {
        if (publishingHouses == null) throw new IllegalArgumentException("publishing houses cannot be null");
        publishingHouses.forEach(publishingHouse -> {
            if (publishingHouse == null) throw new IllegalArgumentException("publishing house cannot be null");
        });
        this.publishingHouses = publishingHouses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) throw new IllegalArgumentException("id cannot be less or equal to 0");
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                "surname='" + getSurname() + '\'' +
                "id='" + this.id + '\'' +
                '}';
    }
}
