package com.daojia.test.generic;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by allen on 17/12/20.
 */

public class Fruit extends Food {

    public static void quick_sort(int s[],int l,int r){
        if (l < r){
            int i = l,j = r, x = s[i];
            while (i < j){

                while (i < j && s[j] > x){
                     j--;//从右向左找小于x的数
                }

                if (i < j){
                    s[i ++ ] = s[j];
                }

                while ( i < j && s[i] < x){
                    i++;
                }

                if (i < j){
                    s[j --] = s[i];
                }
            }

            s[i] = x;
            quick_sort(s,l,i-1);
            quick_sort(s,i+1,r);

        }
    }

    public static void bubble_sort(int[] n){

        int temp;

        for (int i = 0 ; i < n.length -1;i ++){

            for (int j = 0 ; j < n.length - 1 - i ; j ++){

                if (n[j] > n [j =1]){
                    temp = n[i];
                    n[i] = n [ i +1];
                    n[i +1] = temp;
                }

            }


        }



    }


    public int getMaxSumArray(int[] array){

      if (array == null || array.length == 0){
          throw new IllegalArgumentException();
      }

      int max = Integer.MIN_VALUE;

      int currentMax = 0;

      for (int i: array){

          if (currentMax <= 0){
              currentMax = i;
          }else {
              currentMax += i;
          }

          if (currentMax > max){
              max = currentMax;
          }

      }

      return max;
  }

  class ListNode{
      int val;
      ListNode next;

      public ListNode(int val){
          this.val = val;
      }
  }

  public ArrayList<Integer> printListFromTialtoHead(ListNode listNode){

      Stack<Integer> stack = new Stack<>();

      while (listNode != null){
          stack.push(listNode.val);
          listNode = listNode.next;
      }

      ArrayList<Integer> arrayList = new ArrayList<>();

      while (!stack.isEmpty()){
          arrayList.add(stack.pop());
      }

      return arrayList;

  }

}
