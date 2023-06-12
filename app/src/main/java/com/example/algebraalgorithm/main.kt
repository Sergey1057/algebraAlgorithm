package com.example.algebraalgorithm

import com.example.algebraalgorithm.hash_table.HashTableStorage
import com.example.algebraalgorithm.hash_table.IStorage
import com.example.algebraalgorithm.randomTree.RNode
import com.example.algebraalgorithm.randomTree.RTree
import kotlin.random.Random

fun main() {
//    val simpleSorting = SimpleSorting()
//    val N = 100000
//    simpleSorting.setRandom(N)
//    val start = System.currentTimeMillis()
//    simpleSorting.countingSort()
//    val ms = System.currentTimeMillis() - start
//    println("result  =  $ms")

//    val single = SingleArray<Int>()
//    val vector = VectorArray<Int>()
//    val factor = FactorArray<Int>()
//    val arrayListFasade = ArrayListFasade<Int>()
//
//    SingleArray.testPut(single, 1000000)
//    SingleArray.testPut(vector, 1000000)
//    SingleArray.testPut(factor, 1000000)
//    SingleArray.testPut(arrayListFasade, 1000000)

//    val chess = chess()
//    // задача про короля
//    println(chess.popcnt2(chess.getKingMoves(7)))
//    println(chess.getKingMoves(7))
//
//    // задача про коня
//    println(chess.popcnt2(chess.getKnightMoves(27)))
//    println(chess.getKnightMoves(27))


//    val tree = BSTTree()
//
//    val n = 100000
//    val start = System.currentTimeMillis()
//
//    for (i in 0..n){
//        var j = getRandom()
//        tree.insertNode(j)
//    }

//    for (i in 0..n){
//        tree.insertNode(i)
//    }

//    for (i in 0..n/10){
//        var j = getRandom()
//        tree.search(j)
//        tree.remove(j)
//    }
//   val ms = System.currentTimeMillis() - start
//   println("result  =  $ms")


    //runMapExample(HashTableStorage())
    runRTree()

}

fun runRTree(){
    val tree = RTree()
    val node = RNode(0)

    val n = 100000
    val start = System.currentTimeMillis()

    for (i in 0..n){
       var j = getRandom()
        tree.insert(node, j)
    }
    for (i in 0..n/10){
        var j = getRandom()
        tree.find(node,j)
        tree.remove(node,j)
    }
    val ms = System.currentTimeMillis() - start
    println("result  =  $ms")
}

fun runMapExample(map: IStorage) {
    map.put("cat", 30)
    map.put("fox", 50)
    map.put("art", 10)
    map.put("owl", 80)
    map.put("box", 20)
    map.put("dog", 40)
    System.out.println(map.get("art"))
    System.out.println(map.get("box"))
    System.out.println(map.get("cat"))
    System.out.println(map.get("dog"))
    System.out.println(map.get("fox"))
    System.out.println(map.get("owl"))
}

fun getRandom():Int {
    val random = Random(System.nanoTime())
        return random.nextInt(10000)
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