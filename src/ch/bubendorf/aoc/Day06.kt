package ch.bubendorf.aoc

import java.util.*

class Day06(private val banks : IntArray) {

    // Die History der Speicherbänke zusammen mit dem Loop Index wann der Eintrag geschrieben wurde
    private val history:MutableMap<IntArray, Int> = TreeMap({first : IntArray, second: IntArray -> first.compareTo(second)})

    val iterations: Int
        get() = history.size

    val loopsize: Int
        get() = if (history.contains(banks)) history.size - history[banks]!! else 0

    fun distribute() {
        while (!history.contains(banks)) {
            // Weil wir die Speicherbänke ständig modifizieren, speichern wir hier eine Kopie in der History
            history.put(banks.clone(), history.size)

            // Maximalwert suchen und die Speicherblocks verteilen
            val indexOfMax = banks.indexOfMax()
            banks.spread(indexOfMax)
        }
    }

    /**
     * Verteilt die Werte.
     */
    fun IntArray.spread(indexOfMax:Int) {
        var numberOfBlocksToSpread = this[indexOfMax]
        this[indexOfMax] = 0
        var index = indexOfMax
        while (numberOfBlocksToSpread > 0) {
            index = (index + 1) % this.size
            this[index]++
            numberOfBlocksToSpread--
        }
    }

    /**
     * Findet den Index der grössten Zahl im IntArray.
     * Wenn es mehrer Einträge mit der grössten Zahl gibt, wird der zuerst
     * gefundene zurück gegeben.
     */
    fun IntArray.indexOfMax(): Int {
        var maxIndex = 0
        for(elem in this.indices){
            if (this[elem] > this[maxIndex]){
                maxIndex = elem;
            }
        }
        return maxIndex
    }

    fun IntArray.compareTo(other: IntArray) : Int {
        if (this.size != other.size){
            return this.size - other.size
        }
        for (index in this.indices) {
            if (this[index] != other[index]) {
                return this[index] - other[index]
            }
        }
        return 0
    }
}
