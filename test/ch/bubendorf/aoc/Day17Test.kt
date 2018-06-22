package ch.bubendorf.aoc

import org.junit.Test
import kotlin.test.assertEquals

class Day17Test {

    // Erster Teil
    @Test
    fun test_1() {
        val day17 = Day17(3, 1)
        day17.fill()
        println(day17)
        assertEquals("[0, 1]", day17.toString())
    }

    @Test
    fun test_2() {
        val day17 = Day17(3, 2)
        day17.fill()
        println(day17)
        assertEquals("[0, 2, 1]", day17.toString())
    }

    @Test
    fun test_9() {
        val day17 = Day17(3, 9)
        day17.fill()
        println(day17)
        assertEquals("[0, 9, 5, 7, 2, 4, 3, 8, 6, 1]", day17.toString())
        assertEquals(1, day17.currentIndex)
    }

    @Test
    fun test_nextVal() {
        val day17 = Day17(3, 2017)
        day17.fill()
        assertEquals(638, day17.valueAt(day17.currentIndex + 1))
    }

    @Test
    fun doitPart1() {
        val day17 = Day17(366, 2017)
        day17.fill()
        println("Wert=${day17.valueAt(day17.currentIndex + 1)}")
    }


    // Zweiter Teil
    @Test
    fun test2_2() {
        val day17 = Day17_2(3, 2)
        day17.fill()
        assertEquals(1, day17.currentIndex)
        assertEquals(2, day17.pos1Value)
    }

    @Test
    fun test2_9() {
        val day17 = Day17_2(3, 9)
        day17.fill()
        assertEquals(1, day17.currentIndex)
        assertEquals(9, day17.pos1Value)
    }

    @Test
    fun doitPart2() {
        val day17 = Day17_2(366, 50000000)
        day17.fill()
        println("Wert=${day17.pos1Value}")
    }
}
