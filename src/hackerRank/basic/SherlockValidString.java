package hackerRank.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SherlockValidString {
	public static void main(String[] args) {
		System.out.println(foo("aaaabbcc"));
	}

	private static String foo(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		if(s.length()==1) {
			return "YES";
		}
		char[] arr = s.toCharArray();

		for (char c : arr) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		List<Integer> list = new ArrayList<Integer>();

		for (Map.Entry e : map.entrySet()) {
//			System.out.println(e.getKey()+" -> "+e.getValue());
			list.add((Integer) e.getValue());
		}
		System.out.println(list);
		String res = fun(list);
		return res;
	}

	private static String fun(List<Integer> list) {
		// TODO Auto-generated method stub
		int n = list.size();
		int key1 = list.get(0);
		int key2 = list.get(1);
		int temp = 0;

		if (n == 1) {
			return "YES";
		} else if (n == 2 && key1 == key2) {
			return "YES";
		}

		else {

			if (key1 == key2) {
				 temp = key1;
			} else {
				key2 = list.get(2);
				if (key1 == key2) {
					 temp = key1;
				} else {
//					return "NO";
					key1 = list.get(1);
					if(key1==key2) {
						temp=key1;
					}
					else {
						return "NO";
					}
				}
			}
		}
		System.out.println(temp);
		int count = 0;
		for (Integer i : list) {
			if(i!=temp) {
				count++;
			}
			
			if(count>1) {
				return "NO";
			}
		}
		
		if(count==1) {
			for (Integer i : list) {
				if(i!=temp) {
					if(i==1) {
						return "YES";
					}
					else if(i-1==temp){
						return "YES";
					}
					else {
						return "NO";
					}
				}
			}
		}
		return "YES";
	}
}


//private static String fun(List<Integer> list) {
//    // TODO Auto-generated method stub
//    int n = list.size();
//    int key1 = list.get(0);
//    int key2 = list.get(1);
//    int temp = 0;
//
//    if (n == 1) {
//        return "YES";
//    } else if (n == 2 && key1 == key2) {
//        return "YES";
//    }
//
//    else {
//
//        if (key1 == key2) {
//             temp = key1;
//        } else {
//            key2 = list.get(2);
//            if (key1 == key2) {
//                 temp = key1;
//            } else {
//                return "NO";
//            }
//        }
//    }
//    int count = 0;
//    for (Integer i : list) {
//        if(i!=temp) {
//            count++;
//        }
//        
//        if(count>1) {
//            return "NO";
//        }
//    }
//    return "YES";
//}
//
//
//public static String isValid(String s) {
//// Write your code here
//if(s.length()==1) {
//        return "YES";
//    }
//Map<Character, Integer> map = new HashMap<Character, Integer>();
//    char[] arr = s.toCharArray();
//
//    for (char c : arr) {
//        if (map.containsKey(c)) {
//            map.put(c, map.get(c) + 1);
//        } else {
//            map.put(c, 1);
//        }
//    }
//
//    List<Integer> list = new ArrayList<Integer>();
//
//    for (Map.Entry e : map.entrySet()) {
////        System.out.println(e.getKey()+" -> "+e.getValue());
//        list.add((Integer) e.getValue());
//    }
//    System.out.println(list);
//    String res = fun(list);
//    return res;
//
//
//}

