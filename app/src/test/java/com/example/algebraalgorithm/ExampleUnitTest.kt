package com.example.algebraalgorithm

import com.example.algebraalgorithm.graph.Kosaraju
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testKosaraju() {
        val graph = arrayOf(
            intArrayOf(1),
            intArrayOf(2, 4, 5),
            intArrayOf(3, 6),
            intArrayOf(2, 7),
            intArrayOf(0, 5),
            intArrayOf(6),
            intArrayOf(5),
            intArrayOf(3, 6)
        )
        val result = arrayOf(intArrayOf(6, 5), intArrayOf(2, 7, 3), intArrayOf(1, 0, 4))
        assertArrayEquals(result, Kosaraju.kosaraju(graph))
    }
}