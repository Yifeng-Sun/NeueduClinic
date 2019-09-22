package clinic.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Drug {
    private final StringProperty name;
    private final IntegerProperty price;


    private static ObservableList<Drug> DrugData = FXCollections.observableArrayList();
    private static Map<String,Integer> DrugMap = new HashMap<>();

    public static void addDrug(Drug drug){ DrugData.add(drug);
    }

    public static ObservableList<Drug> getDrugData(){
        return DrugData;
    }

/*
    public Appointment(StringProperty 处方) {
        this(null, null, null);
    }
*/

    public Drug(String name, int price) {//put into the map immediately after being newed
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        DrugMap.put(name,price);
        System.out.println(DrugMap);
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




    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public IntegerProperty PriceProperty() {
        return price;
    }

    public static int getPriceFromMap(String name){
        if(DrugMap.containsKey(name)){
            return DrugMap.get(name);
        }else{
            return -1;
        }
    }

    public static boolean doDrugExists(String name){
        if(name != null){
            return DrugMap.containsKey(name);
        }else {
            return true;
        }
    }


}

