package clinic.view;

import clinic.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import clinic.model.User;
import clinic.model.*;

import static java.lang.Thread.sleep;

public class LoginUIController {
    @FXML
    private Button LOGIN;
    @FXML
    private TextField UserName;
    @FXML
    private PasswordField Password;
    @FXML
    private Label ErrorMessage;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }

    public boolean verification() throws Exception {
        ErrorMessage.setText("登入其他账户来切换");
        for(int i = 0; i < User.Users.size(); i ++){
            if(User.Users.get(i).getLoginName().equals(UserName.getText())  && User.Users.get(i).getPassword().equals(Password.getText())){
                Variable.setClassification(User.Users.get(i).getClassification());
                Variable.setName(User.Users.get(i).getRealNameTheString());
                System.out.println("it's right.");

                return true;
            }
        }
        return false;
    }

    public void tryLogin() throws Exception {
        if(verification()){
            mainApp.summonMainInterface(mainApp);
        }else{
            ErrorMessage.setText("Wrong user name or password!");
        }
    }
}
