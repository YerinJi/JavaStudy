package com.multi.object.util;

public class StringEx {
    private char[] value;

    public StringEx() {
    }

    public StringEx(char[] value) {
        this.value = value;
    }

    public char chatAt(int index) {
        if(index < 0 || index >= value.length){
            throw new IndexOutOfBoundsException();
        }
        return value[index];
    }


    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj instanceof String){ //obj가 String으로 DownCast가 가능한지 가능하면true, 아니면 false
            char [] other = ((String) obj).toCharArray();
            if(this.value.length==other.length){
                for(int i=0;i<this.value.length;i++){
                    if(value[i]!=other[i]){
                        return false;
                    }//if
                }//for
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
//        String str1 = new String("abc");
//        str1.charAt(0);
//        System.out.println(str1.equals(str1));
        StringEx su = new StringEx("abcd".toCharArray());
        System.out.println(su.equals("abc"));
//        System.out.println(su.chatAt(0));

    }
}
