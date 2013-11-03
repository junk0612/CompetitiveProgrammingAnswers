import java.util.*;

public class Matsuzaki_Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] pr = new int[103000];
		for (int i = 0; i < pr.length; i++)
			pr[i] = 1;
		pr[0] = 0;
		pr[1] = 0;
		for (int i = 2; i < Math.sqrt(pr.length); i++)
			if (pr[i] == 1)
				for (int j = i * 2; j < pr.length; j += i)
					pr[j] = 0;
		while (true) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			if (n == -1 && p == -1)
				break;
			Vector<Integer> v = new Vector<Integer>(0);
			int a = n + 1;
			while (v.size() <= p) {
				if (pr[a] == 1)
					v.add(a);
				a++;
			}
			Vector<Integer> r = new Vector<Integer>(0);
			for (int i = 0; i < v.size(); i++)
				for (int j = i; j < v.size(); j++)
					r.add(v.get(i) + v.get(j));
			int[] result = new int[p * (p + 1) / 2];
			for (int i = 0; i < result.length; i++)
				result[i] = r.get(i);
			Arrays.sort(result);
			System.out.println(result[p - 1]);
		}
		sc.close();
	}
}
