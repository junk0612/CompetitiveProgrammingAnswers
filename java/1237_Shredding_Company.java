import java.util.*;

public class Shredding_Company {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			if ((t | n) == 0)
				break;
			String nstr = Integer.toString(n);
			int len = nstr.length() - 1;
			int max = 0;
			boolean rejected = false;
			List<String> result = new ArrayList<String>(0);
			for (int i = 0; i < (1 << len); i++) {
				List<String> list = new ArrayList<String>(0);
				int shred = 0;
				for (int j = 0; j < len; j++)
					if ((i & (1 << j)) != 0) {
						list.add(nstr.substring(shred, j + 1));
						shred = j + 1;
					}
				list.add(nstr.substring(shred));
				int sum = 0;
				for (String s : list)
					sum += Integer.parseInt(s);
				if (sum <= t) {
					if (sum > max) {
						max = sum;
						result = list;
						rejected = false;
					} else if (sum == max)
						rejected = true;
				}
			}
			if (rejected)
				System.out.println("rejected");
			else if (max == 0)
				System.out.println("error");
			else {
				System.out.print(max);
				for (String s : result)
					System.out.print(" " + s);
				System.out.println();
			}
		}
		sc.close();
	}
}
