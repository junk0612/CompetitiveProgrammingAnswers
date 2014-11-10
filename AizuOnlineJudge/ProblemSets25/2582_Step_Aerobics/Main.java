// Step Aerobics
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			boolean onTheFloor = true;
			boolean lf = true;
			boolean rf = true;
			int result = 0;
			for (int i = 0; i < n; i++) {
				String input = sc.next();
				if (input.equals("lu"))
					lf = false;
				else if (input.equals("ru"))
					rf = false;
				else if (input.equals("ld"))
					lf = true;
				else
					rf = true;
				if (!onTheFloor && lf && rf) {
					onTheFloor = true;
					result++;
				}
				if (onTheFloor && !lf && !rf) {
					onTheFloor = false;
					result++;
				}
			}
			System.out.println(result);
		}
		sc.close();
	}
}
