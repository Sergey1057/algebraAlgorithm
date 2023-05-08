package com.example.algebraalgorithm.bits

class chess {

   fun getKingMoves(pos: Int): ULong{
       val K: ULong = (1 shl pos).toLong().toULong()
       val noA: ULong = 18374403900871474942u
       val Ka: ULong = K and noA
       val noH: ULong = 9187201950435737471u
       val Kh: ULong = K and noH


       val mask =
           (Ka shl 7) or  (K shl 8) or   (Kh shl 9) or
                   (Ka shr 1) or         (Kh shl 1) or
                   (Ka shr 9) or  (K shr 8) or   (Kh shr 7)
       return mask
   }

    fun getKnightMoves(pos: Int): ULong{
        val knightBits: ULong = (1 shl pos).toULong()
        val nA: ULong = 18374403900871474942u
        val nAB: ULong = 18229723555195321596u
        val nH: ULong =  9187201950435737471u
        val nGH: ULong = 4557430888798830399u

        val mask = (nGH and ((knightBits shl 6) or (knightBits shr 10))) or
                (nH and ((knightBits shl 15) or (knightBits shr 17))) or
                (nA and ((knightBits shl 17) or (knightBits shr 15))) or
                (nAB and ((knightBits shl 10) or (knightBits shr 6)))
        return mask
    }


    fun popcnt1(mask: ULong): Int{
        var maskLocal = mask
        var cnt: Int = 0
        while (maskLocal > 0u){
            cnt = cnt + (maskLocal and 1u).toInt()
            maskLocal = maskLocal shr 1
        }
        return cnt
    }

    fun popcnt2(mask: ULong): Int{
        var maskLocal = mask
        var cnt: Int = 0
        while (maskLocal > 0u){
            cnt++
            maskLocal = (maskLocal - 1u) and maskLocal
        }
        return cnt
    }
}