package robert.trening

import spock.lang.Specification

import static robert.trening.CalculateAlcohol.StandardDrink.ONEWINEGLASS

class CalculateAlcoholImplTest extends Specification {

    def "drunkAlcoholTest"() {
        setup:
        def calculateAlcohol = new CalculateAlcoholImpl()

        when:
        calculateAlcohol.drink(6, ONEWINEGLASS)

        def drunkStandardDrink = calculateAlcohol.drunkAlcohol(7)

        then:
        drunkStandardDrink == 2
    }

    def "canIDriveTest"() {
        setup:
        def calculateAlcohol = new CalculateAlcoholImpl()

        when:
        calculateAlcohol.drink(6, ONEWINEGLASS)

        def canIDrive = calculateAlcohol.canIDrive(7)

        then:
        canIDrive == false
    }

    def "calculateAlcoholImplTestBoundaryConditions"() {
        setup:
        def calculateAlcohol = new CalculateAlcoholImpl()

        when:
        def drunkStandardDrink = calculateAlcohol.drunkAlcohol(1)
        def canIDrive = calculateAlcohol.canIDrive(2)

        then:
        drunkStandardDrink == 0
        canIDrive == true
    }
}
