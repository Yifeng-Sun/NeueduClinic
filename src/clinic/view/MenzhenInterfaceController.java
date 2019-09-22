package clinic.view;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import clinic.model.*;
import clinic.MainApp;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenzhenInterfaceController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TableView<Appointment> AppointmentTable;
    @FXML
    private TextArea guominshiArea;
    @FXML
    private TextArea jiwangshiArea;
    @FXML
    private Button wanchengButton;
    @FXML
    private TableColumn<Appointment, String> NameColumn;
    @FXML
    private TextArea xianbingshiArea;
    @FXML
    private TextArea tigeArea;
    @FXML
    private TextArea xianzhiliaoArea;
    @FXML
    private Button kaiyaoButton;
    @FXML
    private Button jianchaButton;
    @FXML
    private TextArea zhusuArea;
    @FXML
    private Label warningLabel;

    public static String getChufang() {
        return chufang;
    }

    public static void setChufang(String chufang) {
        MenzhenInterfaceController.chufang = chufang;

    }

    public static int getYaofei() {
        return yaofei;
    }

    public static void setYaofei(int yaofei) {
        MenzhenInterfaceController.yaofei = yaofei;
    }

    private static String chufang;

    private static int yaofei;

    public MenzhenInterfaceController(){
    }


    @FXML
    private void initialize() {

        AppointmentTable.setItems(Appointment.getAppointmentData());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().患者姓名Property());
        showAppointmentDetails(null);
        AppointmentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAppointmentDetails(newValue));

    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    private void showAppointmentDetails(Appointment appointment) {
        if (appointment != null) {
            // Fill the labels with info from the person object.
            zhusuArea.setText(appointment.get主诉());
            xianbingshiArea.setText(appointment.get现病史());
            xianzhiliaoArea.setText(appointment.get现病情况());
            jiwangshiArea.setText(appointment.get既往史());
            guominshiArea.setText(appointment.get过敏史());
            tigeArea.setText(appointment.get体格检查());
        } else {
            // Person is null, remove all the text.
            zhusuArea.setText("");
            xianbingshiArea.setText("");
            xianzhiliaoArea.setText("");
            jiwangshiArea.setText("");
            guominshiArea.setText("");
            tigeArea.setText("");
        }
    }


    public void saveInfo(){
        String zhusu;
        String xianbingshi;
        String xianbingqingkuang;
        String jiwangshi;
        String guominshi;
        String tige;
        zhusu = new String(zhusuArea.getText());
        xianbingshi = new String(xianbingshiArea.getText());
        xianbingqingkuang = new String(xianzhiliaoArea.getText());
        jiwangshi = new String(jiwangshiArea.getText());
        guominshi = new String(guominshiArea.getText());
        tige = new String(tigeArea.getText());

        Appointment selectedAppointment = AppointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null){
            selectedAppointment.set主诉(zhusu);
            selectedAppointment.set体格检查(tige);
            selectedAppointment.set既往史(jiwangshi);
            selectedAppointment.set现病史(xianbingshi);
            selectedAppointment.set是否已看诊(true);
            selectedAppointment.set过敏史(guominshi);
            selectedAppointment.set现病情况(xianbingqingkuang);
            selectedAppointment.set是否已看诊(true);
        }
        mainApp.showWarning("保存成功！");
    }

    private MainApp mainApp;

    @FXML
    private void handleKaiyao() {
        Appointment selectedAppointment = AppointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            warningLabel.setText("");
            boolean okClicked = mainApp.summonKaiyaoInterface(selectedAppointment);



        } else {
            // Nothing selected.
            warningLabel.setText("请先选择需要开药的患者");
        }
    }

    @FXML
    private void handleKaijiancha(){
        Appointment selectedAppointment = AppointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            warningLabel.setText("");
            boolean okClicked = mainApp.summonKaijianchaInterface(selectedAppointment);



        } else {
            // Nothing selected.
            warningLabel.setText("请先选择需要开检查的患者");
        }
    }
}
