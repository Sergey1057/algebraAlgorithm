package com.example.algebraalgorithm

import com.example.algebraalgorithm.graph.Deikstra
import com.example.algebraalgorithm.graph.Edge
import com.example.algebraalgorithm.graph.Kosaraju
import com.example.algebraalgorithm.graph.Kraskal
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

    val graph = arrayOf(
        intArrayOf(0, 11, 0, 0, 0, 0, 0, 13, 12),
        intArrayOf(11, 0, 17, 0, 0, 0, 0, 0, 10),
        intArrayOf(0, 17, 0, 4, 0, 0, 0, 0, 5),
        intArrayOf(0, 0, 4, 0, 3, 0, 0, 0, 2),
        intArrayOf(0, 0, 0, 3, 0, 7, 8, 0, 6),
        intArrayOf(0, 0, 0, 0, 7, 0, 16, 14, 0),
        intArrayOf(0, 0, 0, 0, 8, 16, 0, 15, 1),
        intArrayOf(13, 0, 0, 0, 0, 14, 15, 0, 9),
        intArrayOf(12, 10, 5, 2, 6, 0, 1, 9, 0)
    )

    val result = arrayOf(
        Edge(8, 6, 1),
        Edge(8, 3, 2),
        Edge(3, 4, 3),
        Edge(2, 3, 4),
        Edge(4, 5, 7),
        Edge(8, 7, 9),
        Edge(1, 8, 10),
        Edge(0, 1, 11)
    )
        @Test
        fun findMST() {
            assertArrayEquals(result, Kraskal.find(graph))
        }


     val graphDeikstra = arrayOf(
        arrayOf(0, 2, 3, 6, null, null, null),
        arrayOf(2, 0, 4, null, 9, null, null),
        arrayOf(3, 4, 0, 1, 7, 6, null),
        arrayOf(6, null, 1, 0, null, 4, null),
        arrayOf(null, 9, 7, null, 0, 1, 5),
        arrayOf(null, null, 6, 4, 1, 0, 8),
        arrayOf(null, null, null, null, 5, 8, 0)
    )
         var algorithm: Deikstra = Deikstra(graphDeikstra, 0)


    val resultDeikstra = arrayOf(
        Edge(0, 2, 3),
        Edge(2, 3, 1),
        Edge(3, 5, 4),
        Edge(5, 4, 1),
        Edge(4, 6, 5)
    )

        @Test
        fun deikstraTest() {
                assertArrayEquals(
                    resultDeikstra, algorithm.getPath(6)
                )
            }
    }
