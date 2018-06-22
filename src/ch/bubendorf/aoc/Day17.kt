package ch.bubendorf.aoc

class Day17(val stepSize: Int, val maxSize: Int) {

    private val buffer = java.util.LinkedList<Int>()

    var currentIndex = 0
        private set

    init {
        buffer.add(0)
    }

    fun valueAt(index:Int):Int {
        return buffer[index]
    }

    private fun next(value:Int) {
        // Damit bei kleinem Buffer nicht sinnlos iteriert wird, nehmen wir als effektive Schrittweite
        // die eigentliche Schrittweite modulo die Buffer Grösse
        val steps = stepSize % buffer.size
        currentIndex += steps + 1
        if (currentIndex > buffer.size) {
            currentIndex -= buffer.size;
        }

        // Jetzt haben wir den neuen currentIndex und können den Wert einfügen
        buffer.add(currentIndex, value)
    }

    fun fill() {
        for (value in 1..maxSize) {
            next(value)
        }
    }

    override fun toString(): String {
        return buffer.toString()
    }
}
