import java.util.Arrays;
import java.util.Scanner;

public class Ohga_Fortune {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int money = sc.nextInt();
			int year = sc.nextInt();
			int n = sc.nextInt();
			int[] result = new int[n];
			int max = 0;
			for (int j = 0; j < n; j++) {
				int tmoney = money;
				int mer = 0;
				int v = sc.nextInt();
				double per = sc.nextDouble();
				int a = sc.nextInt();
				if (v == 0) {
					for (int k = 0; k < year; k++) {
						mer += tmoney * per;
						tmoney -= a;
					}
					result[j] = tmoney + mer;
				}
				if (v == 1) {
					for (int k = 0; k < year; k++) {
						tmoney += tmoney * per;
						tmoney -= a;
					}
					result[j] = tmoney;
				}
			}
			for (int j = 0; j < n; j++)
				if (max < result[j])
					max = result[j];
			System.out.println(max);
		}
		sc.close();
	}
}
