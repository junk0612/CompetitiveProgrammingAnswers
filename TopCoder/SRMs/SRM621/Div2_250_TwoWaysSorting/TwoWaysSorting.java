public class TwoWaysSorting {

	public String sortingMethod(String[] stringList) {
		boolean length = true, lexicographically = true;
		for (int i = 1; i < stringList.length; i++) {
			length = length
					&& (stringList[i - 1].length() < stringList[i].length());
			lexicographically = lexicographically
					&& (stringList[i - 1].compareTo(stringList[i]) < 0);
		}
		if (length && lexicographically)
			return "both";
		if (length)
			return "lengths";
		if (lexicographically)
			return "lexicographically";
		return "none";
	}

}
