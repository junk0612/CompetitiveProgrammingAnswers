import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		new C().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		System.out.println(f(a));
		sc.close();
	}

	int f(long a) {
		for (int i = 10; i <= 10000; i++) {
			if (toTenAry(i) == a)
				return i;
		}
		return -1;
	}

	long toTenAry(int in) {
		long result = 0;
		String s = Integer.toString(in);
		for (int i = 0; i < s.length(); i++) {
			result += (s.charAt(i) - '0') * Math.pow(in, s.length() - i - 1);
		}
		return result;
	}
}
