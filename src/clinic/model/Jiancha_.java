package clinic.model;

import java.util.Date;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jiancha_ {
    private final StringProperty name;
    private final StringProperty 检查1;


    private static ObservableList<Jiancha_> Jiancha_Data = FXCollections.observableArrayList();

    public static void addJiancha_(Jiancha_ jiancha_){
        Jiancha_Data.add(jiancha_);
    }

    public static ObservableList<Jiancha_> getJiancha_Data(){
        return Jiancha_Data;
    }

/*
    public Appointment(StringProperty 处方) {
        this(null, null, null);
    }
*/

    public Jiancha_(String name, String 检查) {
        this.name = new SimpleStringProperty(name);
        this.检查1 = new SimpleStringProperty(检查);
    }


    public String getName() {
        return name.get();
    }

    public void setName(String Name) {
        this.name.set(Name);
    }

    public StringProperty NameProperty() {
        return name;
    }




    public String get药品1() {
        return 检查1.get();
    }

    public void set药品1(String 药品1) {
        this.检查1.set(药品1);
    }

    public StringProperty 药品1Property() {
        return 检查1;
    }





}