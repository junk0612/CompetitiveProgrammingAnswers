public class UniformBoard {

	public int getBoard(String[] board, int K) {
		int N = board.length;
		char[][] field = new char[N][N];
		int dots = 0;
		int apples = 0;
		for (int i = 0; i < N; i++) {
			field[i] = board[i].toCharArray();
			for (int j = 0; j < N; j++) {
				if (field[i][j] == '.')
					dots++;
				if (field[i][j] == 'A')
					apples++;
			}
		}
		if(dots == 0)
			K=0;
		int result = 0;
		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++) {
				for (int w = 1; w <= N - x; w++)
					for (int h = 1; h <= N - y; h++) {
						if (w * h > apples)
							break;
						int insidePears = 0;
						int insideDots = 0;
						for (int i = x; i < x + w; i++)
							for (int j = y; j < y + h; j++) {
								if (field[i][j] == '.')
									insideDots++;
								if (field[i][j] == 'P')
									insidePears++;
							}
						if (K >= insidePears * 2 + insideDots)
							result = Math.max(result, w * h);
					}
			}
		return result;
	}
}
