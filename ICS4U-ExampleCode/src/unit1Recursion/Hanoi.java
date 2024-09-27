package unit1Recursion;

public class Hanoi {
	/**
	 * This code describes the Tower of Hanoi. This can solve 3 blocks <p>
	 * Sep 26, 2024 
	 * @param N
	 * @param Src
	 * @param Aux
	 * @param Dst
	 * @author John.B
	 */
	public static void solve(int N, String Src, String Aux, String Dst) {
	
	if (N == 0){
	return;
	}
	//this sorts out the positions of the tower of Hanoi setup
	solve(N - 1, Src, Dst, Aux);
	
	System.out.println("Move " + Src + " to " + Dst);
	
	solve (N - 1, Aux, Src, Dst);
	
}
// this sets up how many blocks there are if you change the int N
public static void main(String[] args){
 int N = 3;
solve(N, "A", "B", "C");
}
}