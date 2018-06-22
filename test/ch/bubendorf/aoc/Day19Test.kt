package ch.bubendorf.aoc

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Day19Test {

    // Erster Teil
    @Test
    fun test_1() {
        val day19 = Day19(File("test/ch/bubendorf/aoc/Day19Test_ExampleInput.txt").readLines())
        val text = day19.run()

        assertEquals("ABCDEF", text)
        assertEquals(38, day19.count)
    }

    @Test
    fun test_run() {
        val day19 = Day19(File("test/ch/bubendorf/aoc/Day19Test_RealInput.txt").readLines())
        val text = day19.run()

        println(text)
        println(day19.count)
    }
}
