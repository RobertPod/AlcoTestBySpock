package robert.trening;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class CalculateAlcoholImpl implements CalculateAlcohol {

  private Map<Integer, Integer> timeTable = new TreeMap<>();

  @Override
  public void drink(int time, StandardDrink alco) {
    if (timeTable.get(time) != null) {
      timeTable.replace(time, alco.getStandardAlco()
          + timeTable.get(time));
    } else {
      timeTable.put(time, alco.getStandardAlco());
    }
  }

  @Override
  public int drunkAlcohol(int time) {
    return timeTable.entrySet().stream()
        .filter(x -> x.getKey() <= time)
        .mapToInt(x -> x.getValue())
        .sum();
  }

  @Override
  public boolean canIDrive(int time) {
    if (timeTable.size() == 0) {
      return true;
    }

    return Stream
        .iterate(new int[]{0, timeTable.get(0) == null ? 0
                : timeTable.get(0).intValue()},
            p -> new int[]{p[0] + 1,
                p[1]
                    + (p[1] > 0 ? -1 : 0)
                    + (timeTable.get(p[0] + 1) == null ? 0
                        : timeTable.get(p[0] + 1).intValue())
            })
        .limit((long) time + 1)
        .skip((long) time)
        .findFirst()
        .get()[1] == 0;
  }
}
