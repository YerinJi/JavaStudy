package com.multi.object.staticex;
//Static(정적),final(상수)
public class StudentEx {
    //instance 변수
    private String name;
    private int age;
    private String email;
    private static String nation;

    static {
        nation = "우간다";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setNation(String nation) {
        StudentEx.nation = nation;
    }
    public static String getNation() {
        return nation;
    }

    public static void main(String[] args) {
        StudentEx stud1 = new StudentEx();
        stud1.setName("지예린");
        stud1.setNation("한국");
        StudentEx stud2 = new StudentEx();
        System.out.println(stud2.nation);
    }


}
