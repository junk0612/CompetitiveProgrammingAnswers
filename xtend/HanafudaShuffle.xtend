class HanafudaShuffle {
	def static void main(String[] args) {
		var sc = new java.util.Scanner(System.in)
		while (solveQ(sc)) {
		}
	}

	def static solveQ(java.util.Scanner sc) {
		var n = sc.nextInt
		var r = sc.nextInt
		if (n == 0 && r == 0)
			return false
		var deck = new java.util.ArrayList<Integer>(0)
		var i = 1
		while (i <= n) {
			deck.add(i)
			i = i + 1
		}
		i = 0
		while (i < r) {
			var p = sc.nextInt
			var c = sc.nextInt
			var j = 0
			while (j < c) {
				deck.add(deck.get(n - p - c + 1))
				deck.remove(n - p - c + 1)
				j = j + 1
			}
			i = i + 1
		}
		println(deck.get(n - 1))
		true
	}
}
