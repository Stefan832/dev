package com.demo.answer;

import com.sun.deploy.util.StringUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 #Problem Description
Given an integer array containing digits from [0, 9], the task is to print all possible letter
combinations that the numbers could represent. A mapping of digit to letters (just like
on the telephone buttons) is being followed. Note that 0 and 1 do not map to any
letters. All the mapping are shown in the image below:
Write a program to convert the digits from 0 to 9 into letters
Example:
Input: arr[] = {2, 3}
Output: ad ae af bd be bf cd ce cf
Input: arr[] = {9}
Output: w x y z
#Stage 2 - new requirements
The program need to support converting the digits from 0 to 99 into letters
 */
public class Question {

    // build the map relation 
    private static final String[] MAPPING = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> answer1(int[] arr) {
        // Linked lists are used to assemble the results, in the form of queues
        LinkedList<String> ans = new LinkedList<String>();
        if (arr == null || arr.length == 0) {
            return ans;
        }

        // add a null values
        ans.add("");
        for (int i = 0; i < arr.length; i++) {
            // get the number fom user input
            int x = arr[i];
            // get the element fom the top of list, then determine how many time need to matching accoding the length
            while (ans.peek().length() == i) {
                // get the element and remove it 
                String t = ans.remove();
                // ping the latter values 
                for (char s : MAPPING[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        // if 0 and 1 will replate and reutn 
        return ans.stream().map(s -> s.replaceAll("\\d", "")).collect(Collectors.toList());
    }

    public static List<String> answer2(int[] arr) {
        LinkedList<String> ans = new LinkedList<String>();
        if (arr == null || arr.length == 0) {
            return ans;
        }
        // input number into a map 
        Map<Integer, String> map = new HashMap<>(100);
        for (int i : arr) {
            // sprit the number, eg 17 will sprit 1 and 7, then use their mapping letter. if the number are same, will only use one's latter
			String is = i / 10 != 0 ? (i / 10 == i % 10 ? MAPPING[i / 10] :  MAPPING[i / 10] + MAPPING[i % 10]) : MAPPING[i % 10];
            map.put(i, is);
        }
        
        ans.add("");
        for (int i = 0; i < arr.length; i++) {
            // get the input nummber
            int x = arr[i];
            // get the element fom the top of list, then determine how many time need to matching accoding the length
            while (ans.peek().length() == i) {
                //get the element and remove it 
                String t = ans.remove();
                // ping the latter values 
                for (char s : map.get(x).toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        //  if 0 and 1 will replate and reutn 
        return ans.stream().map(s -> s.replaceAll("\\d", "")).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list = answer1(new int[]{1, 4, 3});
        System.out.println(StringUtils.join(list, ", "));
        List<String> list1 = answer2(new int[]{24, 35, 67});
        System.out.println(StringUtils.join(list1, ", "));
    }
}
