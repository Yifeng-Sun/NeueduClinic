package clinic.view;

import clinic.MainApp;
import clinic.model.*;
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

import static clinic.model.Jiancha.getPriceFromMap;

/**
 * Dialog to edit details of a person.
 *
 * syf
 */
public class JianchaInterfaceController {



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
    boolean jianchaExists;
    boolean jianchaExistsInField;

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
    private TableColumn<Jiancha_, String> jianchamingcheng;

    @FXML
    private Button save;

    @FXML
    private Button cancel;

    @FXML
    private TableView<Jiancha_> jianchaTable;

    @FXML
    private TextArea yikaiArea;

    @FXML
    private Label sumTheLabel;

    @FXML
    private  TextField qigemingzi;

    String mingzi;

    public JianchaInterfaceController() {
        jianchaExists = true;
    }

    @FXML
    private void initialize() {

        jianchamingcheng.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        jianchaTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> addSomeJiancha(newValue));
        jianchaTable.setItems(Jiancha_.getJiancha_Data());
        yikaiArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                changeChufangThroughText(newValue);
            }
        });

    }

    private void changeChufangThroughText(String newValue) {
        String[] jianchasList = new String[200];
        jianchasList = newValue.split(" +");
        int sum = 0;
        int ctr = 0;
        for(String oneJiancha : jianchasList){
            if(Jiancha.getPriceFromMap(oneJiancha) > 0){
                sum += Jiancha.getPriceFromMap(oneJiancha);
                ctr += 1;
            }else{
                jianchaExistsInField = false;
            }
            System.out.println(ctr + "/" + jianchasList.length);
        }
        if(ctr >= (jianchasList.length - 1)){
            jianchaExistsInField = true;
        }
        sumTheLabel.setText(sum + "");
    }

    private void addSomeJiancha(Jiancha_ newValue) {
        String yikai = new String(yikaiArea.getText());
        int sum = Integer.parseInt(sumTheLabel.getText());
        if(newValue.get药品1() != null){
            yikai = yikai + " " + newValue.get药品1();
            if(getPriceFromMap(newValue.get药品1()) > 0){
                sum += getPriceFromMap(newValue.get药品1());
            }
        }

        yikaiArea.setText(yikai);
        sumTheLabel.setText(sum + "");
        MenzhenInterfaceController.setChufang(yikai);
        MenzhenInterfaceController.setYaofei(sum);
    }


    @FXML
    private void TypeInJiancha(){
        int sum = Integer.parseInt(sumTheLabel.getText());
        text1 = field1.getText();

        q1 = Integer.parseInt(qf1.getText());


        //System.out.println(text5+"-"+text1+"-"+text2);



        if(!text1.equals("")){
            if(Jiancha.doJianchaExists(text1)){
                int cnt1;
                for(cnt1 = 0; cnt1 < q1; cnt1 ++){
                    if(Jiancha.doJianchaExists(text1)){
                        sum += getPriceFromMap(text1);
                        yikaiArea.appendText(" " + text1);
                    }else {
                        jianchaExists = false;
                    }
                }
            }
        }

        sumTheLabel.setText(sum + "");
        if(!jianchaExists){
            mainApp.showWarning("输入的检查不存在，默认忽略。");
            jianchaExists = true;
        }
        MenzhenInterfaceController.setChufang(yikaiArea.getText());
        MenzhenInterfaceController.setYaofei(sum);
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
        if (jianchaExistsInField) {
            appointment.set检查项目(yikaiArea.getText());
            appointment.set检查费(Integer.parseInt(sumTheLabel.getText()));
            okClicked = true;
            dialogStage.close();
        }else{
            mainApp.showWarning("输入的部分检查不存在，请重新填写。");
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
        jianchaExists = true;
        jianchaExistsInField = true;
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
    }

    private boolean isInputValid() {
        return true;
    }
}