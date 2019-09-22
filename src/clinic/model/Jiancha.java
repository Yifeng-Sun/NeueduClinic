package clinic.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jiancha {
    private final StringProperty name;
    private final IntegerProperty price;


    private static ObservableList<Jiancha> JianchaData = FXCollections.observableArrayList();
    private static Map<String,Integer> JianchaMap = new HashMap<>();

    public static void addJiancha(Jiancha jiancha){ JianchaData.add(jiancha);
    }

    public static ObservableList<Jiancha> getJianchaData(){
        return JianchaData;
    }

/*
    public Appointment(StringProperty 处方) {
        this(null, null, null);
    }
*/

    public Jiancha(String name, int price) {//put into the map immediately after being newed
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        JianchaMap.put(name,price);
        System.out.println(JianchaMap);
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
        if(JianchaMap.containsKey(name)){
            return JianchaMap.get(name);
        }else{
            return -1;
        }
    }

    public static boolean doJianchaExists(String name){
        if(name != null){
            return JianchaMap.containsKey(name);
        }else {
            return true;
        }
    }


}

