package model;

/**
 * @author dominikerlich
 * @created 08/05/2022
 * @project MP1
 */
public class LibraryUserContract {
    private Long id;
    private Double monthlyPayment;
    private int contractLength;
    private Library library;
    private User user;

    public LibraryUserContract(Long id, Double monthlyPayment, int contractLength, Library library, User user) {
        this.id = id;
        this.monthlyPayment = monthlyPayment;
        this.contractLength = contractLength;
        this.library = library;
        this.user = user;

        //add connections
        library.addUserContract(this);
        user.addUserContract(this);
    }

    public void setId(Long id) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        this.id = id;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        if (monthlyPayment == null) throw new IllegalArgumentException("montly payment cannot be null");
        if (monthlyPayment.isNaN() && monthlyPayment.isInfinite()) throw new IllegalArgumentException("wrong monntly payment");
        this.monthlyPayment = monthlyPayment;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public void cancelContract() {
        this.user.cancelContract();
        this.library.cancelContract();

        this.library = null;
        this.user = null;
    }

//    public void setLibrary(Library library) {
//        if (library == null) throw new IllegalArgumentException("library cannot be null");
//        this.library = library;
//    }
//
//    public void setUser(User user) {
//        if (user == null) throw new IllegalArgumentException("user cannot be null");
//        this.user = user;
//    }

    public Long getId() {
        return id;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public int getContractLength() {
        return contractLength;
    }

    public Library getLibrary() {
        return library;
    }

    public User getUser() {
        return user;
    }
}
