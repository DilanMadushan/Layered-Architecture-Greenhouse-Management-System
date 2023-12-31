package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO  {
    public UserDto search(String name) throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();

        String sql ="SELECT * FROM user WHERE name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,name);

        ResultSet resultSet =pstm.executeQuery();

        UserDto dto =null;

        if(resultSet.next()){
            String user_id = resultSet.getString(1);
            String user_name = resultSet.getString(2);
            String password = resultSet.getString(3);
            String job_role = resultSet.getString(4);

            dto=new UserDto(user_id,user_name,password,job_role);
        }

        return dto;
    }

    @Override
    public boolean save(UserDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(UserDto dto) throws SQLException {
        return false;
    }

    public List<UserDto> loadAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ArrayList<UserDto> dtoList= new ArrayList<>();

        ResultSet resultSet=pstm.executeQuery();

        while (resultSet.next()){
            dtoList.add(new UserDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return dtoList;
    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }

    @Override
    public String getName(String id) throws SQLException {
        return null;
    }

    public String getPassword(String name) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT password FROM user WHERE name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,name);

        try{
            ResultSet resultSet = pstm.executeQuery();

            resultSet.next();
            return resultSet.getString("password");

        }catch (Exception e){

        }

        return null;
    }

    public String getEmail(String name) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT email FROM user WHERE name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,name);

        try{
            ResultSet resultSet = pstm.executeQuery();

            resultSet.next();
            return resultSet.getString("email");

        }catch (Exception e){

        }

        return null;
    }
}
