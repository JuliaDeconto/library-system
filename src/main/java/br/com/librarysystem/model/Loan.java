package br.com.librarysystem.model;

import java.time.LocalDate;

public class Loan {

    private Long id;
    private User user;
    private Book book;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public Loan() {
    }

    public Loan(Long id, User user, Book book, LocalDate loanDate, LocalDate dueDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
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

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void returnBook() {
        if (returnDate != null) {
            throw new IllegalStateException("Book already returned");
        }
        this.returnDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + (user != null ? user.getName() : null) +
                ", book=" + (book != null ? book.getTitle() : null) +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}