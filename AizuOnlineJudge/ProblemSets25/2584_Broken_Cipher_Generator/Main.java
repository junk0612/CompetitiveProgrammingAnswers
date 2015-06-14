import java.util.Scanner;

public class Main {
	static String cipher;
	static int pos;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			cipher = sc.nextLine();
			String tc = cipher;
			if (cipher.equals("."))
				break;
			pos = 0;
			System.out.println(cipher());
		}
		sc.close();
	}
	
	static String cipher(){
		StringBuilder sb = new StringBuilder(string());
		while(pos < cipher.length()){
			sb.append(string());
		}
		return sb.toString().replace('?', 'A');
	}
	
	static String string(){
		char c = cipher.charAt(pos);
		if(c == '['){
			pos++;
			StringBuilder sb = new StringBuilder(string());
			while(cipher.charAt(pos) != ']'){
				sb.append(string());
			}
			pos++;
			return sb.reverse().toString();
		}
		return Character.toString(letter());
	}
	
	static char letter(){
		char c = cipher.charAt(pos++);
		if(c == '+'){
			char let = letter();
			if(let == '?'){
				return let;
			}
			let++;
			if(let > 'Z'){
				let -= 26;
			}
			return let;
		} else if (c == '-'){
			char let = letter();
			if(let == '?'){
				return let;
			}
			let--;
			if(let < 'A'){
				let += 26;
			}
			return let;
		}
		return c;
	}

}
