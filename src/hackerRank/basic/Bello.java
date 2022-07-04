package hackerRank.basic;

public class Bello {
	public static void main(String[] args) throws Exception {

//		Path v1 = Paths.get("/./forest/./").resolve(Paths.get("tree.txt"));
//		Path v2 = new File("/forest/./water/../tree.txt").toPath();
//	System.out.println(Files.isSameFile(v1, v2));
//		System.out.println(" " + v1.equals(v2));
//		System.out.println(" " + v1.normalize().equals(v2.normalize()));
//		
//		Path p0 = Path.of("/users","harry");
//		Path p1 = Path.of("/users","harry","file","my.txt");
//		
//	
//	for(int i = 0;i<p1.getNameCount();i++) {
//		Path p2 = p1.getName(i);
//	}
//	Files.walk(p0).map(p->p.toString()).forEach(System.out::println);
		
		MyInterface myInterface = a->a+1;
		System.out.println(myInterface.add(10));
		
	}
	interface MyInterface{
		int add(int x);
	}
	}
