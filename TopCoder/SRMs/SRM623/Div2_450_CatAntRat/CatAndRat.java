public class CatAndRat {

	final double PI = 3.14159265358979;

	public double getTime(int R, int T, int Vrat, int Vcat) {
		if (Vrat >= Vcat)
			return -1.0;
		double len = Math.min(Vrat * T, R * PI);
		return len / (Vcat - Vrat);
	}

}
