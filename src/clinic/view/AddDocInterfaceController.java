package clinic.view;

import clinic.MainApp;
import clinic.model.Department;
import clinic.model.User;
import clinic.util.SaveInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddDocInterfaceController {
    MainApp mainApp;
    Stage stage;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<String> departmentBox;

    @FXML
    private TextField loginNameField;

    @FXML
    private ComboBox<String> titleBox;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<String> classificationBox;

    @FXML
    private TextField realNameField;

    @FXML
    private Button saveButton;

    @FXML
    private void initialize() {
        classificationBox.getItems().addAll("挂号收费员", "门诊医生", "医技医生", "药房操作员", "财务管理员", "医院管理员");
        titleBox.getItems().addAll("主任医师", "非主任医师");
        for (Department department : Department.getDepartments()){
            departmentBox.getItems().add(department.getName());
        }
    }

    @FXML
    private void handleSave(){
        if(!(loginNameField.getText() == null || passwordField.getText() == null || realNameField.getText() == null || departmentBox.getValue() == null || titleBox.getValue() == null || classificationBox.getValue() == null)){
            User newUser = new User(loginNameField.getText(),passwordField.getText(),realNameField.getText(),departmentBox.getValue(),classificationBox.getValue(),titleBox.getValue(),false);
            User.Users.add(newUser);
            User.addUser(newUser);
            SaveInfo.saveInfo(newUser);
            mainApp.showWarning("保存成功。");
        }else{
            mainApp.showWarning("还有未填充的项。");
        }

    }

    @FXML
    private void handleCancel(){
        mainApp.summonJichuxinxiweihu();
    }

}
