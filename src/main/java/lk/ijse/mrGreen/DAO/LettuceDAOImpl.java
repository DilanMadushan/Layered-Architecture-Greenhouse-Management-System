package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.LettuceDto;
import lk.ijse.mrGreen.dto.tm.CartTm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LettuceDAOImpl implements LettuceDAO {
    public boolean save(LettuceDto dto) throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO lettuce VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setInt(3,dto.getTemp());
        pstm.setInt(4,dto.getHumid());
        pstm.setDouble(5,dto.getQty());
        pstm.setDouble(6,dto.getSeed());
        pstm.setDouble(7,dto.getUnit());
        pstm.setString(8,dto.getSuppId());

        try{
            boolean isSaved = pstm.executeUpdate() > 0;
            return  isSaved;
        }catch (Exception e){

        }
        return false;
    }

    public List<LettuceDto> loadAll() throws SQLException {
        Connection connection =DbConnection.getInstance().getConnection();

        String sql ="SELECT * FROM lettuce";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        List<LettuceDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(new LettuceDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8)
            ));
        }

        return dtoList;
    }

    public boolean delete(String id) throws SQLException {

        Connection connection= DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM lettuce WHERE l_id = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,id);


        return pstm.executeUpdate() > 0;

    }

    public boolean update(LettuceDto dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE lettuce SET name = ?,Temp = ?,humidity = ?,qty_on_hand = ?, seed_qty = ?, unit_price = ?, sup_id = ? WHERE l_id = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getName());
        pstm.setInt(2,dto.getTemp());
        pstm.setInt(3,dto.getHumid());
        pstm.setDouble(4,dto.getQty());
        pstm.setDouble(5,dto.getSeed());
        pstm.setDouble(6,dto.getUnit());
        pstm.setString(7,dto.getSuppId());
        pstm.setString(8,dto.getId());

        return pstm.executeUpdate() > 0 ;
    }

    public int getCount() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT COUNT(*) AS num_lettuce From lettuce";

        Statement pstm = connection.createStatement();

        ResultSet resultSet = pstm.executeQuery(sql);

        resultSet.next();
        int lettCount = resultSet.getInt("num_lettuce");

        return lettCount;
    }

    @Override
    public String getName(String id) throws SQLException {
        return null;
    }

    public LettuceDto search(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM lettuce WHERE l_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        LettuceDto dto = null;
        pstm.setString(1,id);
        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()){
            dto = new LettuceDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8)
            );
        }
        return dto;
    }

    public boolean updateLettuceQty(List<CartTm> cartTmList) throws SQLException {
        for (CartTm tm: cartTmList) {
            if(!updateQty(tm.getId(),tm.getQty())){
                return false;
            }
        }
        return true;
    }

    private boolean updateQty(String id, Double qty) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE lettuce SET qty_on_hand = qty_on_hand - ? WHERE l_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setDouble(1,qty);
        pstm.setString(2,id);

        return pstm.executeUpdate()>0;
    }
}
