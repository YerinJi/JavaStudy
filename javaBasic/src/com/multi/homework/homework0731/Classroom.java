package com.multi.homework.homework0731;

public class Classroom {
    private Student[] students;

    public Classroom(Student[] students) {
        this.students = students;
    }

    public void printStudents(){
        System.out.print("학생 목록: ");
        for(int i=0;i<students.length;i++){
            System.out.print(students[i].getName());
            if(i!=students.length-1){
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        Student[] s = {
                new Student("민수"),
                new Student("지영"),
                new Student("철수")
        };
        Classroom classroom = new Classroom(s);
        classroom.printStudents();
    }
}
