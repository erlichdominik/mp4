package model;

import java.util.List;
import java.util.Objects;

/**
 * @author dominikerlich
 * @created 08/05/2022
 * @project MP1
 */
public class User extends Person {
    private String mail;
    private List<LibraryUserContract> libraryUserContracts;

    public User(String name, String surname, String mail) {
        super(name, surname);
        this.mail = mail;
    }

    public void addUserContract(LibraryUserContract libraryUserContract) {
        this.libraryUserContracts.add(libraryUserContract);
//        libraryUserContract.setUser(this);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return mail.equals(user.mail);
    }

    public void cancelContract() {
        this.libraryUserContracts = null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }

    @Override
    public String toString() {
        return "User{" +
                "mail='" + mail + '\'' +
                '}';
    }
}
