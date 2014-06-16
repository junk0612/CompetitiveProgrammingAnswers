public class GameOfSegments {

	public int winner(int N) {
		if (game(N) % 2 == 1)
			return 1;
		return 2;
	}

	int game(int N) {
		if (N <= 1)
			return 0;
		if (N % 2 == 1)
			return game((N - 2) / 2 + 1) + game((N - 2) / 2) + 1;
		return game((N - 2) / 2) * 2 + 1;
	}

}
