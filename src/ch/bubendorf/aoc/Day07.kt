package ch.bubendorf.aoc

import java.io.File

class Day07 {

    private var rootProgram:Program? = null
    private var programs = HashMap<String, Program>()

    fun readFile(file:String) {
        val bufferedReader = File(file).bufferedReader()

        bufferedReader.useLines {
            lines -> lines.forEach {
                // zdhvqrl (40) -> fpbsu, fwpfjjd, viqhfi
                val regex = "[a-z]+\\s+[(]\\d+[)]".toRegex()
            val matchResult = regex.matchEntire(it)
            }
        }
    }

    val root: Program
        get() = rootProgram!!

}

class Program(val name:String, val weight:Int) {

    val children:List<Program> = ArrayList()
}
