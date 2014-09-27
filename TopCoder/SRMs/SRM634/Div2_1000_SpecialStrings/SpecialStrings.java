public class SpecialStrings {

	public String findNext(String current) {
		long l = 0;
		for (int i = 0; i < current.length(); i++) {
			l *= 2;
			l += current.charAt(i) - '0';
		}
		l++;
		while (Long.toBinaryString(l).length() <= current.length()) {
			String ls = Long.toBinaryString(l);
			while (ls.length() < current.length())
				ls = '0' + ls;
			if (isSpecial(ls))
				return ls;
			l++;
		}
		return "";
	}

	private boolean isSpecial(String ls) {
		for (int i = 1; i < ls.length(); i++)
			if (ls.substring(0, i).compareTo(ls.substring(i)) >= 0)
				return false;
		return true;
	}

}
