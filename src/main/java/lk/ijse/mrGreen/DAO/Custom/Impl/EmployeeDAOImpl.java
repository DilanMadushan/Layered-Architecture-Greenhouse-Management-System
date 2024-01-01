package lk.ijse.mrGreen.DAO.Custom.Impl;

import lk.ijse.mrGreen.DAO.Custom.EmployeeDAO;
import lk.ijse.mrGreen.DAO.SQLUtil;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    SQLUtil sqlUtil = new SQLUtil();
    public boolean save(EmployeeDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql ="INSERT INTO employee VALUES(?,?,?,?,?,?)";
//        PreparedStatement pstm =connection.prepareStatement(sql);
//
//        pstm.setString(1,dto.getId());
//        pstm.setString(2,dto.getName());
//        pstm.setInt(3,dto.getAge());
//        pstm.setString(4,dto.getAddress());
//        pstm.setString(5, dto.getJob());
//        pstm.setDouble(6,dto.getSalary());
//
//        try {
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }
//        return false;

        Object object = search(dto.getId());

        if(object!=null){
            return false;
        }else {
            return sqlUtil.execute("INSERT INTO employee VALUES(?,?,?,?,?,?)",
                    dto.getId(),dto.getName(),dto.getAge(),dto.getAddress(),dto.getJob(),dto.getSalary());
        }

    }

    public boolean delete(String id) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "DELETE FROM employee WHERE emp_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,id);
//
//        try {
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }
//        return false;

        return sqlUtil.execute("DELETE FROM employee WHERE emp_id = ?",id);
    }

    public boolean update(EmployeeDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "UPDATE employee SET name = ?, age = ?, address = ?," +
//                " job_role = ?, salary = ? WHERE emp_id = ?;";
//
//        PreparedStatement pstm=connection.prepareStatement(sql);
//
//        pstm.setString(1,dto.getName());
//        pstm.setInt(2,dto.getAge());
//        pstm.setString(3, dto.getAddress());
//        pstm.setString(4,dto.getJob());
//        pstm.setDouble(5,dto.getSalary());
//        pstm.setString(6,dto.getId());
//
//        try{
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }
//        return false;
        return sqlUtil.execute("UPDATE employee SET name = ?, age = ?, address = ?, job_role = ?, salary = ? WHERE emp_id = ?"
                ,dto.getName(),dto.getAge(),dto.getAddress(),dto.getJob(),dto.getSalary(),dto.getId());
    }

    public List<EmployeeDto> loadAll() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql ="SELECT * FROM employee";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        ArrayList<EmployeeDto> dto= new ArrayList<>();
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        while (resultSet.next()){
//            dto.add(new EmployeeDto(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getInt(3),
//                    resultSet.getString(4),
//                    resultSet.getString(5),
//                    resultSet.getDouble(6)
//            ));
//        }
//        return dto;

        ResultSet resultSet = sqlUtil.execute("SELECT * FROM employee");

        ArrayList<EmployeeDto> dto= new ArrayList<>();

        while (resultSet.next()){
            dto.add(new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6)
            ));
        }
        return dto;


    }

    public int getCount() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT COUNT(*) AS num_Employee FROM employee";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        resultSet.next();
//
//        int count = resultSet.getInt("num_Employee");
//
//        return count;
        ResultSet resultSet = sqlUtil.execute("SELECT COUNT(*) AS num_Employee FROM employee");

        resultSet.next();

        int count = resultSet.getInt("num_Employee");

        return count;
    }

    public String getName(String id) throws SQLException {

//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql ="SELECT name FROM employee WHERE emp_id = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,id);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        resultSet.next();
//
//        String name = resultSet.getString("name");
//
//        return name;

        ResultSet resultSet = sqlUtil.execute("SELECT name FROM employee WHERE emp_id = ?",id);

        resultSet.next();

        String name = resultSet.getString("name");

        return name;
    }

    public EmployeeDto search(String id) throws SQLException {

        ResultSet resultSet = sqlUtil.execute("SELECT * FROM employee WHERE emp_id = ?",id);

        EmployeeDto dto = null;

        if(resultSet.next()){
            dto = new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6)
            );
        }
        return dto;
    }
}
