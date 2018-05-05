package ch.bubendorf.aoc

import org.junit.Test
import kotlin.test.assertEquals

class Day06Test {

    @Test
    fun test() {
        val day06Test = Day06(intArrayOf(0, 2, 7, 0))
        day06Test.distribute()
        assertEquals(5, day06Test.iterations)
        assertEquals(4, day06Test.loopsize)

        val day06 = Day06(intArrayOf(5,	1,	10,	0,	1,	7,	13,	14,	3,	12,	8,	10,	7,	12,	0,	6))
        day06.distribute()
        println(day06.iterations)
        println(day06.loopsize)
    }

}
