import java.util.*;

public class Organize_Your_Train_partII {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String train = sc.next();
			HashSet<String> trains = new HashSet<String>();
			for (int j = 1; j < train.length(); j++) {
				String sstr = train.substring(0, j);
				String estr = train.substring(j);
				String rsstr = reverse(sstr);
				String restr = reverse(estr);
				trains.add(sstr + estr);
				trains.add(estr + sstr);
				trains.add(rsstr + estr);
				trains.add(estr + rsstr);
				trains.add(sstr + restr);
				trains.add(restr + sstr);
				trains.add(rsstr + restr);
				trains.add(restr + rsstr);
			}
			System.out.println(trains.size());
		}
		sc.close();
	}

	static String reverse(String str) {
		char[] c = str.toCharArray();
		char[] rc = new char[c.length];
		for (int i = 0; i < c.length; i++)
			rc[i] = c[c.length - i - 1];
		String s = String.valueOf(rc);
		return s;
	}
}