import java.util.Scanner

class EarthInvasionDiaryofMiyabisensei {
	def static void main(String[] args) {
		var sc = new Scanner(System.in)
		var n = sc.nextInt
		println(count(n))
	}

	def static int count(int n) {
		var result = 0
		if(n < 4) return 1
		if(n % 3 == 0) result = count(n / 3) + 1 else result = count(n / 3 + 1) + 1
		result
	}
}
