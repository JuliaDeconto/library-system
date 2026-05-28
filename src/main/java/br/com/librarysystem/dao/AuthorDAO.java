package br.com.librarysystem.dao;

import br.com.librarysystem.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {

    private Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    private Author mapResult(ResultSet resultSet) throws SQLException {

        Author author = new Author();

        author.setId(resultSet.getInt("id"));
        author.setName(resultSet.getString("name"));
        author.setNationality(resultSet.getString("nationality"));

        Date date = resultSet.getDate("birth_date");
        author.setBirthDate(date != null ? date.toLocalDate() : null);

        return author;
    }

    public void create(Author author) {

        String sql = "INSERT INTO author(name, nationality, birth_date) VALUES (?, ?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, author.getName());
            statement.setString(2, author.getNationality());

            statement.setDate(
                    3,
                    author.getBirthDate() != null
                            ? java.sql.Date.valueOf(author.getBirthDate())
                            : null
            );

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Author findById(int id) {

        String sql = "SELECT * FROM author WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try(ResultSet resultSet = statement.executeQuery()) {

                if (!resultSet.next()) {
                    return null;
                }

                return mapResult(resultSet);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Author findByName(String name) {

        String sql = "SELECT * FROM author WHERE name = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);

            try(ResultSet resultSet = statement.executeQuery()) {

                if (!resultSet.next()) {
                    return null;
                }

                return mapResult(resultSet);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List <Author> findAll() {

        String sql = "SELECT * FROM author";

        List<Author> authors = new  ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                authors.add(mapResult(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;

    }

    public void update(Author author) {

        String sql = "UPDATE author SET name = ?, nationality = ?, birth_date = ? WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, author.getName());
            statement.setString(2, author.getNationality());

            statement.setDate(
                    3,
                    author.getBirthDate() != null
                            ? java.sql.Date.valueOf(author.getBirthDate())
                            : null
            );

            statement.setInt(4, author.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {

        String sql = "DELETE FROM author WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
