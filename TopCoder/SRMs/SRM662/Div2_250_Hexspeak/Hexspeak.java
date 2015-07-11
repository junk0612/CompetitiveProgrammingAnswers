public class Hexspeak {

	public String decode(long ciphertext) {
		StringBuilder ret = new StringBuilder();
		while (ciphertext > 0) {
			int d = (int) (ciphertext % 16);
			if (d > 1 && d < 10) {
				return "Error!";
			}
			switch (d) {
			case 0:
				ret.append("O");
				break;
			case 1:
				ret.append("I");
				break;
			case 10:
				ret.append("A");
				break;
			case 11:
				ret.append("B");
				break;
			case 12:
				ret.append("C");
				break;
			case 13:
				ret.append("D");
				break;
			case 14:
				ret.append("E");
				break;
			case 15:
				ret.append("F");
				break;
			}
			ciphertext /= 16;
		}
		return ret.reverse().toString();
	}

}
