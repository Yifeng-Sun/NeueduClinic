package clinic.view;

import clinic.MainApp;
import clinic.model.Appointment;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TuihaoInterfaceController {
    MainApp mainApp;
    Stage stage;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @FXML
    private TableView<Appointment> appointmentTable;

    @FXML
    private Button confirm;

    @FXML
    private TableColumn<Appointment, String> nameColumn;

    @FXML
    private Label sumTheLabel;

    @FXML
    private void initialize() {

        appointmentTable.setItems(Appointment.getAppointmentData());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().患者姓名Property());
        appointmentTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSum(newValue));

    }

    @FXML
    private void handleTuihao(){
        if(appointmentTable.getSelectionModel().getSelectedItem() != null){
            if(appointmentTable.getSelectionModel().getSelectedItem().get是否已看诊() == false){
                Appointment.removeApp(appointmentTable.getSelectionModel().getSelectedItem().get病历号());
            }else {
                mainApp.showWarning("该患者已经看诊，无法退号。");
            }
        }



    }

    private void showSum(Appointment newValue) {
        if(newValue != null){
            sumTheLabel.setText(newValue.get应收金额() + "");
        }else{
            sumTheLabel.setText(" -");
        }

    }
}
