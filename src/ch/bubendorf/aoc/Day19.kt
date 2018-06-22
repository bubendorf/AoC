package ch.bubendorf.aoc

class Day19(val maze: List<String>) {

    private var x = maze[0].indexOf("|")
    private var y = 0
    private var xDirection = 0
    private var yDirection = 1
    var count = 0

    fun run() : String {
        val  result = StringBuilder()


        while (charAt(x, y) != ' ') {
            count++
            val c = charAt(x, y)
            println ("x=$x, y=$y, c=$c")
            when (c) {
                '|' -> {
                    // Kein Richtungswechsel ==> Nix unternehmen
                }
                '-' -> {
                    // Kein Richtungswechsel ==> Nix unternehmen
                }
                '+' -> {
                    // Richtungswechsel
                    richtungsWechsel()
                }
                else -> {
                    // Ein Zeichen und möglicher(!) Richtungswechsel!
                    result.append(c)
                    if (charAt(x + xDirection, y+yDirection) == ' ') {
                        richtungsWechsel()
                    }
                }
            }
            // Nächste Position
            x += xDirection
            y += yDirection
        }

        return result.toString()
    }

    private fun richtungsWechsel() {
        if (xDirection == 0) {
            // Wechsel von Vertikal nach Horizontal
            xDirection = if (charAt(x + 1, y) != ' ') 1 else -1
            yDirection = 0
        } else {
            // Wechsel von Horizontal nach Vertikal
            xDirection = 0
            yDirection = if (charAt(x, y + 1) != ' ') 1 else -1
        }
    }

    private fun charAt(x:Int, y:Int ) : Char{
        return if (y < maze.size && x < maze[y].length) maze[y][x] else ' '
    }
}
