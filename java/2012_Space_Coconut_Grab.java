import java.util.*;

public class Space_Coconut_Grab {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int e = sc.nextInt();
			if (e == 0)
				break;
			int x, y, z;
			int m = 1000000;
			for (z = 0; z * z * z <= e; z++)
				for (y = 0; z * z * z + y * y <= e; y++) {
					x = e - z * z * z - y * y;
					m = Math.min(m, x + y + z);
				}
			System.out.println(m);
		}
		sc.close();
	}
}