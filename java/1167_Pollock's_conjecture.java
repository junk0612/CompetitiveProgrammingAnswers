import java.util.*;

public class Polloc_conjecture {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] tri = new int[200];
		for (int i = 0; i < tri.length; i++)
			tri[i] = i * (i + 1) * (i + 2) / 6;
		int[] answer = new int[1000001];
		int[] answer_odd = new int[1000001];
		answer[0] = 0;
		answer_odd[0] = 0;
		for (int i = 1; i < answer.length; i++) {
			answer[i] = i;
			answer_odd[i] = i;
			for (int j = 0; tri[j] <= i; j++) {
				answer[i] = Math.min(answer[i], answer[i - tri[j]] + 1);
				if (tri[j] % 2 == 1)
					answer_odd[i] = Math.min(answer_odd[i], answer_odd[i
							- tri[j]] + 1);
			}
		}
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			System.out.println(answer[n] + " " + answer_odd[n]);
		}
		sc.close();
	}
}
