package com.salil.dataStructures.arrays;

/**
 * Created by Salil on 28/08/17.
 */
public class MajorityElement {

    public int mostOccuringElement(int a[],int size){
        int maj_index=0;
        int count =1;
        for(int i=1;i<size;i++){
            if(a[maj_index]==a[i])
                count++;
            else
                count--;
            if(count==0){
                maj_index=i;
                count=1;
            }
        }
        return a[maj_index];
    }

    public boolean isMajorityElement(int a[],int size,int maj) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (maj == a[i])
                count++;
        }
        if (count > size / 2)
            return true;

        return false;
    }

    public void printMajority(int a[],int size){
        int maj = mostOccuringElement(a,size);
        if(isMajorityElement(a,size,maj))
            System.out.println(maj);
        else
            System.out.println("NONE");
    }

    public static void main(String[] args){
        MajorityElement majorelement = new MajorityElement();
        //3 3 4 2 4 4 2 4 4
        int a[] = new int[]{3, 3 ,4, 2, 4 ,4 ,2 ,4, 4};
        int size = a.length;
        majorelement.printMajority(a, size);
    }

}
