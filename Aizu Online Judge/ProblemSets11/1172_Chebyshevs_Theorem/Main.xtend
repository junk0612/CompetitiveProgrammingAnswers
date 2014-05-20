import java.util.ArrayList
import java.util.Scanner

class ChebyshevsTheorem {
	def static void main(String[] args) {
		var sc = new Scanner(System.in)
		var prime = new ArrayList<Boolean>(0)
		var i = 0
		while (i <= 123456 * 2) {
			prime.add(true)
			i = i + 1
		}
		prime.set(0, false)
		prime.set(1, false)
		i = 2
		while (i < Math.sqrt(123456 * 2)) {
			if (prime.get(i)) {
				var j = i * i
				while (j <= 123456 * 2) {
					prime.set(j, false)
					j = j + i
				}
			}
			i = i + 1
		}
		while (solveQ(sc, prime)) {
		}
	}

	def static boolean solveQ(Scanner sc, ArrayList<Boolean> prime) {
		var n = sc.nextInt
		if(n == 0) return false
		var count = 0
		var i = n + 1
		while (i <= 2 * n) {
			if (prime.get(i))
				count = count + 1
			i = i + 1
		}
		println(count)
		true
	}
}
