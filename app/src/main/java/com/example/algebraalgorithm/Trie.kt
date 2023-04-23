package com.example.algebraalgorithm


class Trie() {
    private val root: Node?
    init {
      root = Node()
    }

    companion object{
        const val A = 128

    }

    fun insert(word: String) {
    var node = root
        for (c: Char in word){
            node = node?.next(c)
        }
        node?.isEnd = true
    }

    fun search(word: String): Boolean {
        val node = go(word)
        if (node == null)
             return false
        return node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
    return go(prefix) != null
    }

    fun go(word: String) : Node?{
        var node = root
        for (c: Char in word){

            if (node != null && node.exists(c)){
                node = node.next(c)
            } else {
                return null
            }
        }
        return node
    }

    class Node(){
        private lateinit var child: Array<Node?>
        var isEnd: Boolean

        init {
           child  = Array<Node?>(size = A) { null }
            isEnd = false
        }


        fun next(c: Char): Node?{
            if (!exists(c)) {
                child[c.toInt()] = Node()
            }
            return child[c.toInt()]
        }

        fun exists(c: Char): Boolean{
          return  child[c.toInt()] != null
        }
    }
}
