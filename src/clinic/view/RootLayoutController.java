package clinic.view;

import clinic.MainApp;
import clinic.model.Variable;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class RootLayoutController {
    @FXML
    private MenuItem stepBackToLogin;

    @FXML
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    private void toLogin(){
        mainApp.summonLoginUI();
    }

    @FXML
    private void toMainInterface(){
        if(Variable.getName() != null){
            mainApp.summonMainInterface(mainApp);
        } else{
          mainApp.showWarning("请先登录账号。");
        }

    }
}
