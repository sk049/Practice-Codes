package com.salil.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Salil on 28/08/17.
 */
public class SubSets {
    public ArrayList<ArrayList<Integer>>  getSubsets(ArrayList<Integer> a){
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output.add(new ArrayList<Integer>());
        if(a.size()==0){
            return output;
        }
        //Collections.sort(a);
        generate(a,output,new ArrayList<Integer>(),0);
        return output;
    }
    public void generate(ArrayList<Integer> a,ArrayList<ArrayList<Integer>> outPut,ArrayList<Integer> temp, int index){
        for(int i = index;i<a.size(); i++){
            temp.add(a.get(i));
            outPut.add(new ArrayList<Integer>(temp));
            generate(a,outPut,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();
        //int arr[] = {10, 7, 5, 18, 12, 20, 15};
        int arr[] = {1,2,3};
        //char arr[]={'h','e','l','l','o'};
        for(int i=0;i<arr.length;i++){
            arrayList.add(arr[i]);
        }
        SubSets ob = new SubSets();
        System.out.println(ob.getSubsets(arrayList));
    }
}
