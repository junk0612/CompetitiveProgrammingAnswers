import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		String[] str = new String[1000];
		for (int i = 1; i <= 1000; i++)
			str[i - 1] = Integer.toString(i);
		Arrays.sort(str);
		for (String string : str) {
			System.out.println(string);
		}
	}

}