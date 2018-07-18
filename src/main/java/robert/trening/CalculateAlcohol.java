package robert.trening;

public interface CalculateAlcohol {

  void drink(int time, StandardDrink alco);

  int drunkAlcohol(int time);

  boolean canIDrive(int time);

  enum StandardDrink {
    ONEBEERBOTTLE(2), ONEWINEGLASS(2), ONESHOT(1);

    private int standardAlco;

    StandardDrink(int i) {
      this.standardAlco = i;
    }

    public int getStandardAlco() {
      return standardAlco;
    }
  }
}
