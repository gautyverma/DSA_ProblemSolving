package pp;

public class BeautifulArray {
public static void main(String[] args) {
	int[] a = {7,7,2,9};
	int[] b = {1,1,1,9};
	System.out.println(countValue(a, b));
}
private static int countValue(int[] a,int[] b) {
	int count = 0;
	int n = a.length;
	
	for(int i = 0;i<n;i++) {
		if(a[i] == b[i]) {
			i +=1;
		}
		for(int j = i;j<n-1;j++) {
			if(a[j+1] == a[i]) {
				a[j+1] = b[i];
			}
			
			if(j+1 == n -1) {
				count++;
				a[i] = b[i];
			}
		}
	}
	
	return count;
}
}
