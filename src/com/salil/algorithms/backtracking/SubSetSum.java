package com.salil.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Salil on 29/08/17.
 */
public class SubSetSum {
    static int constantSum = 35;
    public boolean isSum(ArrayList<Integer> list){
        int sum = 0;
        for(int i=0 ;i<list.size();i++){
            sum += list.get(i);
        }
        if(sum==constantSum)
            return true;

        return false;
    }
    public void generateSumSubsetsUtil(ArrayList<Integer> a,ArrayList<ArrayList<Integer>> outPut,ArrayList<Integer> temp, int index){
        for(int i=index;i<a.size();i++){
            temp.add(a.get(i));
            if(isSum(temp)){
                outPut.add(new ArrayList<Integer>(temp));
            }
            generateSumSubsetsUtil(a, outPut, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public ArrayList<ArrayList<Integer>>  getSubsetsOfTargetSum(ArrayList<Integer> a){
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        //output.add(new ArrayList<Integer>());
        if(a.size()==0){
            return output;
        }
        Collections.sort(a);
        generateSumSubsetsUtil(a,output,new ArrayList<Integer>(),0);
        return output;
    }
    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();
        int arr[] = {10, 7, 5, 18, 12, 20, 15};
        //int arr[] = {1,2,3};
        for(int i=0;i<arr.length;i++){
            arrayList.add(arr[i]);
        }
        SubSetSum ob = new SubSetSum();
        System.out.println(ob.getSubsetsOfTargetSum(arrayList));
    }
}
