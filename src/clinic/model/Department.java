package clinic.model;

import java.util.ArrayList;

public class Department {
    private int id;
    private String name;
    private String 分类;
    private String 类型;




    public static ArrayList<Department> getDepartments() {
        return Departments;
    }

    public static void addDepartment(Department department) {
        Departments.add(department);
    }

    static ArrayList<Department> Departments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get分类() {
        return 分类;
    }

    public void set分类(String 分类) {
        this.分类 = 分类;
    }

    public String get类型() {
        return 类型;
    }


    public void set类型(String 类型) {
        this.类型 = 类型;
    }

    public Department(int id, String name, String 分类, String 类型) {
        this.id = id;
        this.name = name;
        this.分类 = 分类;
        this.类型 = 类型;
    }


}
