package ch.bubendorf.aoc

import org.junit.Test
import java.io.File
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread
import kotlin.test.assertEquals

class Day18Test {

    // Erster Teil
    @Test
    fun test_1() {
        val day18 = Day18(File("test/ch/bubendorf/aoc/Day18Test_ExampleInput.txt").readLines())
        day18.run()

        assertEquals(4, day18.frequency)
    }

    @Test
    fun part1() {
        val day18 = Day18(File("test/ch/bubendorf/aoc/Day18Test_RealInput.txt").readLines())
        day18.run()

        println(day18.frequency)
    }

    // Zweiter Teil
    @Test
    fun part2() {
        val instrctions = File("test/ch/bubendorf/aoc/Day18Test_RealInput.txt").readLines()

        val queue0 = LinkedBlockingQueue<Long>()
        val queue1 = LinkedBlockingQueue<Long>()
        val day18_0 = Day18_2(0, instrctions, queue0, queue1)
        val day18_1 = Day18_2(1, instrctions, queue1, queue0)

        thread {
            day18_0.run()
        }
        thread {
            day18_1.run()
        }

//        println("main")
        // Warten bis beide Threads fertig sind
        while (!day18_0.isBlocked() || !day18_1.isBlocked()) {
            Thread.sleep(10)
        }
        println("Send-Counter von 0: ${day18_0.sendCounter}")
        println("Send-Counter von 1: ${day18_1.sendCounter}")
    }
}
