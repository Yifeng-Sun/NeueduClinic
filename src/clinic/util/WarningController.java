package clinic.util;

import clinic.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class WarningController {
    MainApp mainApp;
    Stage stage;

    @FXML
    private Label TextToShow;

    @FXML
    private Button ok;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setTextToShow(String textToShow){
        TextToShow.setText(textToShow);
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void handleOK(){
        stage.close();
    }
}
