package clinic.view;

import clinic.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import clinic.model.*;


public class MainInterfaceController {
    public Rectangle 门诊block;
    @FXML
    private Label info;
    @FXML
    private Label big;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }

    public void setInfo() {
        info.setText("当前用户：" + Variable.getClassification() + "  " + Variable.getName());
    }

    public boolean testMenzhenAuthority(){
        if(Variable.getClassification().equals("门诊医生") || Variable.getClassification().equals("医院管理员")){
            return true;
        }else return false;
    }

    public void goToMenzhen() throws Exception {
        if(testMenzhenAuthority()){
            //去往门诊窗口
            mainApp.summonMenzhenInterface();
            big.setText("进入门诊系统...");
        }else{
            big.setText("No authority!");
        }
    }
    public boolean testGuahaoAuthority(){
        if(Variable.getClassification().equals("挂号收费员") || Variable.getClassification().equals("医院管理员")){
            return true;
        }else return false;
    }
    public void goToGuahao() throws Exception {
        if(testGuahaoAuthority()){
            mainApp.summonGuahaoInterface();
        }else{
            big.setText("No authority!");
        }
    }
    public boolean testYaofangAuthority(){
        if(Variable.getClassification().equals("药房操作员") || Variable.getClassification().equals("医院管理员")){
            return true;
        }else return false;
    }
    public void goToYaofang() throws Exception {
        if(testYaofangAuthority()){
            mainApp.summonYaofangInterface();
        }else{
            big.setText("No authority!");
        }
    }

    public void showUndercon(){
        big.setText("Under Construction...");
    }

    public void gotoJichuxinxiweihu(){
        if(testJichuxinxiweihuAuthority()){
            mainApp.summonJichuxinxiweihu();
        }else{
            big.setText("No authority!");
        }
    }

    private boolean testJichuxinxiweihuAuthority() {
        if(Variable.getClassification().equals("医院管理员")){
            return true;
        }else return false;
    }

}
