package com.multi.object.arrayclass;

import java.util.Scanner;

public class PersonMain {
    Scanner sc = new Scanner(System.in);
    Person [] p;
    int count;
    public PersonMain(){
        System.out.println("Person Count:");
        p=new Person[sc.nextInt()];
        for(int i=0;i<p.length;i++){
            p[i]=new Person();
        }
        System.out.println(p.length + "인원 생성 ");
        menu();
    }

    public void menu(){
        while(true){
            System.out.println("1. Add 2.List 3. Modify 3. Delete 4. Exit");
            switch(sc.nextInt()){
                case 1:
                    personAdd();
                    break;
                case 2:
                    disp();
                    break;
                case 3:
                    personModify();
                    break;
                case 4:break;
                case 5:return;
            }
        }
    }
    public void personAdd(){
            while(true){
                System.out.println("<" + (count+1) + "번째 Person의 정보 입력>");
                System.out.print("Name:");
                p[count].setName(sc.next());
                System.out.print("Age:");
                p[count].setAge(sc.nextInt());
                System.out.print("Address:");
                p[count].setAddress(sc.next());
                System.out.println(++count+" 명추가 완료");
                if(count==p.length) {
                    System.out.println(p.length +"명을 모두 추가하였습니다.");
                    return;
                }
            }

    }
    public void personModify(){
        System.out.print("수정하실 Name을 입력해주세요:");
        String findName=sc.next();
        for(int i=0;i<p.length;i++){
            if(p[i].getName().equals(findName)){
                System.out.print("Name 수정 :");
                p[i].setName(sc.next());
                System.out.print("Age 수정 :");
                p[i].setAge(sc.nextInt());
                System.out.print("Address 수정 :");
                p[i].setAddress(sc.next());
                break;
            }
        }
    }

    public void personDelete(){
        System.out.println("삭제하실 Name을 입력해주세요:");
        String findName=sc.next();
        for(int i=0;i<p.length;i++){
            if(p[i].getName().equals(findName)){

            }
        }
    }

    public void disp(){
        for(int i=0;i<p.length;i++){
            System.out.println(p[i]);
        }
    }
    public static void main(String[] args) {
        new PersonMain();

    }
}
