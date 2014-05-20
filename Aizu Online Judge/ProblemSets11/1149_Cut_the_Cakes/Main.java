// Cut the Cake
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			if ((n | w | h) == 0) {
				break;
			}
			List<Cake> list = new ArrayList<Cake>();
			list.add(new Cake(w, h));
			for (int i = 0; i < n; i++) {
				int p = scanner.nextInt() - 1;
				Cake oldCake = list.remove(p);
				int width = oldCake.width, height = oldCake.height;
				int l = width * 2 + height * 2;
				int s = scanner.nextInt() % l;
				if (s < width) {
					Cake newCake1 = new Cake(s, height);
					Cake newCake2 = new Cake(width - s, height);
					if (newCake1.width < newCake2.width) {
						list.add(newCake1);
						list.add(newCake2);
					} else {
						list.add(newCake2);
						list.add(newCake1);
					}
				} else if (s < width + height) {
					Cake newCake1 = new Cake(width, s - width);
					Cake newCake2 = new Cake(width, height + width - s);
					if (newCake1.height < newCake2.height) {
						list.add(newCake1);
						list.add(newCake2);
					} else {
						list.add(newCake2);
						list.add(newCake1);
					}
				} else if (s < width * 2 + height) {
					Cake newCake1 = new Cake(s - width + -height, height);
					Cake newCake2 = new Cake(width * 2 + height - s, height);
					if (newCake1.width < newCake2.width) {
						list.add(newCake1);
						list.add(newCake2);
					} else {
						list.add(newCake2);
						list.add(newCake1);
					}
				} else {
					Cake newCake1 = new Cake(width, s - width * 2 - height);
					Cake newCake2 = new Cake(width, l - s);
					if (newCake1.height < newCake2.height) {
						list.add(newCake1);
						list.add(newCake2);
					} else {
						list.add(newCake2);
						list.add(newCake1);
					}
				}
			}
			List<Integer> sList = new ArrayList<Integer>();
			for (Cake cake : list) {
				int s = cake.width * cake.height;
				sList.add(s);
			}
			Collections.sort(sList);
			StringBuilder sb = new StringBuilder();
			for (Integer i : sList) {
				sb.append(" ");
				sb.append(i);
			}
			sb.delete(0, 1);
			System.out.println(sb.toString());
		}
		scanner.close();
	}
}

class Cake {
	int width, height;

	Cake(int w, int h) {
		width = w;
		height = h;
	}
}