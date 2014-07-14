import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();
		int[] table = new int[26];
		int max = 0;
		for (int i = 0; i < table.length; i++) {
			table[i] = sc.nextInt();
			max = Math.max(table[i], max);
		}
		int result = 0;
		for (int i = 0; i < s.length(); i++)
			result += table[s.charAt(i) - 'a'] * (i + 1);
		for (int i = s.length(); i < s.length() + k; i++)
			result += max * (i + 1);
		System.out.println(result);
		sc.close();
	}
}
