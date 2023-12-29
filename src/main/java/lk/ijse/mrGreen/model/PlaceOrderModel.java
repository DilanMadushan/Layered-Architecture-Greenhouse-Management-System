package lk.ijse.mrGreen.model;

import lk.ijse.mrGreen.DAO.*;
import lk.ijse.mrGreen.db.DbConnection;
import lk.ijse.mrGreen.dto.PlaceOrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderModel {

    private OrderDAO orderDAO = new OrderDAOImpl();
    private LettuceDAO lettuceDAO = new LettuceDAOImpl();

    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException {
        String o_id = placeOrderDto.getOrder_id();
        String cus_id = placeOrderDto.getCus_id();
        LocalDate date = placeOrderDto.getDate();

        Connection connection = null;

        try {

            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);


            boolean isOrderSaved = orderDAO.saveOrder(o_id, cus_id, date);
            System.out.println("1 " + isOrderSaved );
            if (isOrderSaved) {
                System.out.println("1 " + isOrderSaved );
                boolean isUpdate = lettuceDAO.updateLettuceQty(placeOrderDto.getCartTmList());
                if (isUpdate) {
                    System.out.println("1 " + isUpdate);
                    boolean isOrderDetailSaved = orderDetailDAO.saveOrderDetails(placeOrderDto.getOrder_id(), placeOrderDto.getCartTmList());
                    if (isOrderDetailSaved) {
                       System.out.println("1 " + isOrderDetailSaved);
                        connection.commit();
                    }else {
                        connection.rollback();
                    }
                }else {
                    connection.rollback();
                }
            }else {
                connection.rollback();
            }

        }catch (SQLException e){
            if(connection!= null) connection.rollback();
            e.printStackTrace();
            }
        finally {
            if(connection!= null) connection.setAutoCommit(true);
        }
        return true;
    }
}
