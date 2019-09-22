package clinic;

import java.io.IOException;

import clinic.model.*;
import clinic.util.SaveInfo;
import clinic.util.WarningController;
import clinic.view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    public static String setStr(Object object) {
        String str = new String("");
        str = "{\"name\":\"113\",\"药品1\":\"drug1\",\"药品2\":\"\",\"药品3\":\"\",\"药品4\":\"\",\"药品5\":\"\"}";
        return str;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Please log in - NeueduClinic");

        initRootLayout();

        summonLoginUI();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the login UI inside the root layout.
     */
    public void summonLoginUI() {
        try {
            // Load login ui.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LoginUI.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            primaryStage.setWidth(360);
            primaryStage.setHeight(360);

            // Set login ui into the center of root layout.
            rootLayout.setCenter(personOverview);
            LoginUIController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Shows the Menzhen Interface inside the root layout.
     */
    public void summonMenzhenInterface() {
        try {
            // Load MenzhenInterface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MenzhenInterface.fxml"));
            AnchorPane MenzhenInterface = (AnchorPane) loader.load();
            primaryStage.setTitle("欢迎，" + Variable.getName());
            primaryStage.setHeight(900);
            primaryStage.setWidth(1200);
            primaryStage.centerOnScreen();
            // Set MenzhenInterface into the center of root layout.
            rootLayout.setCenter(MenzhenInterface);
            MenzhenInterfaceController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * summon a maininterface and attach the current mainapp onto it
    * */
    public void summonMainInterface(MainApp mainApp){
        try {
            // Load MainInterface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainInterface.fxml"));
            AnchorPane MainInterface = (AnchorPane) loader.load();
            primaryStage.setTitle("欢迎，" + Variable.getName());
            primaryStage.setHeight(430);
            primaryStage.setWidth(626);
            primaryStage.centerOnScreen();
            // Set mainInterface into the center of root layout.
            rootLayout.setCenter(MainInterface);
            MainInterfaceController controller = loader.getController();
            controller.setMainApp(mainApp);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Opens a dialog to edit prescription for the specified Appointment. If the user
     * clicks OK, the changes are saved into the provided appointment object and true
     * is returned.
     *
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean summonKaiyaoInterface(Appointment appointment) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/KaiyaoInterface.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("为"+ appointment.get患者姓名()+"开药");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            primaryStage.centerOnScreen();
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            KaiyaoInterfaceController controller = loader.getController();
            controller.setAppointment(appointment);
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);


            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean summonKaijianchaInterface(Appointment appointment) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/JianchaInterface.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("为"+ appointment.get患者姓名()+"开检查");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            primaryStage.centerOnScreen();

            // Set the person into the controller.
            JianchaInterfaceController controller = loader.getController();
            controller.setAppointment(appointment);
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);


            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showWarning(String warningMessage){
        try {
            Stage warningStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("util/Warning.fxml"));
            AnchorPane lianggezijiedian = (AnchorPane) loader.load();
            warningStage.setTitle("WARNING");
            warningStage.initModality(Modality.WINDOW_MODAL);
            warningStage.initOwner(primaryStage);
            warningStage.setHeight(180);
            warningStage.setWidth(300);
            Scene scene = new Scene(lianggezijiedian);
            warningStage.setScene(scene);
            WarningController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(warningStage);
            controller.setTextToShow(warningMessage);

            warningStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        /**
         * hardcode some data
         */
        User doc1 = new User("doc1","111","Curt","心血管内科","门诊医生","主任医师",true);
        User admin = new User("adm1","111","lil","none","医院管理员");
        User caiz = new User("yaof", "111", "yaoshi", "none", "药房操作员");
        User guah = new User("guah", "111", "guah", "none", "挂号收费员");
        User.Users.add(doc1);
        User.Users.add(admin);
        User.Users.add(caiz);
        User.Users.add(guah);
        User.addUser(doc1);
        User.addUser(admin);
        User.addUser(caiz);
        User.addUser(guah);
        Appointment.addApp(new Appointment("000001","001","sixeight"));
        Appointment.addApp(new Appointment("000002","002","Seventy"));
        Prescription.addPre(new Prescription("drug123","drug1","drug2","drug3",null,null));
        /**
         * hardcode some data
         */

        Department XXGNK = new Department(001, "心血管内科", "内科", "临床");
        Department SJNK = new Department(002, "神经内科", "内科", "临床");
        Department PTNK = new Department(003, "普通内科", "内科", "临床");
        Department.addDepartment(XXGNK);
        Department.addDepartment(SJNK);
        Department.addDepartment(PTNK);

        Drug drug1 = new Drug("drug1",10);
        Drug drug2 = new Drug("drug2",100);
        Drug drug3 = new Drug("drug3",1000);
        Drug drug4 = new Drug("drug4",10000);
        Drug drug5 = new Drug("drug5",100000);
        Drug drug6 = new Drug("drug6",1000000);
        Drug drug7 = new Drug("drug7",10000000);
        Jiancha jiancha1 = new Jiancha("jiancha1",60);
        Jiancha_.addJiancha_(new Jiancha_("检查1","jiancha1"));
        int i = 0;
        try {
            for(i = 0; i < 100; i ++){
                SaveInfo.readAppointment();
            }
        } catch (Exception e) {

        }
        try {
            for(i = 0; i < 100; i ++){
                SaveInfo.readPrescription();
            }
        } catch (Exception e) {

        }
        try {
            for(i = 0; i < 100; i ++){
                SaveInfo.readUser();
            }
        } catch (Exception e) {

        }
        launch(args);
    }

    public void summonJichuxinxiweihu() {
        try {
            // Load JichuxinxiguanliInterface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Jichuxinxiweihu.fxml"));
            AnchorPane MainInterface = (AnchorPane) loader.load();
            primaryStage.setTitle("欢迎，" + Variable.getName());
            primaryStage.setHeight(430);
            primaryStage.setWidth(626);
            primaryStage.centerOnScreen();
            // Set mainInterface into the center of root layout.
            rootLayout.setCenter(MainInterface);
            JichuxinxiweihuController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void summonPaibanInterface(){
        try {
            // Load PaibanInterface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PaibanInterface.fxml"));
            AnchorPane MainInterface = (AnchorPane) loader.load();
            primaryStage.setTitle("欢迎，" + Variable.getName());
            primaryStage.setHeight(450);
            primaryStage.setWidth(900);
            primaryStage.centerOnScreen();
            // Set mainInterface into the center of root layout.
            rootLayout.setCenter(MainInterface);
            PaibanInterfaceController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void summonGuahaoInterface() {
        try{
            // Load GuahaoInterface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GuahaoInterface.fxml"));
            AnchorPane MainInterface = (AnchorPane) loader.load();
            primaryStage.setTitle("欢迎，" + Variable.getName());
            primaryStage.setHeight(420);
            primaryStage.setWidth(576);
            primaryStage.centerOnScreen();
            // Set mainInterface into the center of root layout.
            rootLayout.setCenter(MainInterface);
            GuahaoInterfaceController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void summonYaofangInterface() {
        try{
            // Load GuahaoInterface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/YaofangInterface.fxml"));
            AnchorPane MainInterface = (AnchorPane) loader.load();
            primaryStage.setTitle("欢迎，" + Variable.getName());
            primaryStage.setHeight(370);
            primaryStage.setWidth(690);
            primaryStage.centerOnScreen();
            // Set mainInterface into the center of root layout.
            rootLayout.setCenter(MainInterface);
            YaofangInterfaceController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void summonTuihaoInterface() {
        try{
            // Load TuihaoInterface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TuihaoInterface.fxml"));
            AnchorPane MainInterface = (AnchorPane) loader.load();
            primaryStage.setTitle("欢迎，" + Variable.getName());
            primaryStage.setHeight(420);
            primaryStage.setWidth(660);
            primaryStage.centerOnScreen();
            // Set mainInterface into the center of root layout.
            rootLayout.setCenter(MainInterface);
            TuihaoInterfaceController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void summonAddDoc() {
        try{
            // Load TuihaoInterface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AddDocInterface.fxml"));
            AnchorPane MainInterface = (AnchorPane) loader.load();
            primaryStage.setTitle("欢迎，" + Variable.getName());
            primaryStage.setHeight(420);
            primaryStage.setWidth(660);
            primaryStage.centerOnScreen();
            // Set mainInterface into the center of root layout.
            rootLayout.setCenter(MainInterface);
            AddDocInterfaceController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}