package robert.trening

import spock.lang.Specification
import spock.lang.Unroll

import static robert.trening.CalculateAlcohol.StandardDrink.ONEBEERBOTTLE
import static robert.trening.CalculateAlcohol.StandardDrink.ONESHOT
import static robert.trening.CalculateAlcohol.StandardDrink.ONEWINEGLASS

class CanIDriveTest extends Specification {
    @Unroll
    def "canIDriveTest"() {
        setup:
        def calculateAlcohol = new CalculateAlcoholImpl()

        // drinking chart:
        // beer + 100g vodka + wine
        //        4            |\  |\
        //        3            |  \|  \
        //        2       | \  |        \
        //        1   _ _ |   \|          \
        //        0   0 1 2 3 4 5 6 7 8 9 0
        calculateAlcohol.drink(6, ONEWINEGLASS)
        calculateAlcohol.drink(4, ONESHOT)
        calculateAlcohol.drink(4, ONESHOT)
        calculateAlcohol.drink(2, ONEBEERBOTTLE)
        calculateAlcohol.drink(4, ONESHOT)
        calculateAlcohol.drink(4, ONESHOT)

        expect:
        calculateAlcohol.canIDrive(time) == driveOrNot

        where:
        time | driveOrNot
        0    | true
        1    | true
        2    | false
        3    | false
        4    | false
        5    | false
        6    | false
        7    | false
        8    | false
        9    | false
        10   | true
        11   | false  // For error visualization
    }
}
