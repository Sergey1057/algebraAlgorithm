package com.example.algebraalgorithm

fun main() {
    val simpleSorting = SimpleSorting()
    val N = 300000
    simpleSorting.setRandom(N)
    val start = System.currentTimeMillis()
    simpleSorting.heapSort()
    val ms = System.currentTimeMillis() - start
    println("result  =  $ms")
}

fun stepen(number: Long, step: Int): Long{
    var numberM = number
    for (i in 1 until step){
        numberM *= number
    }
    return numberM
}

fun fibonacci(n: Long): Long {
    if (n == 0L) {
        return 0L
    }
    return if (n == 1L) {
        1L
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}

var a = 1L
var b = 1L
var f = 0L

fun fibonacciLinear(n: Long): Long {
    if (n == 1L || n == 2L){
        return a
    }

    for (i in 3..n) {
         f = a+b

        a = b
        b = f
    }
    return f
}

fun calculatePrime(n:Int):Int{
    var count = 0
    for (number in 1..n){
        if (isPrime(number)){
            count++
        }
    }
        return count
}

fun isPrime(value: Int): Boolean{
    if (value == 1){
        return false
    }
    if (value == 2){
        return true
    }
    if (value % 2 == 0){
        return false
    }
    for (number in 3 until value step 2 ){
        if (value % number == 0){
            return false
        }
    }
    return true
}