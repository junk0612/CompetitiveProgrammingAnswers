import java.util.*;

public class A {
	public static void main(String[] args) {
		new A().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		double t = 50;
		System.out.println(t / s);
		sc.close();
	}
}
