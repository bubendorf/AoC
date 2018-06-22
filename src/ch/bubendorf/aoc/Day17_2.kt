package ch.bubendorf.aoc

// Variante von Klasse 17
// Anstatt sich alles zu merken wird lediglich der Wert an Position 1 vermerkt
class Day17_2(val stepSize: Int, val maxSize: Int) {

    var pos1Value = 0
        private set

    private var bufferSize = 1

    var currentIndex = 0
        private set

    private fun next(value:Int) {
        // Damit bei kleinem Buffer nicht sinnlos iteriert wird, nehmen wir als effektive Schrittweite
        // die eigentliche Schrittweite modulo die Buffer Grösse
        val steps = stepSize % bufferSize
        currentIndex += steps + 1
        if (currentIndex > bufferSize) {
            currentIndex -= bufferSize;
        }

        // Jetzt haben wir den neuen currentIndex und können den Wert einfügen
        bufferSize++
        if (currentIndex == 1) {
            pos1Value = value;
        }
    }

    fun fill() {
        for (value in 1..maxSize) {
            next(value)
        }
    }

}
