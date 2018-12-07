package com.rrdev.extension

import com.rrdev.model.Hole
import com.rrdev.model.Memory
import com.rrdev.util.AllocationStrategy
import com.rrdev.util.AllocationStrategy.*

fun Memory.instantiateProcesses(allocationStrategy: AllocationStrategy){
    when(allocationStrategy){
        FIRST_FIT ->{
            firstFit()
        }
        WORST_FIT ->{
            worstFit()
        }
        BEST_FIT ->{
            bestFit()
        }
    }
}

fun Memory.getBiggerHole(): Hole {
    return holes.fold(Hole()){acc, c-> if (c.size > acc.size) c else acc }
}

