package com.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import com.lkn.DigitConvert;
/**
 * 测试类
 * @author LKN
 *
 */
public class DigitConvertTest {

	@Test
	public void testDigitMapping() {
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
			 assertTrue((DigitConvert.digitMapping(l).compareTo("ad ae af bd be bf cd ce cf"))==0);
		}else if(str2.length()==1) {
			int[] l = {Integer.parseInt(str2)};
			assertTrue((DigitConvert.digitMapping(l).compareTo("w x y z"))==0);
		}
	}

}
