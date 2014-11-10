import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		new B().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result += Math.pow(-1, i) * (s.charAt(i) - '0');
		}
		System.out.println(result);
		sc.close();
	}
}
