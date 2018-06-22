package ch.bubendorf.aoc.util

class NonNullMutableMap<K, V>(private val map: MutableMap<K, V>, private val default:V) : Map<K, V> by map {
    override operator fun get(key: K): V {
        if (map.containsKey(key)) {
            return map[key]!!
        }
        return default
    }

    operator fun set(key: K, value:V) {
        map[key] = value
    }
}
