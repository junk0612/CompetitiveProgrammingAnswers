import java.util.*;

public class Osaki {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			Train[] trains = new Train[n];
			for (int i = 0; i < n; i++) {
				String depstr = sc.next();
				String[] depstrs = depstr.split(":");
				int dep = Integer.parseInt(depstrs[0]) * 3600
						+ Integer.parseInt(depstrs[1]) * 60
						+ Integer.parseInt(depstrs[2]);
				String arrstr = sc.next();
				String[] arrstrs = arrstr.split(":");
				int arr = Integer.parseInt(arrstrs[0]) * 3600
						+ Integer.parseInt(arrstrs[1]) * 60
						+ Integer.parseInt(arrstrs[2]);
				trains[i] = new Train(dep, arr);
			}
			int maxtrain = 0;
			int nowtrain = 0;
			for (int i = 0; i < 24*60*60; i++) {
				for(int j=0;j<n;j++){
					if(i==trains[j].dep)
						nowtrain++;
					if(i==trains[j].arr)
						nowtrain--;
				}
				maxtrain = Math.max(maxtrain, nowtrain);
			}
			System.out.println(maxtrain);
		}
		sc.close();
	}
}

class Train {
	int dep;
	int arr;

	Train(int d, int a) {
		dep = d;
		arr = a;
	}
}