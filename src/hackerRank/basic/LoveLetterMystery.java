package hackerRank.basic;

import java.util.ArrayList;
import java.util.List;

public class LoveLetterMystery {
public static void main(String[] args) {
	
	System.out.println("1---"+foo("cnjjxpaqeizskbhrktzhxffuvysaqzlumwellgbpoajydqq"));
	System.out.println("2---"+foo("krvjwcgucyuszipnetyqbbhqdtqgjgwvarfyvnsxnpsnxhcbcdtdebviwmo"));
	System.out.println("3---"+foo("ukdudktaxnakcszzbcdffwklzgtvukdowijcsecrrcbwwdxzhaemzrzaztytfdhblsddyiuskxojanijopvpgxrfqpyxshyfc"));
	System.out.println("4---"+foo("iameuyekhgysqohndpkuucmuzgdamfguiubeshpcnnudbdtgsdcoio"));
	System.out.println("5---"+foo("jxnjjtrfdlghgnwkdleiojbubhzpppzymm"));
	System.out.println("6---"+foo("vhbbmnjutzsdcgjkuumpvtqmkfniszunjwqvlarezkjbqunkozblurxgzmrrllguhzsszjyatjdldqytsbeovd"));
	System.out.println("7---"+foo("urmndzt"));
	System.out.println("8---"+foo("jurbtbcvwnykrrimjltzgyuaqinvijurfouzpywnmvxfohrztmyzltcddryncugiibjzzfnncmsqumpnyqojlsmokmcoh"));
	System.out.println("9---"+foo("wplfpnnecpqvimhzbfpqrakfruuvjbfhqtphiclktefdqofuwukpxwwotqjerqlkjarrefeall"));
	System.out.println("10---"+foo("daixyfjncgjszcddttqdftxwxeczroduonuosdbwlmomorrknipsboqautalhfixuclnholtccfrtzdihsakhrmbkopttxqobddir"));
	
	
}

private static int foo(String s) {
	// TODO Auto-generated method stub
	boolean res = palindrome(s);
	if(res) {
		return 0;
	}
	int count=0;
	int j = s.length()-1;
	String s1 = s.substring(0, s.length()/2);
	String s2 = s.substring(s.length()/2, s.length());
	List<Integer> list = new ArrayList<Integer>();
	
	StringBuilder str = new StringBuilder();
	for(int i=s2.length()-1 ;i>=0;i--) {
		str.append(s2.charAt(i));
		}
	str.toString();
	for(int i=0 ;i<s1.length();i++) {
		int value = Math.abs(str.charAt(i)-s1.charAt(i));
		list.add(value);
		}
	
	int sum=0;
	for (Integer in : list) {
		sum += in;
	}

	return sum;
	
}

private static boolean palindrome(String s) {
	StringBuilder str = new StringBuilder();
	for(int i =s.length()-1;i>=0;i--) {
		str.append(s.charAt(i));
	}
	if(str.toString().equals(s)){
		return true;
	}
	return false;
}
}
