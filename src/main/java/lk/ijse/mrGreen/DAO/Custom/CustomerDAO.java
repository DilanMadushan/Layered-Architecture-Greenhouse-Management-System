package lk.ijse.mrGreen.DAO.Custom;

import lk.ijse.mrGreen.DAO.CrudDao;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO extends CrudDao<CustomerDto> {
//    boolean saveCustomer(CustomerDto dto) throws SQLException;
//
//    boolean deleteCustomer(String id) throws SQLException ;
//
//    boolean updateCustomer(CustomerDto dto) throws SQLException ;
//
//    List<CustomerDto> loadAllCustomer() throws SQLException ;
//
//    int getCustomerCount() throws SQLException ;
//
//    String getName(String id) throws SQLException ;
//
//    CustomerDto getCustomerDetils(String cusId) throws SQLException ;
}
