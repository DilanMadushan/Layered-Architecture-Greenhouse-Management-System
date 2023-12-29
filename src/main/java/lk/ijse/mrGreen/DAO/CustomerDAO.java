package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO {
    public boolean saveCustomer(CustomerDto dto) throws SQLException;

    public boolean deleteCustomer(String id) throws SQLException ;

    public boolean updateCustomer(CustomerDto dto) throws SQLException ;

    public List<CustomerDto> loadAllCustomer() throws SQLException ;

    public int getCustomerCount() throws SQLException ;

    public String getName(String id) throws SQLException ;

    CustomerDto getCustomerDetils(String cusId) throws SQLException ;
}
