package lk.ijse.mrGreen.DAO.Custom;

import lk.ijse.mrGreen.DAO.CrudDao;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDAO extends CrudDao<UserDto> {
//    UserDto checkUser(String name) throws SQLException ;
//
//    List<UserDto> loadAllUseres() throws SQLException ;

    String getPassword(String name) throws SQLException ;

    String getEmail(String name) throws SQLException ;
}
