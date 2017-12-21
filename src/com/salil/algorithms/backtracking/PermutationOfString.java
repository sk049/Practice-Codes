package com.salil.algorithms.backtracking;

/**
 * Created by Salil on 31/08/17.
 */
public class PermutationOfString {

    public String swapCharactersInString(String str,int pos1,int pos2){
        char temp;
        char[] charArray = str.toCharArray();
        temp=charArray[pos1];
        charArray[pos1]=charArray[pos2];
        charArray[pos2]=temp;
        return String.valueOf(charArray);
    }
    public void getPermutationOfString(String str, int l,int r){
        if(l==r){
            System.out.println(str);
        }
        for(int i=l;i<=r;i++){
            str=swapCharactersInString(str,l,i);
            getPermutationOfString(str,l+1,r);
            str=swapCharactersInString(str,l,i);
        }
    }
    public static void main(String[] args){
        String str = "ABC";
        PermutationOfString obj = new PermutationOfString();
        obj.getPermutationOfString(str,0,str.length()-1);
    }
}
