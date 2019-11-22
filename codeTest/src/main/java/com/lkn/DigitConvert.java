package com.lkn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author LKN
 *
 */
public class DigitConvert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		String str = sc.next().toString();
		
		String str1 = str.replace(" ", "");
		String str2 = str1.substring(str1.indexOf("{")+1,str1.indexOf("}"));
		
		if(str2.length()>1) {
			String[] arr = str2.split(","); 
			int[] l = new int[arr.length]; 
			for (int i = 0; i < l.length; i++) { 
				l[i] = Integer.parseInt(arr[i]);
			}
			 digitMapping(l);
		}else if(str2.length()==1) {
			int[] l = {Integer.parseInt(str2)};
			digitMapping(l);
		}
	}
	
public static String digitMapping(int arr[]) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(0, "");
		map.put(1, "");
		map.put(2, "a b c");
		map.put(3, "d e f");
		map.put(4, "g h i");
		map.put(5, "j k l");
		map.put(6, "m n o");
		map.put(7, "p q r s");
		map.put(8, "t u v");
		map.put(9, "w x y z");
		
		if(arr.length==1) {
			String str0=map.get(arr[0]);
			System.out.println(str0);
			return str0;
		}
		
		if(arr.length==2) {
			String str0=map.get(arr[0]);
			String str1=map.get(arr[1]);
			if(arr[0]==1 || arr[1]==0 || arr[1]==1) {
				if(arr[0]==1 && (arr[1]==0 || arr[1]==1)) {//10 or 11
					System.out.println();
					return "";
				}else if(arr[0]==1 && arr[1]!=0 && arr[1]!=1) {//12-19
					System.out.println(str1);
					return str1;
				}else if(arr[0]!=1 && arr[0]!=0 && (arr[1]==0 || arr[1]==1)) {// (2-9)0 (2-9)1
					System.out.println(str0);
					return str0;
				}
			}else {//无0和1
				String[] s1=map.get(arr[0]).split(" ");
				String[] s2=map.get(arr[1]).split(" ");
				StringBuffer sb = new StringBuffer();
				
				for (int i = 0; i < s1.length; i++) {
					for (int j = 0; j < s2.length; j++) {
						sb.append(s1[i]+s2[j]+" ");
					}
				}
				String s3=sb.toString();
				String s4=s3.trim();
				System.out.println(s4);
				return s4;
			}
		}
		return "";
	}
}
