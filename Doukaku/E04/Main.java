import java.util.Set;
import java.util.HashSet;

public class Main {
  public String solve(String input) {
    StringBuilder builder = new StringBuilder();
    Set<Integer> stonePath = getStonePath(input);
    for (int i = 0; i < 8; i++) {
      Set<Integer> manPath = getManPath(input, (char)(i + 'A'));
      if (!manPath.removeAll(stonePath)) {
        builder.append((char)('A' + i));
      }
    }
    if (stonePath.isEmpty()) {
      builder.deleteCharAt(builder.indexOf(input.substring(input.length() - 1)));
    }
    return builder.toString();
  }

  private Set<Integer> getManPath(String input, char position) {
    String[] inputs = input.split(":");
    String paths = inputs[0];
    Set<Integer> manPath = new HashSet<>();
    for (int i = paths.length() - 1; i >= 0; i--) {
      char path = paths.charAt(i);
      if (isClockwise(path, position)) {
        manPath.add(i);
        position = moveClockwise(position);
      } else if (isCounterclockwise(path, position)) {
        manPath.add(i);
        position = moveCounterclockwise(position);
      }
    }
    return manPath;
  }

  private Set<Integer> getStonePath(String input) {
    String[] inputs = input.split(":");
    String paths = inputs[0];
    Set<Integer> stonePath = new HashSet<>();
    char position = inputs[1].charAt(0);
    for (int i = 0; i < paths.length(); i++) {
      char path = paths.charAt(i);
      if (isClockwise(path, position)) {
        stonePath.add(i);
        position = moveClockwise(position);
      } else if (isCounterclockwise(path, position)) {
        stonePath.add(i);
        position = moveCounterclockwise(position);
      }
    }
    return stonePath;
  }

  private boolean isClockwise(char path, char position) {
    return (path - '0') % 8 == (position - 'A') % 8;
  }

  private boolean isCounterclockwise(char path, char position) {
    return path - '1' == position - 'A';
  }

  private char moveClockwise(char position) {
    return --position < 'A' ? 'H' : position;
  }

  private char moveCounterclockwise(char position) {
    return ++position > 'H' ? 'A' : position;
  }
}
