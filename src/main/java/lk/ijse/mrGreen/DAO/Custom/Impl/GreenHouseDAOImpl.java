package lk.ijse.mrGreen.DAO.Custom.Impl;

import lk.ijse.mrGreen.DAO.Custom.GreenHouseDAO;
import lk.ijse.mrGreen.DAO.SQLUtil;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.Fertilizerdto;
import lk.ijse.mrGreen.dto.GreenHouseDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GreenHouseDAOImpl implements GreenHouseDAO {

    SQLUtil sqlUtil = new SQLUtil();
    public boolean save(GreenHouseDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "INSERT INTO greenhouse(g_id,name,l_id,water_temp,water_ph) VALUES(?,?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, dto.getId());
//        pstm.setString(2,dto.getName());
//        pstm.setString(3,dto.getL_id());
//        pstm.setInt(4,dto.getTemp());
//        pstm.setDouble(5,dto.getPh());
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
            return sqlUtil.execute("INSERT INTO greenhouse(g_id,name,l_id,water_temp,water_ph) VALUES(?,?,?,?,?)",
                    dto.getId(),dto.getName(),dto.getL_id(),dto.getTemp(),dto.getPh());
        }

    }

    public boolean delete(String id) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql ="DELETE FROM greenhouse WHERE g_id = ?";
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

        return sqlUtil.execute("DELETE FROM greenhouse WHERE g_id = ?",id);
    }

    public boolean update(GreenHouseDto dto) throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "UPDATE greenhouse SET name = ?, l_id = ?,water_temp = ?, water_ph = ? WHERE g_id = ? ";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1,dto.getName());
//        pstm.setString(2,dto.getL_id());
//        pstm.setInt(3,dto.getTemp());
//        pstm.setDouble(4,dto.getPh());
//        pstm.setString(5,dto.getId());
//
//        try {
//            return pstm.executeUpdate() > 0;
//        }catch (Exception e){
//
//        }
//        return false;

        return sqlUtil.execute("UPDATE greenhouse SET name = ?, l_id = ?,water_temp = ?," +
                " water_ph = ? WHERE g_id = ?",dto.getName(),dto.getL_id(),dto.getTemp(),dto.getPh(),dto.getId());
    }

    public List<GreenHouseDto> loadAll() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM greenhouse";
//        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = sqlUtil.execute("SELECT * FROM greenhouse");

        ArrayList<GreenHouseDto> dto = new ArrayList<>();

        while (resultSet.next()){
            dto.add(new GreenHouseDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getDouble(6)
            ));
        }
        return dto;
    }

    public int getCount() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql= "SELECT COUNT(*) AS num_green FROM greenhouse";
//        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = sqlUtil.execute("SELECT COUNT(*) AS num_green FROM greenhouse");

        resultSet.next();
        int count = resultSet.getInt("num_green");

        return count;
    }

    @Override
    public String getName(String id) throws SQLException {
        return null;
    }

    @Override
    public GreenHouseDto search(String cusId) throws SQLException {
        ResultSet resultSet = sqlUtil.execute("SELECT * FROM greenhouse WHERE g_id = ?",cusId);

        GreenHouseDto dto = null;

        if(resultSet.next()){
            dto = new GreenHouseDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getDouble(6)

            );
        }
        return dto;
    }
}
