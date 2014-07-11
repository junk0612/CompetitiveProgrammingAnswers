public class HappyLetterDiv2 {

	public char getHappyLetter(String letters) {
		int[] appears = new int[26];
		for (int i = 0; i < letters.length(); i++)
			appears[letters.charAt(i) - 'a']++;
		for (int i = 0; i < 26; i++)
			if (appears[i] > letters.length() / 2)
				return (char) (i + 'a');
		return '.';
	}

}
