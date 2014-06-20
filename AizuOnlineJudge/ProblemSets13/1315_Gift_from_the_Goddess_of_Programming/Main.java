import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[] etimes = new int[1000];
			int[] times = new int[1000];
			String currentDay = "";
			for (int i = 0; i < n; i++) {
				String day = sc.next();
				String time = sc.next();
				char io = sc.next().charAt(0);
				int id = sc.nextInt();
				if (!day.equals(currentDay)) {
					currentDay = day;
					for (int j = 1; j < 1000; j++)
						if (etimes[i] != 0) {
							etimes[i] = 0;
							if (etimes[0] != 0)
								etimes[i] += 24 * 60 - 1 - etimes[i];
						}
					etimes[0] = 0;
				}
				if (io == 'I') {
					String[] s = time.split(":");
					int t = Integer.parseInt(s[0]) * 60
							+ Integer.parseInt(s[1]);
					etimes[id] = t;
				} else {
					String[] s = time.split(":");
					int otimes = Integer.parseInt(s[0]) * 60
							+ Integer.parseInt(s[1]);
					if (id == 0) {
						for (int j = 1; j < 1000; j++)
							if (etimes[j] != 0)
								times[j] += otimes
										- Math.max(etimes[0], etimes[j]);
					} else if (etimes[0] != 0)
						times[id] += otimes - Math.max(etimes[0], etimes[id]);
					etimes[id] = 0;
				}
			}
			int result = 0;
			for (int i = 1; i < 1000; i++) {
				result = Math.max(result, times[i]);
			}
			System.out.println(result);
		}
		sc.close();
	}
}
