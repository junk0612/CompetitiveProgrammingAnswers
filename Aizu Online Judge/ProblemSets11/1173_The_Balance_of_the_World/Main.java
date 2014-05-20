import java.util.*;

public class The_Ballance_of_the_World {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.nextLine();
			String result = "yes";
			if (str.equals("."))
				break;
			Stack<Character> st = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
				case '(':
					st.push(')');
					break;
				case '[':
					st.push(']');
					break;
				case ')':
					if (st.isEmpty())
						result = "no";
					else if (st.pop() != ')')
						result = "no";
					break;
				case ']':
					if (st.isEmpty())
						result = "no";
					else if (st.pop() != ']')
						result = "no";
					break;
				default:
					break;
				}
			}
			if (!st.isEmpty())
				result = "no";
			System.out.println(result);
		}
		sc.close();
	}
}