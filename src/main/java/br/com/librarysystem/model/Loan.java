package br.com.librarysystem.model;

import java.time.LocalDate;

public class Loan {

    private Long id;
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean returned;

    public Loan() {
    }

    public Loan(Long id, User user, Book book, LocalDate loanDate, LocalDate returnDate, boolean returned) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "user=" + user.getName() +
                ", book=" + book.getTitle() +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                '}';
    }
}
