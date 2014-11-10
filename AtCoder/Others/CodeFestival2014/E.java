import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E {
	public static void main(String[] args) {
		new E().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] rates = new int[n];
		for (int i = 0; i < n; i++) {
			rates[i] = sc.nextInt();
		}
		int result = 2;
		List<Integer> rateList = new ArrayList<Integer>();
		rateList.add(rates[0]);
		for (int i = 1; i < n; i++) {
			if (rates[i - 1] != rates[i])
				rateList.add(rates[i]);
		}
		for (int i = 1; i < rateList.size() - 1; i++) {
			if ((rateList.get(i - 1) < rateList.get(i) && rateList.get(i) > rateList
					.get(i + 1))
					|| (rateList.get(i - 1) > rateList.get(i) && rateList
							.get(i) < rateList.get(i + 1)))
				result++;
		}
		if (result < 3)
			result = 0;
		System.out.println(result);
		sc.close();
	}

}
