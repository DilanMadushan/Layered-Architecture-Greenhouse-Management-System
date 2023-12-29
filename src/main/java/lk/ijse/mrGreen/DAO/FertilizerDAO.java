package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.Fertilizerdto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface FertilizerDAO {
    boolean SaveFertilizer(Fertilizerdto dto) throws SQLException;

    boolean deleteFertilizer(String id) throws SQLException;

    boolean updateFertilizer(Fertilizerdto dto) throws SQLException;

    List<Fertilizerdto> getAllFertilizer() throws SQLException;
}