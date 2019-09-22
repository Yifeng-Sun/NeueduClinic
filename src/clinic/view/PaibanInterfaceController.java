package clinic.view;

import clinic.MainApp;
import clinic.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.net.URL;

public class PaibanInterfaceController {
    MainApp mainApp;
    int[] paibanxiangqing;
    Stage primaryStage;
    String paibanString;

    @FXML
    private URL location;

    @FXML
    private Button cancel;

    @FXML
    private Rectangle fri0;

    @FXML
    private Rectangle fri1;

    @FXML
    private Button save;

    @FXML
    private Rectangle wed1;

    @FXML
    private Rectangle thur1;

    @FXML
    private Rectangle wed0;

    @FXML
    private Rectangle thur0;

    @FXML
    private TableView<User> docTable;

    @FXML
    private Rectangle sun0;

    @FXML
    private Rectangle sun1;

    @FXML
    private Rectangle mon1;

    @FXML
    private TableColumn<User, String> docNameColumn;

    @FXML
    private Rectangle mon0;

    @FXML
    private Rectangle tue0;

    @FXML
    private Rectangle tue1;

    @FXML
    private Rectangle sat1;

    @FXML
    private Rectangle sat0;

    public PaibanInterfaceController() {

        paibanxiangqing = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    }

    private void lightUP(Rectangle rectangle){
        rectangle.setOpacity(0);
    }

    private void shutDown(Rectangle rectangle){
        rectangle.setOpacity(0.73);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage){
        primaryStage = stage;
    }

    @FXML
    private void initialize() {

        docTable.setItems(User.getUserData());
        docNameColumn.setCellValueFactory(cellData -> cellData.getValue().getRealName());
        docTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setTitle(newValue));

    }

    private void setTitle(User user){
        primaryStage.setTitle("为" + user.getRealNameTheString() + "排班");
    }
/**
 * 0 代表有班
 */

    public void changeSun0(){
        int prev = paibanxiangqing[0];
        if(prev == 1){
            paibanxiangqing[0] = 0;
            lightUP(sun0);
        }else if(prev == 0){
            paibanxiangqing[0] = 1;
            shutDown(sun0);
        }
    }
    public void changeSun1(){
        int prev = paibanxiangqing[1];
        if(prev == 1){
            paibanxiangqing[1] = 0;
            lightUP(sun1);
        }else if(prev == 0){
            paibanxiangqing[1] = 1;
            shutDown(sun1);
        }
    }
    public void changeMon0(){
        int prev = paibanxiangqing[2];
        if(prev == 1){
            paibanxiangqing[2] = 0;
            lightUP(mon0);
        }else if(prev == 0){
            paibanxiangqing[2] = 1;
            shutDown(mon0);
        }
    }
    public void changeMon1(){
        int prev = paibanxiangqing[3];
        if(prev == 1){
            paibanxiangqing[3] = 0;
            lightUP(mon1);
        }else if(prev == 0){
            paibanxiangqing[3] = 1;
            shutDown(mon1);
        }
    }

    public void changeTue0(){
        int prev = paibanxiangqing[4];
        if(prev == 1){
            paibanxiangqing[4] = 0;
            lightUP(tue0);
        }else if(prev == 0){
            paibanxiangqing[4] = 1;
            shutDown(tue0);
        }
    }
    public void changeTue1(){
        int prev = paibanxiangqing[5];
        if(prev == 1){
            paibanxiangqing[5] = 0;
            lightUP(tue1);
        }else if(prev == 0){
            paibanxiangqing[5] = 1;
            shutDown(sun1);
        }
    }
    public void changeWed0(){
        int prev = paibanxiangqing[6];
        if(prev == 1){
            paibanxiangqing[6] = 0;
            lightUP(wed0);
        }else if(prev == 0){
            paibanxiangqing[6] = 1;
            shutDown(wed0);
        }
    }
    public void changeWed1(){
        int prev = paibanxiangqing[7];
        if(prev == 1){
            paibanxiangqing[7] = 0;
            lightUP(wed1);
        }else if(prev == 0){
            paibanxiangqing[7] = 1;
            shutDown(wed1);
        }
    }
    public void changeThur0(){
        int prev = paibanxiangqing[8];
        if(prev == 1){
            paibanxiangqing[8] = 0;
            lightUP(thur0);
        }else if(prev == 0){
            paibanxiangqing[8] = 1;
            shutDown(thur0);
        }
    }
    public void changeThur1(){
        int prev = paibanxiangqing[9];
        if(prev == 1){
            paibanxiangqing[9] = 0;
            lightUP(thur1);
        }else if(prev == 0){
            paibanxiangqing[9] = 1;
            shutDown(thur1);
        }
    }
    public void changeFri0(){
        int prev = paibanxiangqing[10];
        if(prev == 1){
            paibanxiangqing[10] = 0;
            lightUP(fri0);
        }else if(prev == 0){
            paibanxiangqing[10] = 1;
            shutDown(fri0);
        }
    }
    public void changeFri1(){
        int prev = paibanxiangqing[11];
        if(prev == 1){
            paibanxiangqing[11] = 0;
            lightUP(fri1);
        }else if(prev == 0){
            paibanxiangqing[11] = 1;
            shutDown(fri1);
        }
    }
    public void changeSat0(){
        int prev = paibanxiangqing[12];
        if(prev == 1){
            paibanxiangqing[12] = 0;
            lightUP(sat0);
        }else if(prev == 0){
            paibanxiangqing[12] = 1;
            shutDown(sat0);
        }
    }

    public void changeSat1(){
        int prev = paibanxiangqing[13];
        if(prev == 1){
            paibanxiangqing[13] = 0;
            lightUP(sat1);
        }else if(prev == 0){
            paibanxiangqing[13] = 1;
            shutDown(sat1);
        }
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (docTable.getSelectionModel().getSelectedItem() != null) {
            StringBuffer str5 = new StringBuffer();
            for (int i : paibanxiangqing) {
                str5.append(i + "");
            }
            paibanString = str5.toString();
            docTable.getSelectionModel().getSelectedItem().setArrangement(paibanString);
            docTable.getSelectionModel().getSelectedItem().setScheduling(true);
            System.out.println(paibanString);
            mainApp.showWarning("保存成功！");
        }else{
            mainApp.showWarning("未选择被排班的医生。");
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        mainApp.summonJichuxinxiweihu();
    }

}
