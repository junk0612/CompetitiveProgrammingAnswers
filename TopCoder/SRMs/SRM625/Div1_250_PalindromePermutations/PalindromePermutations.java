public class PalindromePermutations {

	public double palindromeProbability(String word) {
		int[] appearance = new int[26];
		for (char c : word.toCharArray())
			appearance[c - 'a']++;
		if (!canMake(appearance))
			return 0;
		int l = word.length();
		double result = 1;
		for (int i = 0; i < appearance.length; i++)
			if (appearance[i] % 2 == 1) {
				result *= (double) appearance[i]-- / l--;
				break;
			}
		for (int a : appearance) {
			while (a > 0) {
				result *= (double) (--a) / (--l);
				a--;
				l--;
			}
		}
		return result;
	}

	private boolean canMake(int[] appearance) {
		boolean odd = false;
		for (int a : appearance)
			if (a % 2 == 1)
				if (odd)
					return false;
				else
					odd = true;
		return true;
	}

}
