package lk.ijse.mrGreen.DAO;

import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.Fertilizerdto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FertilizerDAOImpl implements FertilizerDAO{
    public boolean save(Fertilizerdto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql ="INSERT INTO fertilizer VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getId());
        pstm.setString(2,dto.getName());
        pstm.setString(3, dto.getCompany());
        pstm.setDouble(4,dto.getUnit());
        pstm.setInt(5,dto.getQty());
        pstm.setString(6,dto.getSupId());
        pstm.setString(7,dto.getLId());

        try {
            return pstm.executeUpdate() > 0;
        }catch (Exception e){

        }
        return false;

    }

    public boolean delete(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql ="DELETE FROM fertilizer WHERE f_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,id);

        return pstm.executeUpdate() > 0;
    }

    public boolean update(Fertilizerdto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql ="UPDATE fertilizer SET name = ?, company = ?, unit = ?, qty = ?," +
                " sup_id = ?, l_id = ? WHERE f_id = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getName());
        pstm.setString(2,dto.getCompany());
        pstm.setDouble(3,dto.getUnit());
        pstm.setInt(4,dto.getQty());
        pstm.setString(5,dto.getSupId());
        pstm.setString(6,dto.getLId());
        pstm.setString(7,dto.getId());

        return pstm.executeUpdate() >0;
    }

    public List<Fertilizerdto> loadAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM fertilizer";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<Fertilizerdto> dto = new ArrayList<>();

        while (resultSet.next()){
            dto.add(new Fertilizerdto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            ));
        }
        return dto;

    }

    @Override
    public int getCount() throws SQLException {
        return 0;
    }

    @Override
    public String getName(String id) throws SQLException {
        return null;
    }

    @Override
    public Fertilizerdto search(String cusId) throws SQLException {
        return null;
    }
}
