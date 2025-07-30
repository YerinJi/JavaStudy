package com.multi.array;
//Array기반 CRUD
//isFull, isEmpty, add, disp, search, delete, modify

public class ArrayEx7 {
    int []m = new int[5];
    int size=m.length;
    int count;

    public boolean isFull(){
        return count>=size;
    }
    public boolean isEmpty(){
        return count==0;
    }

    public void add(int item){
        //fullCheck
        if(!isFull()){
            m[count++]=item; //item추가
        }else{
            System.out.println("Array is Full Cannot Add" + item);
        }
//        disp();
    }

    public void disp(){
        if(isEmpty()){
            System.out.println("Array is Empty");
        } else{
            for(int i=0; i< count; i++){
                System.out.print(m[i]+"\t");
            }
            System.out.println();
        }

    }

    public int search(int data){
        for(int i=0; i<m.length; i++){
            if(m[i]==data) return i;
        }
        return -1;
    }

    public void delete(int item){
        int index=search(item);
        if(index==-1){
            System.out.println("Not Found!");
            return;
        }
        for(int i=index; i<count-1; i++){
            m[i]=m[i+1];
        }
        count--;
        System.out.println("Delete item="+index);
    }

    //10 20 30 30
    public void modify(int origin,int change) {
        int index=search(origin);
        if(index>=0&& index<count) {
            m[index]=change;
            System.out.println("Modified index "+index+" with"+change);
        }else {
            System.out.println("Not Found!");
        }

    }

    public static void main(String[] args) {
        ArrayEx7 a=new ArrayEx7();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
        a.add(50);
        a.disp();
        a.delete(30);
        a.disp();
    }


}
