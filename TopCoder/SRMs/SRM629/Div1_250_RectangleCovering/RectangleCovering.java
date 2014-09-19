import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleCovering {

	public int minimumNumber(int holeH, int holeW, int[] boardH, int[] boardW) {
		int result = 0;
		List<Board> list = new ArrayList<Board>();
		int wSum = 0;
		for (int i = 0; i < boardH.length; i++) {
			if (Math.min(boardH[i], boardW[i]) > holeH) {
				list.add(new Board(Math.max(boardH[i], boardW[i]), Math.min(
						boardH[i], boardW[i])));
				wSum += Math.max(boardH[i], boardW[i]);
			} else if (Math.max(boardH[i], boardW[i]) > holeH) {
				list.add(new Board(Math.min(boardH[i], boardW[i]), Math.max(
						boardH[i], boardW[i])));
				wSum += Math.min(boardH[i], boardW[i]);
			}
		}
		if (wSum < holeW)
			list.clear();
		Collections.sort(list);
		int a = 0, suma = 0;
		for (Board b : list) {
			a++;
			suma += b.w;
			if (suma >= holeW)
				break;
		}
		list.clear();
		int hSum = 0;
		for (int i = 0; i < boardW.length; i++) {
			if (Math.min(boardW[i], boardH[i]) > holeW) {
				list.add(new Board(Math.max(boardW[i], boardH[i]), Math.min(
						boardW[i], boardH[i])));
				hSum += Math.max(boardH[i], boardW[i]);
			} else if (Math.max(boardW[i], boardH[i]) > holeW) {
				list.add(new Board(Math.min(boardW[i], boardH[i]), Math.max(
						boardW[i], boardH[i])));
				hSum += Math.min(boardH[i], boardW[i]);
			}
		}
		if (hSum < holeH)
			list.clear();
		Collections.sort(list);
		int b = 0, sumb = 0;
		for (Board bb : list) {
			b++;
			sumb += bb.w;
			if (sumb >= holeH)
				break;
		}
		if (a == 0 && b == 0)
			return -1;
		if (a > 0 && b > 0)
			return Math.min(a, b);
		return Math.max(a, b);
	}

	class Board implements Comparable<Board> {
		int w, h;

		Board(int w, int h) {
			this.w = w;
			this.h = h;
		}

		@Override
		public int compareTo(Board anotherBoard) {
			return anotherBoard.w - w;
		}

	}
}
