package com.DAO;

import com.Beans.Etudiant;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EtudiantsDaoImp implements EtudiantsDAO {

    @Override
    public List<Etudiant> afficherEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection connection = DataBaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM etudiants")) {

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setId(resultSet.getInt("id"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setAddress(resultSet.getString("address"));
                etudiant.setTelephone(resultSet.getString("telephone"));
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

    @Override
    public void ajouterEtudiants(Etudiant etudiant) {
        try (Connection connection = DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO etudiants (nom, email, address, telephone) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getEmail());
            preparedStatement.setString(3, etudiant.getAddress());
            preparedStatement.setString(4, etudiant.getTelephone());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerEtudiants(Integer id) {
        try (Connection connection = DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM etudiants WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEtudiant(Integer id, Etudiant updatedEtudiant) {
        try (Connection connection = DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE etudiants SET nom = ?, email = ?, address = ?, telephone = ? WHERE id = ?")) {

            preparedStatement.setString(1, updatedEtudiant.getNom());
            preparedStatement.setString(2, updatedEtudiant.getEmail());
            preparedStatement.setString(3, updatedEtudiant.getAddress());
            preparedStatement.setString(4, updatedEtudiant.getTelephone());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        try (Connection connection = DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM etudiants WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setId(resultSet.getInt("id"));
                    etudiant.setNom(resultSet.getString("nom"));
                    etudiant.setEmail(resultSet.getString("email"));
                    etudiant.setAddress(resultSet.getString("address"));
                    etudiant.setTelephone(resultSet.getString("telephone"));
                    return etudiant;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Etudiant> SearchEtudiant(String name) {
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection connection = DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM etudiants WHERE lower(nom) LIKE ?")) {

            preparedStatement.setString(1, "%" + name.toLowerCase() + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setId(resultSet.getInt("id"));
                    etudiant.setNom(resultSet.getString("nom"));
                    etudiant.setEmail(resultSet.getString("email"));
                    etudiant.setAddress(resultSet.getString("address"));
                    etudiant.setTelephone(resultSet.getString("telephone"));
                    etudiants.add(etudiant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }
}
