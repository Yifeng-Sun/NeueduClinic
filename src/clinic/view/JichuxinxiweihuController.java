package clinic.view;

import clinic.MainApp;
import javafx.fxml.FXML;

public class JichuxinxiweihuController {
    MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void goToPaiban(){
        mainApp.summonPaibanInterface();
    }

    @FXML
    private void gotoAddDoc(){
        mainApp.summonAddDoc();
    }
}
