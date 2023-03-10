package com.example.algebraalgorithm

import kotlin.random.Random

class SimpleSorting {

    lateinit var A: IntArray
    public var N: Int = 0
        get() = field

    private fun initArray(n: Int) {
        N = n
        A = IntArray(n)
    }

    fun setRandom(n: Int) {
        initArray(n)
        val random = Random(12345)
        for (i in 0 until n) {
            A[i] = random.nextInt(n)
        }
    }

    fun bubble() {
        for (j in (N - 1) downTo 0) {
            for (i in 0 until j) {
                if (A[i] > A[i + 1]) {
                    swap(i, i + 1)
                }
            }
        }
    }

    fun insertion() {
        for (j in 0 until N) {
            for (i in j - 1 downTo 0) {
                if (A[i] > A[i + 1]) {
                    swap(i, i + 1)
                }
            }
        }
    }

    fun selectionSort(){
        for (j in A.size - 1 downTo 0){
            swap(findMax(j), j)
        }
    }

    fun findMax(j:Int): Int{
        var max = 0
        for (i in 0..j){
            if (A[i] > A[max]){
                max = i
            }
        }
        return max
    }

    fun heapSort(){
        for (h in N/2 downTo 0){
            heapify(h, N)
        }
        for (j in N-1 downTo 0){
            swap(0,j)
            heapify(0,j)
        }
    }

    fun heapify(root:Int, size: Int){
        var X = root
        var L = 2 * X +1
        var R = 2 * X +2
        if (L < size && A[L] > A[X]){
            X = L
        }
        if (R < size && A[R] > A[X]) {
            X = R
        }
        if (X == root) return
        swap(root, X)
        heapify(X, size)
    }

    fun shell() {
        var gap2 = N / 2
        for (gap in N / 2 downTo 0 step gap2 / 2) {
            gap2 = gap
            for (i in gap..N) {
                var j2 = i - gap
                for (j in i downTo gap step j2 - gap) {
                    j2 = j
                    if (A[j - gap] > A[j]) {
                        swap(i - gap, j)
                    }
                }
            }
        }
    }

    public fun swap(x: Int, y: Int) {
        val t = A.get(x)
        A[x] = A[y]
        A[y] = t
    }
}