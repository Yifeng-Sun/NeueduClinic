package clinic.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class User {
    SimpleStringProperty loginName = new SimpleStringProperty(this, "loginName");
    SimpleStringProperty password = new SimpleStringProperty(this, "password");
    SimpleStringProperty realName = new SimpleStringProperty(this, "realName");
    SimpleStringProperty Department = new SimpleStringProperty(this, "department");
    SimpleStringProperty classification = new SimpleStringProperty(this, "classification");//挂号收费员、门诊医生、医技医生、药房操作员、财务管理员、医院管理员
    SimpleStringProperty title = new SimpleStringProperty(this, "title");
    boolean Scheduled;

    public String getArrangement() {
        return Arrangement.get();
    }

    public SimpleStringProperty arrangementProperty() {
        return Arrangement;
    }

    public void setArrangement(String arrangement) {
        this.Arrangement.set(arrangement);
    }

    SimpleStringProperty Arrangement = new SimpleStringProperty(this, "arrangement");
    public static ArrayList<User> Users = new ArrayList<>();

    private static ObservableList<User> UserData = FXCollections.observableArrayList();

    public static void addUser(User user){
        UserData.add(user);
    }
    public static ObservableList<User> getUserData() {
        return UserData;
    }

    public User(String loginName, String password, String realName, String department, String classification, String title, boolean scheduled) {
        this.loginName.set(loginName);
        this.password.set(password);
        this.realName.set(realName);
        Department.set(department);
        this.classification.set(classification);
        this.title.set(title);
        Scheduled = scheduled;
        setArrangement("11111111111111111111");
    }

    public User(String loginName, String password, String realName, String department, String classification) {
        this.loginName.set(loginName);
        this.password.set(password);
        this.realName.set(realName);
        Department.set(department);
        this.classification.set(classification);
    }

    public String getLoginName() {
        return loginName.get();
    }

    public void setLoginName(String loginName) {
        this.loginName.set(loginName);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public SimpleStringProperty getRealName() {
        return realName;
    }
    public String getRealNameTheString() {
        return realName.get();
    }

    public void setRealName(String realName) {
        this.realName.set(realName);
    }

    public String getDepartment() {
        return Department.get();
    }

    public void setDepartment(String department) {
        Department.set(department);
    }

    public String getClassification() {
        return classification.get();
    }

    public void setClassification(String classification) {
        this.classification.set(classification);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public boolean isScheduling() {
        return Scheduled;
    }

    public void setScheduling(boolean scheduling) {
        Scheduled = scheduling;
    }



}
