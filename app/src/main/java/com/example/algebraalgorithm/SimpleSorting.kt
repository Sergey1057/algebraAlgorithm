package com.example.algebraalgorithm

import java.util.*
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
            A[i] = random.nextInt(999)
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

    fun quickSort(){
        qsort(0, N-1)
    }

    fun qsort(L: Int, R: Int){
        if (L >= R) return
        var M = split(L,R)
        qsort(L, M-1)
        qsort(M+1, R)
    }

    fun split(L: Int, R: Int): Int{
        var P = A[R]
        var m = L-1
        for (j in L..R){
            if (A[j] <= P)
                swap(++m, j)
        }
            return m
    }

    fun mergeSort(){
        msort(0, N-1)
    }

    fun msort(L: Int, R: Int){
        if ( L >= R) return
        var M = (L + R) / 2
        msort(L, M)
        msort(M + 1, R)
        merge(L, M, R)
    }

    fun bucketSort() {
        var max = A[0]
        for (j in 1 until N) {
            if (max < A[j])
                max = A[j]
        }
            max++
            var bucket = Array<CustomList?>(size = N) { null }
            A.forEach { a ->
                var b = ((a.toLong() * N.toLong()) / max).toInt()
                bucket[b] = CustomList(a, bucket[b])
                var list = bucket[b]
                while (list?.next != null) {
                    if (list.value < list.next?.value!!) {
                        break
                    }
                    var x = list.value
                    list.value = list.next?.value!!
                    list.next?.value = x!!
                    list = list.next
                }
            }
            var j = 0
            bucket.forEach {
                var list = it
                while (list != null) {
                    A[j++] = list!!.value!!
                    list = list!!.next
                }
            }
        }


    class CustomList(var value: Int, var next: CustomList? = null) {
    }

    fun countSort(exp: Int) {
        val output = IntArray(A.size)
        var i: Int
        val count = IntArray(10)
        Arrays.fill(count, 0)

        i = 0
        while (i < A.size) {
            count[A[i] / exp % 10]++
            i++
        }

        i = 1
        while (i < 10) {
            count[i] += count[i - 1]
            i++
        }

        i = A.size - 1
        while (i >= 0) {
            output[count[A[i] / exp % 10] - 1] = A[i]
            count[A[i] / exp % 10]--
            i--
        }


        i = 0
        while (i < A.size) {
            A[i] = output[i]
            i++
        }
    }

    fun radixSort() {
        val m: Int = getMax(A, A.size)

        var exp = 1
        while (m / exp > 0) {
            countSort(exp)
            exp *= 10
        }
    }

    fun getMax(arr: IntArray, n: Int): Int {
        var mx = arr[0]
        for (i in 1 until n) if (arr[i] > mx) mx = arr[i]
        return mx
    }

    fun countingSort() {

        var k = A[0]
        for (i in 1 until A.size) {
            if (A[i] > k) {
                k = A[i]
            }
        }

        val tempArray = IntArray(k + 1)

        for (value in A) {
            ++tempArray[value]
        }

        var b = 0
        for (i in 0 until k + 1) {
            for (j in 0 until tempArray[i]) {
                A[b++] = i
            }
        }
    }

    fun merge(L: Int, M: Int, R: Int){
        var T = IntArray(R - L + 1)
        var a = L
        var b = M +1
        var t = 0
        while (a <= M && b <= R){
            if (A[a] < A[b]){
                T[t++] = A[a++]
            } else {
                T[t++] = A[b++]
            }
        }
        while (a <= M)
            T[t++] = A[a++]
        while (b <= R)
            T[t++] = A[b++]
        for (i in L..R)
            A[i] = T[i - L]
    }

    public fun swap(x: Int, y: Int) {
        val t = A.get(x)
        A[x] = A[y]
        A[y] = t
    }
}