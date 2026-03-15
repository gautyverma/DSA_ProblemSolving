//import java.util.List;
//
//class Tester{
//	public static Boolean isObs(int row, int col, int[][]obs,int k) {
//		for(int i=0;i<k;i++) {
//			if(obs[i][0]==row && obs[i][1]==col) {
//				System.out.println(row+"  ---------   "+col);
//				return true;
//			}
//		
//		}
//		return false;
//	}
//	
//	public static int queensAttack(int n ,int k,int rq,int cq, int[][] obstacles) {
//		int count =0;
//		int tempRq = rq;
//		int tempCq = cq;
//		
//		while(tempRq!=1) {
//			System.out.println("=========Rq --- 1==========");
//			System.out.println("tempRq----"+tempRq);
//			while(tempCq+1!=n) {	
//
//				System.out.println("========== Cq----n ============");
//				System.out.println("tempCq----"+tempCq);
//				if(isObs(tempRq,tempCq,obstacles,k)) {
//					System.out.println("======================");
//					System.out.println("condition--true");
//					break;
//				}
//				else {
//					System.out.println("======================");
//					System.out.println("else");
//					count++;
//				}
//				tempCq++;
//			}
//			
//			tempCq = cq;
//			
//			while(tempCq!=1) {
//
//				System.out.println("=========== Cq----------1 ===========");
//				System.out.println("tempCq----"+tempCq);
//				if(isObs(tempRq,tempCq,obstacles,k)) {
//
//					System.out.println("======================");
//					System.out.println("Condition-true");
//					break;
//				}
//				else {
//
//					System.out.println("======================");
//					System.out.println("else");
//					count++;
//				}
//				tempCq--;
//			}
//			
//			tempRq--;
//		}
//
//		System.out.println("======================");
//		System.out.println("Count"+count);
//
//		System.out.println("======================");
//
//		
//		while(tempRq+1!=n) {
//
//			System.out.println("========== Rq ---- n ===========");
//			System.out.println("tempRq----"+tempRq);
//			while(tempCq+1!=n) {	
//
//				System.out.println("======== Cq----N ==========");
//				System.out.println("tempCq----"+tempCq);
//				if(isObs(tempRq,tempCq,obstacles,k)) {
//
//					System.out.println("======================");
//					System.out.println("Condition");
//					break;
//				}
//				else {
//
//					System.out.println("======================");
//					System.out.println("else");
//					count++;
//					}
//				tempCq++;
//				
//			}
//			
//			tempCq = cq;
//			
//			while(tempCq!=1) {
//				if(isObs(tempRq,tempCq,obstacles,k)) {
//
//					System.out.println("======================");
//					System.out.println("tempCq----"+tempCq);
//					break;
//				}
//				else {
//
//					System.out.println("======================");
//					System.out.println("Else");
//					count++;
//					}
//				tempCq--;
//				
//			}
//			tempRq++;
//		}
//		
//		return count;
//	}
//	
//	
//	public static void main(String[] args) {
//		int n = 5;
//		int k = 3;
//		int rq= 4;
//		int cq= 3;
//		int[][] obs = {{5,5},{4,2},{2,3}};
//		System.out.println(queensAttack(n, k, rq, cq, obs));
//	}
//}
//
////==========================================================
//
////import java.util.Scanner;
////
////class Tester{
////	public static String hour(int h) {
////		String str = null;
////		if(h==1||h==13) {str="one";}
////		else if(h==2) {str="two";}
////		else if(h==3) {str="three";}
////		else if(h==4) {str="four";}
////		else if(h==5) {str="five";}
////		else if(h==6) {str="six";}
////		else if(h==7) {str="seven";}
////		else if(h==8) {str="eight";}
////		else if(h==9) {str="nine";}
////		else if(h==10) {str="ten";}
////		else if(h==11) {str="eleven";}
////		else if(h==12) {str="tweleve";}
////		return str;
////	}
////	public static String min(int m) {
////		String[] minutes = {"", " one", " two", " three", " four", " five",
////				" six", " seven", " eight", " nine", " ten", " eleven",
////				" twelve", " thirteen", " fourteen", " fifteen", " sixteen",
////				" seventeen", " eighteen", " nineteen","twenty","twenty one"
////				,"twenty two","twenty three","twenty four","twenty five","twenty six"
////				,"twenty seven","twenty eight","twenty nine"};
////		
////		if(m==15) {
////			return "quater";
////		}
////		else if(m==30) {
////			return "half";
////		}
////		else {
////			return minutes[m];
////		}
////	}
////	public static String time(int h,int m) {
////		String str=null;
////		if(m<=30 && m>0) {
////			String hour = hour(h);
////			String min = min(m);
////			if(m==30 || m==15) {str = min+" past "+hour;}
////			else
////			{str = min+" minutes past "+hour;}
////		}
////		else if(m>30 && m>0) {
////			String hour = hour(h+1);
////			String min = min(60-m);
////			if(m==45) {
////				str = min+" to "+hour;
////			}
////			else {
////			str = min+" minutes to "+hour;
////				}
////			}
////		else if(m==0) {
////			String hour = hour(h);
////			str = hour+ " o'clock";
////		}
////		return str;
////	}
////	public static void main(String[] args) {
////		Scanner sc = new Scanner(System.in);
////		int h = sc.nextInt();
////		int m = sc.nextInt();
////		System.out.println(time(h,m));
////	}
////}
//
//
////=========================================
////import java.util.*;
////
////class Tester{
////	public static String foo(String str) {
////		int size = str.length();
////        char[] ch = str.toCharArray();
////        char temp;
////        int i = size-1;
////        while(i>0 && (int)ch[i-1]>=(int)ch[i]) {
////        	i--;
////        }
////        
////        if(i<=0) {
////        return "no answer";
////        }
////        
////        int j=size-1;
////        while((int)ch[j]<=(int)ch[i-1]) {
////        	j--;
////        }
////        
////        temp = ch[j];
////        ch[j]=ch[i-1];
////        ch[i-1]=temp;
////        
////        j = size-1;
////        while(i<j) {
////        	
////        	temp = ch[i];
////        	ch[i]=ch[j];
////        	ch[j]=temp;
////        	i++;
////        	j--;
////        }
////         return String.valueOf(ch);
////	}
////
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        String str = sc.next();
////        System.out.println(foo(str));
////        
////    }
////}
//
////======================================================
//
////import java.io.*;
////import java.util.*;
////
////
////class Tester{
////
////    public static void main(String[] args) {
////        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//////        Scanner sc = new Scanner(System.in);
//////        String input = sc.next();
//////        int size = input.length();
//////        
////        String str = "khdc";
//////        String str = "bbbb";
////        Boolean flag = false;
////        char[] ch = str.toCharArray();
////        int size = str.length();
////        char temp;
////        System.out.println(str.charAt(0));
////        System.out.println((int)str.charAt(0));
////        
////        	if((int)ch[size-1]>(int)ch[size-2]) {
////        		flag = true;
////        		temp=ch[size-1];
////        		ch[size-1]=ch[size-2];
////        		ch[size-2]=temp;
////        	}
////        	else {
////        		for(int i=0;i<size;i++) {
////        	
////        			temp = ch[i];
////        			if((int)temp>(int)ch[i+1]) {
////       
////        				int k=0,j = 1;
////        				while(k<size-1) {
////        					
////        					if(ch[j]<ch[k]) {
////        						j++;
////        						k++;
////        					}
////        					else {
////        						break;
////        					}
////        					if(j==size-1) {
////        						flag=true;
////        						break;
////        					}
////        				}
////        			}
////        			
////        		}
////        		
////        	}
////        	
////        
////        if(flag == true) {
////        for(int i=0;i<size;i++) {
////        	System.out.print(ch[i]);
////        }}
////        else {
////        	System.out.println("no answer");
////        }
////   
////    }
////}
//
////======================================================
////import java.io.*;
////import java.util.*;
////
////
////class Tester{
////
////    public static void main(String[] args) {
////        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
////        Scanner sc = new Scanner(System.in);
////        String input = sc.next();
////        int size = input.length();
////        int rowSize = (int)Math.floor(Math.sqrt(size));
////        int colSize = (int)Math.ceil(Math.sqrt(size));
////
////        System.out.println("rows---"+rowSize);
////        System.out.println("col---"+colSize);
////        System.out.println("===========================");
////        while(colSize>rowSize){
////            colSize--;
////            if((colSize*rowSize)<size){
////                colSize++;
////                break;
////            }
////        }
////        while((colSize*rowSize)<size&&(colSize>rowSize)){
////            rowSize++;
////        }
////        System.out.println("rows---"+rowSize);
////        System.out.println("col---"+colSize);
////        for(int i =0;i<colSize;i++){
////            
////            int row = 0;
////            while(row<=rowSize-1){
////                if((i+row*colSize)<size)
////                {
////                    System.out.print(input.charAt(i+row*colSize)); 
////                     row++;
////                }     else{
////                    break;
////                }        
////             
////            }
////            System.out.print(" ");
////        }
////    }
////}
////
////======================================================
////import java.util.Scanner;
//
////
////public class Tester {
////	
////	public static void foo(int rows,int col,String s) {
////
////		int temp = 0;			
////		char[][] ch = new char[rows][col];
////		int n= s.length();
////		
//
////		for(int i = 0;i<rows+1;i++) {
////			for(int j=0;j<col;j++) {
////				if(temp<n) {
////				ch[i][j]=s.charAt(temp);
////				temp++;}
////			}
////		}
////			
////		for(int i = 0;i<col;i++) {
////			for(int j=0;j<rows+1;j++) {
////				System.out.print(ch[j][i]);
////			}
////			System.out.print(" ");
////		}
////	}
////	
////public static void main(String[] args) {
//////	
//////	Scanner obj = new Scanner(System.in);
//////	String str = obj.nextLine();
////	String str = "chillout";
////	double n = Math.sqrt(str.length());
////	
////	if(n<2 && n>1) {
////		int rows = 1;
////		int col = 2;
////		foo(rows,col,str);
////		}
////	
////
////	else if(n<3 && n>2) {
////	int rows = 2;
////	int col = 3;
////	foo(rows,col,str);
////	}
////	else if(n<4 && n>3) {
////		int rows = 3;
////		int col = 4;
////		foo(rows,col,str);
////		}
////	else if(n<5 && n>4) {
////		int rows = 4;
////		int col = 5;
////		foo(rows,col,str);
////		}
////	else if(n<6 && n>5) {
////		int rows = 5;
////		int col = 6;
////		foo(rows,col,str);
////		}
////	else if(n<7 && n>6) {
////		int rows = 6;
////		int col = 7;
////		foo(rows,col,str);
////		}
////	else if(n<8 && n>7) {
////		int rows = 7;
////		int col = 8;
////		foo(rows,col,str);
////		}
////	else if(n<9 && n>8) {
////		int rows = 8;
////		int col = 9;
////		foo(rows,col,str);
////		}
////}
////}
//
//
////
////import java.util.Scanner;
////
////public class Tester {
////public static void main(String[] args) {
////	
////	Scanner in = new Scanner(System.in);
////	int m = in.nextInt();
////	for(int k=0;k<m;k++) {
////		int n = in.nextInt();
////		int[] a = new int[n];
////		int[] b = new int[n];
////		for(int i=0; i<n; i++)
////		{
////		    for(int j=0; j<n; j++)
////		    {
////		        int x = in.nextInt();
////		        a[i] += x;
////		        b[j] += x;
////		    }
////		}
////		String pts = "Possible";
////		for(int i=0;i<n;i++)
////		{
////		    int j=0;
////		    for(j=i;j<n;j++)
////		    {
////		        if(a[i] == b[j])
////		        {
////		            int temp = b[j];
////		            b[j] = b[i];
////		            b[i] = temp;
////		            break;
////		        }
////		    }
////		    if(j==n)
////		    {
////		        pts = "Impossible";
////		        break;
////		    }
////		}
////		System.out.println(pts);
////		}
////}
////}
////
//
//
//
////================================================
//
////public class Tester {
////public static void main(String[] args) {
////	String s = "SOSSPSRORTST";
////	String sos ="SOS";
////	int count = 0;
////	
////	for(int i =0 ;i<s.length();i++) {
////		if(s.charAt(i)!=sos.charAt(i%3)) {
////			count++;
////		}
////		System.out.println(i%3);
////	}
////	System.out.println(count);
////	}
////}