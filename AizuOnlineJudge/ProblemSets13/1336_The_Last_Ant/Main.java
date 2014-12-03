// The Last Ant
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			if ((n | l) == 0) {
				break;
			}
			char[] d = new char[n];
			int[] p = new int[n];
			for (int i = 0; i < n; i++) {
				d[i] = sc.next().charAt(0);
				p[i] = sc.nextInt();
			}
			int time = 0;
			int last = -1;
			while (n > 0) {
				time++;
				for (int i = 0; i < d.length; i++) {
					if (p[i] == -1)
						continue;
					if (d[i] == 'L' && p[i] > 0)
						p[i]--;
					if (d[i] == 'R' && p[i] < l)
						p[i]++;
				}
				for (int i = 0; i < p.length; i++) {
					if (p[i] == l) {
						last = i;
						p[i] = -1;
						n--;
					}
				}
				for (int i = 0; i < p.length; i++) {
					if (p[i] == 0) {
						last = i;
						p[i] = -1;
						n--;
					}
				}
				for (int i = 0; i < p.length; i++) {
					if (p[i] == -1)
						continue;
					for (int j = i + 1; j < p.length; j++) {
						if (p[i] == p[j]) {
							char temp = d[i];
							d[i] = d[j];
							d[j] = temp;
						}
					}
				}
			}
			System.out.println(time + " " + (last + 1));
		}
		sc.close();
	}
}
