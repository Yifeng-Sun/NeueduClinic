package clinic.view;

import clinic.MainApp;
import clinic.model.Appointment;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class YaofangInterfaceController {
    MainApp mainApp;
    Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private Button fanhuiButton;

    @FXML
    private Button kaiyaoButton;

    @FXML
    private TableView<Appointment> mingxiTable;

    @FXML
    private TableColumn<Appointment, String> chufangColumn;

    @FXML
    private TableColumn<Appointment, String> feiyongColumn;

    @FXML
    private TableColumn<Appointment, String> xingmingColumn;

    @FXML
    private TableColumn<Appointment,String> yiquyaoColumn;

    @FXML
    private void initialize() {
        mingxiTable.setItems(Appointment.getAppointmentData());
        xingmingColumn.setCellValueFactory(cellData -> cellData.getValue().患者姓名Property());
        chufangColumn.setCellValueFactory(cellData -> cellData.getValue().处方Property());
        feiyongColumn.setCellValueFactory(cellData -> cellData.getValue().药费PropertyTheStringProperty());
        yiquyaoColumn.setCellValueFactory(cellData -> cellData.getValue().get是否已经取药());
        mingxiTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMingxi(newValue));



    }

    @FXML
    private void handleKaiyao(){
        if(mingxiTable.getSelectionModel().getSelectedItem() != null){
            if(mingxiTable.getSelectionModel().getSelectedItem().isQuyaoed()){
                mainApp.showWarning("该患者已经取过药了。");
            }else {
                mingxiTable.getSelectionModel().getSelectedItem().setQuyaoed(true);
            }
        }else{
            mainApp.showWarning("请选择发药的对象。");
        }

        mingxiTable.getItems().removeAll();
        yiquyaoColumn.setCellValueFactory(cellData -> cellData.getValue().get是否已经取药());
        mingxiTable.setItems(Appointment.getAppointmentData());
        xingmingColumn.setCellValueFactory(cellData -> cellData.getValue().患者姓名Property());
        chufangColumn.setCellValueFactory(cellData -> cellData.getValue().处方Property());
        feiyongColumn.setCellValueFactory(cellData -> cellData.getValue().药费PropertyTheStringProperty());
        mingxiTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMingxi(newValue));

    }

    @FXML
    private  void handleCancel(){
        mainApp.summonMainInterface(mainApp);
    }

    private void showMingxi(Appointment newValue) {

        stage.setTitle("为" + newValue.get患者姓名() + "结算开药");

    }
}
