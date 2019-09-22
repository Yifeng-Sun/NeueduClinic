package clinic.view;

import clinic.MainApp;
import clinic.model.Appointment;
import clinic.model.Drug;
import clinic.model.Prescription;
import clinic.model.Variable;
import clinic.util.SaveInfo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static clinic.model.Drug.getPriceFromMap;

/**
 * Dialog to edit details of a person.
 *
 * syf
 */
public class KaiyaoInterfaceController {



    private Stage dialogStage;
    private Appointment appointment;
    private boolean okClicked = false;
    String text1;
    int q1;
    String text2;
    int q2;
    String text3;
    int q3;
    String text4;
    int q4;
    String text5;
    int q5;
    boolean drugExists;
    boolean drugExistsInField;

    int yijingkailejigechufangle = 1;
    MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private TextField field1;

    @FXML
    private TextField field3;

    @FXML
    private TextField qf2;

    @FXML
    private TextField qf1;

    @FXML
    private TextField field2;

    @FXML
    private TextField field5;

    @FXML
    private TextField qf4;

    @FXML
    private TextField field4;

    @FXML
    private TextField qf3;

    @FXML
    private TextField qf5;


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

    @FXML
    private TableColumn<Prescription, String> chufangmingcheng;

    @FXML
    private Button save;

    @FXML
    private Button cancel;

    @FXML
    private TableView<Prescription> chufangTable;

    @FXML
    private TextArea yikaiArea;

    @FXML
    private Label sumTheLabel;

    @FXML
    private  TextField qigemingzi;

    String mingzi;

    public KaiyaoInterfaceController() {
        drugExists = true;
    }

    @FXML
    private void initialize() {

        chufangmingcheng.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        chufangTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> addSomeDrug(newValue));
        chufangTable.setItems(Prescription.getPrescriptionData());
        yikaiArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changeChufangThroughText(newValue);
            }
        });

    }

    private void changeChufangThroughText(String newValue) {
        String[] drugsList = new String[200];
        drugsList = newValue.split(" +");
        int sum = 0;
        int ctr = 0;
        for(String oneDrug : drugsList){
            if(Drug.getPriceFromMap(oneDrug) > 0){
                sum += Drug.getPriceFromMap(oneDrug);
                ctr += 1;
            }else{
                drugExistsInField = false;
            }
            System.out.println(ctr + "/" + drugsList.length);
        }
        if(ctr >= (drugsList.length - 1)){
            drugExistsInField = true;
        }
        sumTheLabel.setText(sum + "");
    }

    private void addSomeDrug(Prescription newValue) {
        String yikai = new String(yikaiArea.getText());
        int sum = Integer.parseInt(sumTheLabel.getText());
        if(newValue.get药品1() != null){
            yikai = yikai + " " + newValue.get药品1();
            if(getPriceFromMap(newValue.get药品1()) > 0){
                sum += getPriceFromMap(newValue.get药品1());
            }
        }
        if(newValue.get药品2() != null){
            yikai = yikai + " " + newValue.get药品2();
            if(getPriceFromMap(newValue.get药品2()) > 0){
                sum += getPriceFromMap(newValue.get药品2());
            }
        }
        if(newValue.get药品3() != null){
            yikai = yikai + " " + newValue.get药品3();
            if(getPriceFromMap(newValue.get药品3()) > 0){
                sum += getPriceFromMap(newValue.get药品3());
            }
        }
        if(newValue.get药品4() != null){
            yikai = yikai + " " + newValue.get药品4();
            if(getPriceFromMap(newValue.get药品4()) > 0){
                sum += getPriceFromMap(newValue.get药品4());
            }
        }
        if(newValue.get药品5() != null){
            yikai = yikai + " " + newValue.get药品5();
            if(getPriceFromMap(newValue.get药品5()) > 0){
                sum += getPriceFromMap(newValue.get药品5());
            }
        }

        yikaiArea.setText(yikai);
        sumTheLabel.setText(sum + "");
        MenzhenInterfaceController.setChufang(yikai);
        MenzhenInterfaceController.setYaofei(sum);
        appointment.setKaiyaoed(false);
    }


    @FXML
    private void TypeInDrug(){
        int sum = Integer.parseInt(sumTheLabel.getText());
        text1 = field1.getText();
        text2 = field2.getText();
        text3 = field3.getText();
        text4 = field4.getText();
        text5 = field5.getText();
        q1 = Integer.parseInt(qf1.getText());
        q2 = Integer.parseInt(qf2.getText());
        q3 = Integer.parseInt(qf3.getText());
        q4 = Integer.parseInt(qf4.getText());
        q5 = Integer.parseInt(qf5.getText());

        System.out.println(text5+"-"+text1+"-"+text2);

        sum = getSum(sum, text1, text2, q1, q2);

        sum = getSum(sum, text3, text4, q1, q2);

        if(!text5.equals("")){
            if(Drug.doDrugExists(text5)){
                int cnt1;
                for(cnt1 = 0; cnt1 < q1; cnt1 ++){
                    if(Drug.doDrugExists(text5)){
                        sum += getPriceFromMap(text5);
                        yikaiArea.appendText(" " + text5 + "\n");
                    }else {
                        drugExists = false;
                    }
                }
            }
        }

        sumTheLabel.setText(sum + "");
        if(!drugExists){
            mainApp.showWarning("输入的部分药品在药房中没有剩余，默认忽略。");
            drugExists = true;
        }
        MenzhenInterfaceController.setChufang(yikaiArea.getText());
        MenzhenInterfaceController.setYaofei(sum);
        appointment.setKaiyaoed(false);
    }

    private int getSum(int sum, String text1, String text2, int q1, int q2) {
        int cnt1 = 0;
        int cnt2 = 0;
        if(!text1.equals("")){
            for(cnt1 = 0; cnt1 < q1; cnt1 ++){
                if(Drug.doDrugExists(text1)){
                    sum += getPriceFromMap(text1);
                    yikaiArea.appendText(" " + text1);
                }else {
                    drugExists = false;
                }
            }

        }
        if(!text2.equals("")){
            for(cnt2 = 0; cnt2 < q2; cnt2 ++){
                if(Drug.doDrugExists(text1)){
                    sum += getPriceFromMap(text1);
                    yikaiArea.appendText(" " + text1);
                }else {
                    drugExists = false;
                }
            }
        }
        return sum;
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param appointment
     */
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;

        yikaiArea.setText(appointment.get处方());
        sumTheLabel.setText(appointment.get药费() + "");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (drugExistsInField) {
            appointment.set处方(yikaiArea.getText());
            appointment.set药费(Integer.parseInt(sumTheLabel.getText()));
            okClicked = true;
            dialogStage.close();
        }else{
            mainApp.showWarning("输入的部分药品在药房中没有剩余，请重新填写。");
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
        drugExists = true;
        drugExistsInField = true;
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */

    @FXML
    private void addToPrescription(){
        text1 = field1.getText();
        text2 = field2.getText();
        text3 = field3.getText();
        text4 = field4.getText();
        text5 = field5.getText();
        mingzi = qigemingzi.getText();
        if(mingzi == null){
            Prescription.addPre(new Prescription(Variable.getName() + "的未命名处方" + yijingkailejigechufangle ++ ,text1,text2,text3,text4,text5));
            }else{
            Prescription.addPre(new Prescription(mingzi, text1,text2,text3,text4,text5));
        }
        SaveInfo.saveInfo(new Prescription(mingzi, text1,text2,text3,text4,text5));
        }

    private boolean isInputValid() {
        return true;
    }
}