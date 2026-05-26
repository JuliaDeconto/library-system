package br.com.librarysystem.model;

import java.time.LocalDate;

public class Author {

    private Long id;
    private String name;
    private String nationality;
    private LocalDate birthDate;

    public Author() {
    }

    public Author(Long id, String name, String nationality, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
