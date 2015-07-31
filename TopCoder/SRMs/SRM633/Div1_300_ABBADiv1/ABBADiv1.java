import java.util.HashMap;

public class ABBADiv1 {
	private HashMap<String, Boolean> map = new HashMap<String, Boolean>();

	public String canObtain(String initial, String target) {
		if (isPossible(initial, target))
			return "Possible";
		return "Impossible";
	}

	private boolean isPossible(String initial, String target) {
		if (map.containsKey(target)) {
			return map.get(target);
		}
		if (initial.equals(target)) {
			map.put(target, true);
		} else if (initial.length() >= target.length()) {
			map.put(target, false);
		} else {
			boolean b = false;
			if(target.endsWith("A")){
				b |= isPossible(initial, target.substring(0, target.length()-1));
			}
			if(target.startsWith("B")){
				b |= isPossible(initial, new StringBuilder(target.substring(1)).reverse().toString());
			}
			map.put(target, b);
		}
		return map.get(target);
	}
}
