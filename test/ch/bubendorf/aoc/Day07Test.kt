package ch.bubendorf.aoc

import org.junit.Test
import kotlin.test.assertEquals

class Day07Test {

    @Test
    fun test() {
        val day07Test = Day07()
        day07Test.readFile("day07test.txt")
        assertEquals("tknk", day07Test.root.name)

        val day07 = Day07()
        day07.readFile("day07.txt")
        println("Name des Root Programmes: ${day07.root.name}")

    }

}
