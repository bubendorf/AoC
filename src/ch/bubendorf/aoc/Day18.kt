package ch.bubendorf.aoc

import ch.bubendorf.aoc.util.NonNullMutableMap

class Day18(val instructions: List<String>) {

    var frequency = 0L
    var instructionPointer = 0
    private val registers = NonNullMutableMap(HashMap<String, Long>(), 0)

    fun run() {
        while (instructionPointer >= 0 && instructionPointer < instructions.size) {
            val instruction = instructions[instructionPointer]
            println("IP=$instructionPointer ==> $instruction")
            val split = instruction.split(" ")
            when (split[0]) {
                "set" -> set(split[1], split[2])
                "add" -> add(split[1], split[2])
                "mul" -> mul(split[1], split[2])
                "mod" -> mod(split[1], split[2])
                "snd" -> snd(split[1])
                "rcv" -> rcv(split[1])
                "jgz" -> jgz(split[1], split[2])
            }
            instructionPointer++
        }
    }

    private fun value(arg:String) : Long {
        // arg is either a number or a register name
        val longOrNull = arg.toLongOrNull()
        if (longOrNull != null) {
            return longOrNull
        }
        return registers[arg]
    }

    private fun set(arg1:String, arg2:String) {
        registers[arg1] = value(arg2)
    }

    private fun add(arg1:String, arg2:String) {
        registers[arg1] = registers[arg1] + value(arg2)
    }

    private fun mul(arg1:String, arg2:String) {
        registers[arg1] = registers[arg1] * value(arg2)
    }

    private fun mod(arg1:String, arg2:String) {
        registers[arg1] = registers[arg1] % value(arg2)
    }

    private fun snd(arg1:String) {
        frequency = value(arg1)
    }

    private fun rcv(arg1:String) {
        if (value(arg1) != 0L) {
            instructionPointer = instructions.size
        }
    }

    private fun jgz(arg1:String, arg2:String) {
        if (value(arg1) > 0) {
            instructionPointer = instructionPointer + value(arg2).toInt() - 1
        }
    }

    override fun toString(): String {
        return registers.toString()
    }
}
