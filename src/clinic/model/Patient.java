package clinic.model;

import java.util.ArrayList;
import java.util.Date;

public class Patient {
    String 姓名;
    String 性别;
    String 年龄;
    String 年龄单位;
    Date 出生日期;
    String 身份证号;
    String 家庭住址;
    private static ArrayList<Patient> patients = new ArrayList<>();
    public Patient(String 姓名, String 性别, String 年龄, String 年龄单位, Date 出生日期, String 身份证号, String 家庭住址) {
        this.姓名 = 姓名;
        this.性别 = 性别;
        this.年龄 = 年龄;
        this.年龄单位 = 年龄单位;
        this.出生日期 = 出生日期;
        this.身份证号 = 身份证号;
        this.家庭住址 = 家庭住址;
    }
    Patient defPatient = new Patient("患者0", "男", "20", "岁", new Date(), "210203200000000000", "xiaolongxia");

}
