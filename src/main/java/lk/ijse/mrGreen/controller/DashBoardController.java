package lk.ijse.mrGreen.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.mrGreen.DAO.Custom.*;
import lk.ijse.mrGreen.DAO.Custom.Impl.*;
import lk.ijse.mrGreen.DAO.DAOFactory;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


public class DashBoardController {

    @FXML
    private Text txtSupplier;
    @FXML
    public Text txtOrders;

    @FXML
    private Text txtDate;

    @FXML
    private Text txtTime;

    @FXML
    private Text txtLettuceCount;

    @FXML
    private Text txtEmployee;

    @FXML
    private Text txtCustomer;

    @FXML
    private Text txtGreenhouse;
    private int year;
    private int month;
    private int datee;

    private LettuceDAO lettuceDAO = (LettuceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DTOTypes.LETTUCE);
    private EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DTOTypes.EMPLOYEE);
    private CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DTOTypes.CUSTOMER);
    private GreenHouseDAO greenHouseDAO = (GreenHouseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DTOTypes.GREENHOUSE);
    private OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DTOTypes.ORDER);
    private SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DTOTypes.SUPPLIER);

    @FXML
    private AnchorPane root1;

    public void initialize(){
        setDateandTime();
        setLettuceCount();
        setEmployeeCount();
        setCustomerCount();
        setGreenhouseCount();
        setOrderCount();
        setSupplierCount();
    }

    private void setSupplierCount() {
        try {
            String suppCount = Integer.toString(supplierDAO.getCount());
            txtSupplier.setText(suppCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setOrderCount() {
        try {
            String count = Integer.toString(orderDAO.getCount());
            txtOrders.setText(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setGreenhouseCount() {

        try {
            String Count = Integer.toString(greenHouseDAO.getCount());
            txtGreenhouse.setText(Count);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void setCustomerCount() {
        try {
            String count = Integer.toString(customerDAO.getCount());
            txtCustomer.setText(count);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setEmployeeCount() {
        try {
            String count = Integer.toString(employeeDAO.getCount());
            txtEmployee.setText(count);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setLettuceCount() {

        try {
            String count = Integer.toString(lettuceDAO.getCount());
            txtLettuceCount.setText(count);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateTime() {
        LocalTime now = LocalTime.now();
        String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        txtTime.setText(formattedTime);
    }

    private void setDateandTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> updateTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        LocalDate localDate = LocalDate.now();

        year= localDate.getYear();
        month=localDate.getMonthValue();
        datee=localDate.getDayOfMonth();

        txtDate.setText(year + " : " + month + " : " + datee);
    }

    @FXML
    void LettuceOnAction(ActionEvent event) throws IOException {
        Parent rootNode =FXMLLoader.load(getClass().getResource("/view/Lettuce_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene=new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();

    }

    @FXML
    void aboutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/Aboutus_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();

    }

    @FXML
    void customerOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/Customer_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void employeeOnAction(ActionEvent event) throws IOException {
        Parent rootNode =FXMLLoader.load(getClass().getResource("/view/Employee_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene=new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void fertilizerOnAction(ActionEvent event) throws IOException {
        Parent rootNode =FXMLLoader.load(getClass().getResource("/view/Fertilizer_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene=new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();

    }

    @FXML
    void greenhouseOnAction(ActionEvent event) throws IOException {
        Parent rootNode =FXMLLoader.load(getClass().getResource("/view/Greenhouse_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene=new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
    }
    @FXML
    void reportsOnAction(ActionEvent event) throws IOException {
        Parent rootNode =FXMLLoader.load(getClass().getResource("/view/Report_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene=new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();

    }


    @FXML
    void notifyOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/Send_Mail.fxml"));
        Stage stage= (Stage) root1.getScene().getWindow();

        Scene scene= new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();

    }

    @FXML
    void orderOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/Order_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();

    }

    @FXML
    void supplairOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/Supplier_Form.fxml"));
        Stage stage = (Stage) root1.getScene().getWindow();

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
    }
    @FXML
    public void backOnAction(MouseEvent mouseEvent) throws IOException {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to Logout?", yes, no).showAndWait();

        if (result.orElse(no) == yes) {
            Parent rootNode =FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Stage stage = (Stage) root1.getScene().getWindow();

            Scene scene=new Scene(rootNode);
            stage.setScene(scene);
            stage.centerOnScreen();

        }
    }
    @FXML
    void closeOnAction(MouseEvent event) {
        Stage stage = (Stage) txtGreenhouse.getScene().getWindow();
        stage.close();

    }
}
