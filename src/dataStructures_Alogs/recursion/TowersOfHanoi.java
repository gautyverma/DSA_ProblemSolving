package dataStructures_Alogs.recursion;


/**
 * @author GAUTY
 *	
 */
public class TowersOfHanoi {
public static void main(String[] args) {
	int n = 10;
	hanoiTower(n,'A','B','c');
}

private static void hanoiTower(int n, char fromPeg, char toPeg, char auxPeg) {
	// TODO Auto-generated method stub
	if(n == 1) {
		System.out.println(" Move disk "+n+" fromPeg "+fromPeg+" toPeg "+toPeg);
		return;
	}
	// Move n-1 disks from A to B using C as auxiliary
	hanoiTower(n-1, fromPeg, auxPeg, toPeg);
	System.out.println(" Move disk "+n+" fromPeg "+fromPeg+" toPeg "+toPeg);
	hanoiTower(n-1,auxPeg, toPeg,  fromPeg);
	
}

}
