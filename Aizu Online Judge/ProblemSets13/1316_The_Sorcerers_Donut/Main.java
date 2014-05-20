import java.util.*;

public class The_Sorcerers_Donut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			if ((h | w) == 0)
				break;
			String[] field = new String[h];
			for (int i = 0; i < h; i++) {
				field[i] = sc.next();
			}
			String result = "";
			Set<String> set = new HashSet<String>(0);
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++) {
					int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
					int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
					int px = j;
					int py = i;
					for (int k = 0; k < 8; k++) {
						StringBuilder s = new StringBuilder("");
						do {
							s.append(field[py].charAt(px));
							px = (px + dx[k] + w) % w;
							py = (py + dy[k] + h) % h;
							if (s.length() >= Math.max(2, result.length())
									&& !set.add(s.toString())
									&& (result.length() < s.length() || (result
											.length() == s.length() && result
											.compareTo(s.toString()) > 0))) {
								result = s.toString();
							}
						} while (!(px == j && py == i));
					}
				}
			if (result.length() < 2)
				System.out.println(0);
			else
				System.out.println(result);
		}
		sc.close();
	}
}