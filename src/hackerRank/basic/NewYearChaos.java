package hackerRank.basic;
import java.util.Scanner;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NewYearChaos {
public static void main(String[] args) {
	Integer[] arr = {1, 2, 5, 3, 7, 8, 6, 4};
	List<Integer> q = Arrays.asList(arr);
	fun(q);
}

private static void fun(List<Integer> q) {

	int count=0,e1=1,e2=2,e3=3;
	for (Integer i : q) {
		if(i==e1) {
			e1=e2;
			e2=e3;
			e3++;
			}
		else if(i==e2) {
		e2=e3;
		e3++;
		count++;
	}
		else if(i==e3) {
		count += 2;
		e3++;
		}
		else {
			System.out.println("Too chaotic");
			return;
		}
		}
	System.out.println(count);
	}
	
//	List<Integer> list = new ArrayList<Integer>();
//	for (Integer i : q) {
//		list.add(i);
//	}
//	
//	Collections.sort(list);
//	
//	int maxBribe = 2;
//	int count = 0;
//	int n = list.size();
//	boolean flag = true;
//	
//	for(int i = n-1;i>=0;i--) {
//		int val1 = list.get(i);
//		for(int j = n-1;j>=0;j--) {
//			int val2=q.get(j);
//			if(val1==val2) {
//				int diff = i-j;
//				if(diff<=maxBribe) {
//				if(i-j>0) {
//					count += i-j;}
//				}
//				else {
//					 flag = false;
//					}
//			}
//		}
//	}
//	if(flag) {
//		System.out.println(count);
//	}
//	else {System.out.println("Too chaotic");}
//	}
}
