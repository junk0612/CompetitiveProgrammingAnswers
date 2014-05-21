public class Cubist_Artwork {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		while (true) {
			int w = sc.nextInt();
			int d = sc.nextInt();
			if (w == 0 && d == 0)
				break;
			int[] hw = new int[21];
			int[] hd = new int[21];
			for (int i = 0; i < w; i++)
				hw[sc.nextInt()]++;
			for (int i = 0; i < d; i++)
				hd[sc.nextInt()]++;
			int result = 0;
			for (int i = 1; i < 21; i++)
				result += i * Math.max(hw[i], hd[i]);
			System.out.println(result);
		}
		sc.close();
	}
}
