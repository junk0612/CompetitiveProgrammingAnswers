import java.util.ArrayList

class RedandBlack {
	def static void main(String[] args) {
		var sc = new java.util.Scanner(System.in)
		while (solveQ(sc)) {
		}
	}

	def static solveQ(java.util.Scanner sc) {
		var w = sc.nextInt
		var h = sc.nextInt
		if (w == 0 && h == 0)
			return false
		var field = new ArrayList<ArrayList<Boolean>>(0)
		var i = 0
		var x = 0
		var y = 0
		while (i < h) {
			var list = new ArrayList<Boolean>
			var j = 0
			var str = sc.next
			while (j < w) {
				switch (str.substring(j,j+1)) {
					case '@': {
						x = j
						y = i
						list.add(true)
					}
					case '.':
						list.add(true)
					case '#':
						list.add(false)
				}
				j = j + 1
			}
			field.add(list)
			i = i + 1
		}
		var result = count(field, x, y)
		println(result)
		true
	}

	def static int count(ArrayList<ArrayList<Boolean>> field, int x, int y) {
		var result = 1
		field.get(y).set(x, false)
		if (y > 0 && field.get(y - 1).get(x) == true)
			result = result + count(field, x, y - 1)
		if (x > 0 && field.get(y).get(x - 1) == true)
			result = result + count(field, x - 1, y)
		if (y < field.size - 1 && field.get(y + 1).get(x) == true)
			result = result + count(field, x, y + 1)
		if (x < field.get(y).size - 1 && field.get(y).get(x + 1) == true)
			result = result + count(field, x + 1, y)
		result
	}
}
