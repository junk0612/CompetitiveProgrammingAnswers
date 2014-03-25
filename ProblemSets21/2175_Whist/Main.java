import java.util.*;

public class Whist {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			char trump = sc.next().charAt(0);
			if (trump == '#')
				break;
			String[][] cards = new String[4][13];
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 13; j++)
					cards[i][j] = sc.next();
			int ns = -6;
			int ew = -6;
			int leader = 0;
			for (int turn = 0; turn < 13; turn++) {
				char suit = cards[leader][turn].charAt(1);
				int winner = 0;
				for (int i = 1; i < 4; i++) {
					char wsuit = cards[winner][turn].charAt(1);
					char isuit = cards[i][turn].charAt(1);
					if (wsuit != isuit) {
						if (isuit == trump || (isuit == suit && wsuit != trump))
							winner = i;
					} else {
						int wnum = getInt(cards[winner][turn].charAt(0));
						int inum = getInt(cards[i][turn].charAt(0));
						if (wnum < inum)
							winner = i;
					}
				}
				leader = winner;
				if (leader % 2 == 0)
					ns++;
				else
					ew++;
			}
			if (ns > ew)
				System.out.println("NS " + ns);
			else
				System.out.println("EW " + ew);
		}
		sc.close();
	}

	static int getInt(char c) {
		if (c == 'A')
			return 14;
		if (c == 'K')
			return 13;
		if (c == 'Q')
			return 12;
		if (c == 'J')
			return 11;
		if (c == 'T')
			return 10;
		return c - '0';
	}
}
