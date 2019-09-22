package clinic.util;

import clinic.MainApp;
import clinic.model.Appointment;
import clinic.model.Prescription;
import clinic.model.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 使用Java序列化把对象存储到文件中，再从文件中读出来 注意读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致
 *
 *
 */

public class SaveInfo{
    public static void saveInfo(Object object){
        try {
            String str = null;
            try {
                str = JSON.toJSONString(object);
            } catch (Exception e) {
                str = MainApp.setStr(object);
            }
            if (object.getClass() == Appointment.class) {
                try {
                    Writer w = new FileWriter("Appointment类对象");
                    w.write(str);
                    w.flush();
                    w.close();
                } catch (Exception e) {

                }

                }else if(object.getClass() == User.class){
                   try {
                      Writer w = new FileWriter("User类对象");
                      w.write(str);
                      w.flush();
                      w.close();
                   } catch (Exception e) {

                   }
            }else if(object.getClass() == Prescription.class){
                    try {
                       Writer w = new FileWriter("Prescription类对象");
                       w.write(str);
                       w.flush();
                        w.close();
                    } catch (Exception e) {

                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public static User readUser(){
        String str = "";
        try{
            Reader r = new FileReader("User类对象");
            BufferedReader br = new BufferedReader(r);
            str = br.readLine();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        User u = JSON.parseObject(str,User.class);
        return u;
    }
    public static Appointment readAppointment(){
        String str = "";
        try{
            Reader r = new FileReader("Appointment类对象");
            BufferedReader br = new BufferedReader(r);
            str = br.readLine();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        Appointment u = JSON.parseObject(str,Appointment.class);
        return u;
    }
    public static Prescription readPrescription(){
        String str = "";
        try{
            Reader r = new FileReader("Prescirption类对象");
            BufferedReader br = new BufferedReader(r);
            str = br.readLine();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        Prescription u = JSON.parseObject(str,Prescription.class);
        return u;
    }



    }


//教程
//public class Test08 extends TestCase {
//    public void test() {
//        // 创建一个User对象
//        User user = new User();
//        user.setId(1);
//        user.setName("Mr XP.Wang");
//        // 创建一个List对象
//        List<String> list = new ArrayList<String>();
//        list.add("My name");
//        list.add(" is");
//        list.add(" Mr XP.Wang");
//
//        try {
//            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
//                    "C:/wxp.txt"));
//            User temp = (User) is.readObject();// 从流中读取User的数据
//            System.out.println(temp.getId());
//            System.out.println(temp.getName());
//            List tempList = (List) is.readObject();// 从流中读取List的数据
//            for (Iterator iterator = tempList.iterator(); iterator.hasNext();) {
//                System.out.print(iterator.next());
//            }
//            is.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
//class User implements Serializable {
//    private int id;
//    private String name;
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//}