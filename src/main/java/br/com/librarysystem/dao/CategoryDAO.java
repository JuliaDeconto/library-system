package br.com.librarysystem.dao;

import br.com.librarysystem.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Category category) {

        String sql = "INSERT INTO category(name) VALUES (?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, category.getName());

            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Category findById(int id) {

        String sql = "SELECT * FROM category WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Category category = new Category();

                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));

                return category;
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Category findByName(String name) {

        String sql = "SELECT * OF category WHERE name = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Category category = new Category();

                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));

                return category;
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List <Category> findAll() {

        String sql = "SELECT * FROM category";

        List<Category> categories = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Category category = new Category();

                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));

                categories.add(category);
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    public void update(Category category) {

        String sql = "UPDATE category SET name = ? WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());

            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
