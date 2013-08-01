import java.util.Scanner
import java.util.ArrayList

class ICPCScoreTotalizerSoftware {
	def static void main(String[] args) {
		var sc = new Scanner(System.in)
		while (solveQ(sc)) {
		}
	}

	def static boolean solveQ(Scanner sc) {
		var n = sc.nextInt()
		if (n == 0) {
			return false
		}
		var list = new ArrayList<Integer>()
		var i = 0
		while (i < n) {
			list.add(sc.nextInt())
			i = i + 1
		}
		i = 0
		var max = list.get(0)
		var min = list.get(0)
		var sum = 0
		while (i < n) {
			sum = sum + list.get(i)
			max = Math.max(max, list.get(i))
			min = Math.min(min, list.get(i))
			i = i + 1
		}
		sum = sum - max - min
		n = i - 2
		var ave = sum / n
		println(ave)
		return true
	}
}
