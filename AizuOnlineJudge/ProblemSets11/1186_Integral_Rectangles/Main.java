// Integral Rectangles
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			if ((w | h) == 0)
				break;
			int resw = 150;
			int resh = 150;
			e: for (int i = 1; i <= 150; i++)
				for (int j = i + 1; j <= 150; j++) {
					if (i > resw && j > resw)
						break e;
					if ((w * w + h * h < i * i + j * j || (w * w + h * h == i
							* i + j * j && i > h))
							&& (resw * resw + resh * resh > i * i + j * j || (resw
									* resw + resh * resh == i * i + j * j && resh > i))) {
						resw = j;
						resh = i;
					}
				}
			System.out.println(resh + " " + resw);
		}
		sc.close();
	}
}
