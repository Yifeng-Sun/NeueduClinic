package clinic.model;

import java.io.Serializable;
import java.util.Date;

import clinic.util.SaveInfo;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Appointment implements Serializable {
    private final StringProperty 发票号;
    private final StringProperty 病历号;
    private final StringProperty 患者姓名;
    private final StringProperty 结算类别;//自费/医保
    private final ObjectProperty<Date> 看诊日期;
    private final StringProperty 午别;
    private final StringProperty 挂号科室;
    private final StringProperty 号别;
    private final StringProperty 看诊医生;
    private final BooleanProperty 病历本;
    private final DoubleProperty 应收金额;
    private final StringProperty 收费方式;
    private final BooleanProperty 是否已看诊;
    private final StringProperty 主诉;
    private final StringProperty 现病史;
    private final StringProperty 现病情况;
    private final StringProperty 既往史;
    private final StringProperty 过敏史;
    private final StringProperty 体格检查;
    private final StringProperty 处方;
    private final IntegerProperty 药费;
    private final StringProperty 检查项目;
    private final IntegerProperty 检查费;
    private final StringProperty 是否已经取药;

    public static void removeApp(String 病历号) {
        int cnt = 0;
        int id = 0;
        for(Appointment appointment : AppointmentData){
            if(appointment.get病历号().equals(病历号)){
                id = cnt;
            }
            cnt += 1;
        }
        AppointmentData.remove(id);
    }

    public StringProperty get是否已经取药() {
        return 是否已经取药;
    }

    public StringProperty 是否已经取药Property() {
        return 是否已经取药;
    }

    public void set是否已经取药(String 是否已经取药) {
        this.是否已经取药.set(是否已经取药);
    }

    public boolean isQuyaoed() {
        return quyaoed;
    }

    boolean quyaoed;
    public boolean setQuyaoed(boolean quyaoed){
        if(quyaoed){
            this.quyaoed = true;
            this.是否已经取药.setValue("是");
        }else{
            this.quyaoed = false;
            this.是否已经取药.setValue("否");
        }
        return false;
    }

    public boolean isKaiyaoed() {
        return isKaiyaoed;
    }

    public void setKaiyaoed(boolean kaiyaoed) {
        isKaiyaoed = kaiyaoed;
    }

    boolean isKaiyaoed;


    private static ObservableList<Appointment> AppointmentData = FXCollections.observableArrayList();

    public static void addApp(Appointment appointment){
        AppointmentData.add(appointment);
        //SaveInfo.saveInfo(appointment);
    }
    public static ObservableList<Appointment> getAppointmentData() {
        return AppointmentData;
    }/*
    public Appointment(StringProperty 处方) {
        this(null, null, null);
    }*/

    public boolean is病历本() {
        return 病历本.get();
    }

    public Appointment(String 发票号, String 病历号, String 患者姓名) {
        this.发票号 = new SimpleStringProperty(发票号);
        this.病历号 = new SimpleStringProperty(病历号);
        this.患者姓名 = new SimpleStringProperty(患者姓名);
        this.结算类别 = new SimpleStringProperty("");
        this.看诊日期 = new SimpleObjectProperty(new Date());
        this.午别 = new SimpleStringProperty("");
        this.挂号科室 = new SimpleStringProperty("");
        this.号别 = new SimpleStringProperty("");
        this.看诊医生 = new SimpleStringProperty("");
        this.病历本 = new SimpleBooleanProperty(false);
        this.应收金额 = new SimpleDoubleProperty(0);
        this.收费方式 = new SimpleStringProperty("");
        this.是否已看诊 = new SimpleBooleanProperty(false);
        this.主诉 = new SimpleStringProperty("");
        this.体格检查 = new SimpleStringProperty("");
        this.既往史 = new SimpleStringProperty("");
        this.现病史 = new SimpleStringProperty("");
        this.现病情况 = new SimpleStringProperty("");
        this.过敏史 = new SimpleStringProperty("");
        this.处方 = new SimpleStringProperty("");
        this.药费 = new SimpleIntegerProperty(0);
        this.检查项目 = new SimpleStringProperty("");
        this.检查费 = new SimpleIntegerProperty(0);
        this.isKaiyaoed = false;
        this.是否已经取药 = new SimpleStringProperty("否");
    }
    public int get药费() {
        return 药费.get();
    }

    public void set药费(int 药费) {
        this.药费.set(药费);
    }


    public IntegerProperty 药费Property() {
        return 药费;
    }

    public StringProperty 药费PropertyTheStringProperty() {
        StringProperty yaofeiTheString = new SimpleStringProperty("");
        yaofeiTheString.setValue(药费.get() + "");
        return yaofeiTheString;
    }


    public String get检查项目() {
        return 检查项目.get();
    }

    public void set检查项目(String 检查项目) {
        this.检查项目.set(检查项目);
    }

    public StringProperty 检查项目Property() {
        return 检查项目;
    }



    public int get检查费() {
        return 检查费.get();
    }

    public void set检查费(int 检查费) {
        this.检查费.set(检查费);
    }

    public IntegerProperty 检查费Property() {
        return 检查费;
    }


    public String get发票号() {
        return 发票号.get();
    }

    public void set发票号(String 发票号) {
        this.发票号.set(发票号);
    }

    public StringProperty 发票号Property() {
        return 发票号;
    }




    public String get病历号() {
        return 病历号.get();
    }

    public void set病历号(String 病历号) {
        this.病历号.set(病历号);
    }

    public StringProperty 病历号Property() {
        return 病历号;
    }




    public String get患者姓名() {
        return 患者姓名.get();
    }

    public void set患者姓名(String 患者姓名) {
        this.患者姓名.set(患者姓名);
    }

    public StringProperty 患者姓名Property() {
        return 患者姓名;
    }




    public String get结算类别() {
        return 结算类别.get();
    }

    public void set结算类别(String 结算类别) {
        this.结算类别.set(结算类别);
    }

    public StringProperty 结算类别Property() {
        return 结算类别;
    }





    public Date get看诊日期() {
        return 看诊日期.get();
    }

    public void set看诊日期(Date 看诊日期) {
        this.看诊日期.set(看诊日期);
    }

    public ObjectProperty<Date> 看诊日期Property() {
        return 看诊日期;
    }




    public String get午别() {
        return 午别.get();
    }

    public void set午别(String 午别) {
        this.午别.set(午别);
    }

    public StringProperty 午别Property() {
        return 午别;
    }




    public String get挂号科室() {
        return 挂号科室.get();
    }

    public void set挂号科室(String 挂号科室) {
        this.挂号科室.set(挂号科室);
    }

    public StringProperty 挂号科室Property() {
        return 挂号科室;
    }




    public String get号别() {
        return 号别.get();
    }

    public void set号别(String 号别) {
        this.号别.set(号别);
    }

    public StringProperty 号别Property() {
        return 号别;
    }




    public String get看诊医生() {
        return 看诊医生.get();
    }

    public void set看诊医生(String 看诊医生) {
        this.看诊医生.set(看诊医生);
    }

    public StringProperty 看诊医生Property() {
        return 看诊医生;
    }




    public boolean get病历本() {
        return 病历本.get();
    }

    public void set病历本(boolean 病历本) {
        this.病历本.set(病历本);
    }

    public BooleanProperty 病历本Property() {
        return 病历本;
    }




    public double get应收金额() {
        return 应收金额.get();
    }

    public void set应收金额(double 应收金额) {
        this.应收金额.set(应收金额);
    }

    public DoubleProperty 应收金额Property() {
        return 应收金额;
    }




    public String get收费方式() {
        return 收费方式.get();
    }

    public void set收费方式(String 收费方式) {
        this.收费方式.set(收费方式);
    }

    public StringProperty 收费方式Property() {
        return 收费方式;
    }




    public boolean get是否已看诊() {
        return 是否已看诊.get();
    }

    public void set是否已看诊(boolean 是否已看诊) {
        this.是否已看诊.set(是否已看诊);
    }

    public BooleanProperty 是否已看诊Property() {
        return 是否已看诊;
    }




    public String get主诉() {
        return 主诉.get();
    }

    public void set主诉(String 主诉) {
        this.主诉.set(主诉);
    }

    public StringProperty 主诉Property() {
        return 主诉;
    }




    public String get现病史() {
        return 现病史.get();
    }

    public void set现病史(String 现病史) {
        this.现病史.set(现病史);
    }

    public StringProperty 现病史Property() {
        return 现病史;
    }




    public String get现病情况() {
        return 现病情况.get();
    }

    public void set现病情况(String 现病情况) {
        this.现病情况.set(现病情况);
    }

    public StringProperty 现病情况Property() {
        return 现病情况;
    }




    public String get既往史() {
        return 既往史.get();
    }

    public void set既往史(String 既往史) {
        this.既往史.set(既往史);
    }

    public StringProperty 既往史Property() {
        return 既往史;
    }




    public String get过敏史() {
        return 过敏史.get();
    }

    public void set过敏史(String 过敏史) {
        this.过敏史.set(过敏史);
    }

    public StringProperty 过敏史Property() {
        return 过敏史;
    }




    public String get体格检查() {
        return 体格检查.get();
    }

    public void set体格检查(String 体格检查) {
        this.体格检查.set(体格检查);
    }

    public StringProperty 体格检查Property() {
        return 体格检查;
    }



    public String get处方() {
        return 处方.get();
    }

    public void set处方(String 处方) {
        this.处方.set(处方);
    }

    public StringProperty 处方Property() {
        return 处方;
    }



}














