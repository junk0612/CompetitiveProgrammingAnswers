public class TaroJiroGrid {

	public int getNumber(String[] grid) {
		if (check(grid))
			return 0;
		for (int i = 0; i < grid.length; i++)
			if (change(grid, i))
				return 1;
		return 2;
	}

	private boolean check(String[] grid) {
		for (int i = 0; i < grid.length; i++) {
			int count = 1;
			for (int j = 1; j < grid.length; j++) {
				if (grid[j].charAt(i) == grid[j - 1].charAt(i)) {
					count++;
					if (count > grid.length / 2)
						return false;
					continue;
				}
				count = 1;
			}
		}
		return true;
	}

	private boolean change(String[] grid, int index) {
		String str = grid[index];
		grid[index] = grid[index].replace('W', 'B');
		if (check(grid))
			return true;
		grid[index] = grid[index].replace('B', 'W');
		if (check(grid))
			return true;
		grid[index] = str;
		return false;
	}

}
