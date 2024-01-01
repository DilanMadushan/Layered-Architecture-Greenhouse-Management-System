package lk.ijse.mrGreen.DAO.Custom;

import lk.ijse.mrGreen.DAO.CrudDAO;
import lk.ijse.mrGreen.dto.UserDto;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<UserDto> {
//    UserDto checkUser(String name) throws SQLException ;
//
//    List<UserDto> loadAllUseres() throws SQLException ;

    String getPassword(String name) throws SQLException ;

    String getEmail(String name) throws SQLException ;
}
