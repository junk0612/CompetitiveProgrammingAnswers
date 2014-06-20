import java.util.Arrays;

public class IncrementingSequence {

	public String canItBeDone(int k, int[] A) {
		boolean[] B = new boolean[A.length];
		Arrays.fill(B, true);
		out: for (int i = 1; i <= A.length; i++) {
			for (int j = 0; j < A.length; j++)
				if (B[j] && A[j] == i) {
					B[j] = false;
					continue out;
				}
			for (int j = 0; j < A.length; j++)
				if (B[j] && (A[j] - i) % k == 0) {
					B[j] = false;
					continue out;
				}
			return "IMPOSSIBLE";
		}
		return "POSSIBLE";
	}

}
