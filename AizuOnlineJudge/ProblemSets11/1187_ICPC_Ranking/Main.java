// ICPC Ranking
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int minutes = sc.nextInt();
			int teams = sc.nextInt();
			int problems = sc.nextInt();
			int records = sc.nextInt();
			if ((minutes | teams | problems | records) == 0)
				break;
			Team[] team = new Team[teams];
			for (int i = 0; i < teams; i++)
				team[i] = new Team(i + 1, problems);
			for (int i = 0; i < records; i++) {
				int m = sc.nextInt();
				int t = sc.nextInt() - 1;
				int p = sc.nextInt() - 1;
				int j = sc.nextInt();
				if (j == 0) {
					team[t].solved++;
					team[t].time += m + team[t].wrong[p] * 20;
				} else
					team[t].wrong[p]++;
			}
			Arrays.sort(team);
			StringBuilder result = new StringBuilder();
			result.append(team[0].id);
			for (int i = 1; i < teams; i++) {
				if (team[i].solved == team[i - 1].solved
						&& team[i].time == team[i - 1].time)
					result.append('=');
				else
					result.append(',');
				result.append(team[i].id);
			}
			System.out.println(result);
		}
		sc.close();
	}

	public static class Team implements Comparable<Team> {
		int id;
		int solved;
		int time;
		int[] wrong;

		Team(int id, int problems) {
			this.id = id;
			solved = 0;
			time = 0;
			wrong = new int[problems];
		}

		@Override
		public int compareTo(Team anotherTeam) {
			if (solved != anotherTeam.solved)
				return anotherTeam.solved - solved;
			else if (time != anotherTeam.time)
				return time - anotherTeam.time;
			return anotherTeam.id - id;
		}
	}
}
