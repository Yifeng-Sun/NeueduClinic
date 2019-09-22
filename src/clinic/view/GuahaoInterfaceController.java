package clinic.view;

import clinic.MainApp;
import clinic.model.Appointment;
import clinic.model.Department;
import clinic.model.User;
import clinic.util.SaveInfo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import static clinic.model.User.Users;

public class GuahaoInterfaceController {
    MainApp mainApp;
    Stage stage;

    @FXML
    private Button okTheButton;

    @FXML
    private TextField xingmingArea;

    @FXML
    private TextField jiesuanleibieArea;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField fapiaohaoArea;

    @FXML
    private ComboBox<String> keshiBox;

    @FXML
    private TextField binglihaoArea;

    @FXML
    private ComboBox<String> yishengBox;

    @FXML
    private CheckBox binglibenBox;

    @FXML
    private ComboBox<String> wubieBox;

    @FXML
    private ComboBox<String> shoufeifangshiBox;

    @FXML
    private Label sumTheLabel;

    @FXML
    private Rectangle tuihaoRec;

    @FXML
    private Label tuihaoLabel;

    ArrayList<User> avilableDoc = new ArrayList<>();

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }




    @FXML
    private void handleTuihao(){
        mainApp.summonTuihaoInterface();
    }

    @FXML
    private void initialize() {
        wubieBox.getItems().addAll("上午", "下午");
        shoufeifangshiBox.getItems().addAll("现金", "银行卡", "在线支付");
        for (Department department : Department.getDepartments()){
            keshiBox.getItems().add(department.getName());
        }
        datePicker.showingProperty().addListener(((observable, oldValue, newValue) -> handleDateChange()));
        wubieBox.valueProperty().addListener((observable, oldValue, newValue) -> handleWubieChange());
        keshiBox.valueProperty().addListener((observable, oldValue, newValue) -> handleKeshiChange());
        yishengBox.valueProperty().addListener((observable, oldValue, newValue) -> handleYishengChange());
        binglibenBox.selectedProperty().addListener((observable, oldValue, newValue) -> setCharges());
    }

    public void handleDateChange(){
        avilableDoc.clear();
        wubieBox.setValue(null);
        keshiBox.setValue(null);
        yishengBox.setValue(null);
        yishengBox.getItems().clear();
        System.out.println("doc removed in handle date c");
        sumTheLabel.setText("0");
    }

    public void handleWubieChange(){
        if(wubieBox.getValue() != null){
            avilableDoc.clear();
            keshiBox.setValue(null);
            yishengBox.setValue(null);
            yishengBox.getItems().clear();
            System.out.println("doc removed in handle wubie c");
            sumTheLabel.setText("0");
        }

    }

    public void handleKeshiChange(){
        if(keshiBox.getValue() != null){
            avilableDoc.clear();
            yishengBox.setValue(null);
            yishengBox.getItems().clear();
            System.out.println("doc removed in handle keshi c");
            setDocBox();
            System.out.println("setDocBox()");
            sumTheLabel.setText("0");
        }
    }

    public void handleYishengChange(){
        if(yishengBox.getValue() != null){
            setCharges();
        }
    }

    private void setCharges() {
        String yishengName;
        int guahaofei = 0;
        yishengName = yishengBox.getValue();
        if(yishengName != null){
            for(User user : Users){
                if(user.getRealNameTheString().equals(yishengName)){
                    System.out.println(user.getTitle());
                    if(user.getTitle().equals("主任医师"));
                    guahaofei = 80;
                    System.out.println("80!");
                    break;
                }else {
                    guahaofei = 50;
                    System.out.println("50!");
                    break;
                }
            }
        }
        if(binglibenBox.isSelected()){
            guahaofei += 1;
        }
        sumTheLabel.setText(guahaofei+ "");
    }

    @FXML
    private void setDocBox(){
        //新建一个装可用医生的容器
        for(User user : Users){
            System.out.println("开始检查一个医生的可用性");
            System.out.println(user.getDepartment());
            //System.out.println(keshiBox.getValue().toString());
            if(user.getDepartment().equals(keshiBox.getValue().toString())){
                System.out.println("科室符合");
                if(yishengchuzhen(user)){
                    avilableDoc.add(user);
                    System.out.println("1");
                }
            }
        }
        System.out.println("DOCBOX SET.");
        for(User user : avilableDoc){
            yishengBox.getItems().add(user.getRealNameTheString());
        }
    }

    private boolean yishengchuzhen(User user) {
        System.out.println("User传进来了");
        user.getArrangement();

        String xingqiji;
        xingqiji = datePicker.getValue().getDayOfWeek().toString();
        String wubie;
        wubie = wubieBox.getValue();
        if(xingqiji.equals("SUNDAY")){
            if(wubie.equals("上午")){
                if(user.getArrangement().charAt(0) == '0'){
                    return true;
                }else return false;
            }else if(wubie.equals("下午")){
                if(user.getArrangement().charAt(1) == '0'){
                    return true;
                }else return false;
            }
        }else if (xingqiji.equals("MONDAY")) {
            if (wubie.equals("上午")) {
                if (user.getArrangement().charAt(2) == '0') {
                    return true;
                } else return false;
            } else if (wubie.equals("下午")) {
                if (user.getArrangement().charAt(3) == '0') {
                    return true;
                } else return false;
            }
        }else if(xingqiji.equals("TUESDAY")) {
            if (wubie.equals("上午")) {
                if (user.getArrangement().charAt(4) == '0') {
                    return true;
                } else return false;
            } else if (wubie.equals("下午")) {
                if (user.getArrangement().charAt(5) == '0') {
                    return true;
                } else return false;
            }
        }else if(xingqiji.equals("WEDNESDAY")) {
            if (wubie.equals("上午")) {
                if (user.getArrangement().charAt(6) == '0') {
                    return true;
                } else return false;
            } else if (wubie.equals("下午")) {
                if (user.getArrangement().charAt(7) == '0') {
                    return true;
                } else return false;
            }
        }else if(xingqiji.equals("THURSDAY")) {
            if (wubie.equals("上午")) {
                if (user.getArrangement().charAt(8) == '0') {
                    return true;
                } else return false;
            } else if (wubie.equals("下午")) {
                if (user.getArrangement().charAt(9) == '0') {
                    return true;
                } else return false;
            }
        }else if(xingqiji.equals("FRIDAY")) {
            if (wubie.equals("上午")) {
                if (user.getArrangement().charAt(10) == '0') {
                    return true;
                } else return false;
            } else if (wubie.equals("下午")) {
                if (user.getArrangement().charAt(11) == '0') {
                    return true;
                } else return false;
            }
        }else if(xingqiji.equals("SATURDAY")) {
            if (wubie.equals("上午")) {
                if (user.getArrangement().charAt(12) == '0') {
                    return true;
                } else return false;
            } else if (wubie.equals("下午")) {
                if (user.getArrangement().charAt(13) == '0') {
                    return true;
                } else return false;
            }
        }else {
            System.out.println("error occurs.");
            return false;
        }
        return false;
    }

    public void handleOK(){
        String fapiaohao = fapiaohaoArea.getText();
        String binglihao = binglihaoArea.getText();
        String jiesuanleibie = jiesuanleibieArea.getText();
        String xingming = xingmingArea.getText();
        LocalDate kanzhenriqi = datePicker.getValue();
        String wubie = wubieBox.getValue();

        System.out.println(fapiaohao);
        System.out.println(binglihao);
        System.out.println(jiesuanleibie);
        System.out.println(xingming);
        System.out.println(kanzhenriqi);
        System.out.println(wubie);

        if(!((fapiaohao == null) || (binglihao == null) || (jiesuanleibie == null) || (xingming == null) || (kanzhenriqi == null) || (wubie == null))){
            ZoneId zone = ZoneId.systemDefault();
            Instant instant = kanzhenriqi.atStartOfDay().atZone(zone).toInstant();
            java.util.Date date = Date.from(instant);
            String keshi = keshiBox.getValue();
            String yisheng = yishengBox.getValue();
            Appointment newAppointment = new Appointment(fapiaohao,binglihao,xingming);
            newAppointment.set结算类别(jiesuanleibie);
            newAppointment.set看诊日期(date);
            newAppointment.set午别(wubie);
            newAppointment.set挂号科室(keshi);
            newAppointment.set看诊医生(yisheng);
            Appointment.addApp(newAppointment);
            System.out.println("存好了。");
            SaveInfo.saveInfo(newAppointment);
            mainApp.showWarning("保存成功！");
        }else {
            mainApp.showWarning("还有未填写的项目。");
        }


    }
}
