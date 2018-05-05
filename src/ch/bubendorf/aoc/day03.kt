package ch.bubendorf.aoc

import kotlin.math.abs

fun main(args : Array<String>) {
    part1()
    part2()
}

fun part1() {
    for (input in listOf(/*1,12,23, 1024, */325489)) {
        val distanz = calc(input);
        println("Input=$input, Distanz=$distanz")
    }
}

fun calc(input: Int) : Int {
    val x = Math.floor((3 + Math.sqrt(input - 1.0)) / 2).toInt()

    val position = input - 4*x*x +12*x -9
    val edgeLength = 2 * x - 1
    val segment = (position + position * edgeLength) / edgeLength / edgeLength
    val offset = (position + segment) % edgeLength

    val y = Math.abs(x -offset-1)

    return x + y - 1
}

fun part2() {
    val spiralIterator = SpiralIterator()
    /*for (i in 0..50) {
        val pair = spiralIterator.next()
        println("i:$i, x:${pair.first}, y:${pair.second}")
    }*/
    val grid = HashMap<Pair<Int,Int>, Int>()
    grid[Pair(0,0)] = 1
    var value = 0
    while (value < 325489) {
        val pair = spiralIterator.next()
        value = neighborsSum(grid, pair)
        grid[pair] = value
    }
    println("value: $value")

}

fun neighborsSum(grid: HashMap<Pair<Int, Int>, Int>, pair: Pair<Int, Int>): Int {
    val x = pair.first
    val y = pair.second
    return (grid.getOrDefault(Pair(x - 1, y- 1), 0)
    + grid.getOrDefault(Pair(x - 1, y), 0)
    + grid.getOrDefault(Pair(x - 1, y + 1), 0)
    + grid.getOrDefault(Pair(x, y - 1), 0)
    + grid.getOrDefault(Pair(x, y + 1), 0)
    + grid.getOrDefault(Pair(x + 1, y - 1), 0)
    + grid.getOrDefault(Pair(x + 1, y), 0)
    + grid.getOrDefault(Pair(x + 1, y + 1), 0))
}

// https://stackoverflow.com/questions/398299/looping-in-a-spiral
class SpiralIterator {
    private var x = 0
    private var y = 0

    fun next() : Pair<Int,Int> {
        if (abs(x) <= abs(y) && (x != y || x >= 0)) {
            x += (if (y >= 0) 1 else -1)
        }        else {
            y += if (x >= 0) -1 else 1
        }
        return Pair(x, -y)
    }
}

/*
fun calc(input: Int) : Int {
    val x = Math.floor((3 + Math.sqrt(input - 1.0)) / 2).toInt()

    val posUntenRechts = 4 * (x-1) * (x -2) + 2
    val position = input - posUntenRechts +1
    val edgeLength = 2 * x - 1
    val segment = (position + position * edgeLength) / edgeLength / edgeLength
    val offset = (position + segment) % edgeLength

    val y = Math.abs(x -offset-1)

    return x + y - 1
}
 */
