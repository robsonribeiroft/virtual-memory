package com.rrdev.model

import com.rrdev.extension.getBiggerHole
import com.rrdev.time.Time
import com.rrdev.time.TimeListener

data class Memory (var size: Int,
                   var soSize: Int,
                   var runList: MutableList<Process> = ArrayList(),
                   var waitList: MutableList<Process> = ArrayList(),
                   var completedList: MutableList<Process> = ArrayList(),
                   var holes: MutableList<Hole> = ArrayList()){

    private var listener: TimeListener.Finish? = null

    init {
        runList.add(Process(id = "SO", size = soSize, creationTime = 0, duration = Int.MAX_VALUE, osType = true))
    }


    fun setListener(listener: TimeListener.Finish){
        this.listener = listener
    }


    private fun calculateHoles(){

        holes = ArrayList()

        if (runList.isEmpty()){
            holes.add(Hole(soSize +1, size))
        }
        else{
            runList.forEachIndexed { index, process ->
                if (process.endPage < runList[index+1].startPage-1){
                    holes.add(Hole(process.endPage -1, runList[index+1].startPage-1))
                }
            }
            if (runList.last().endPage < this.size){
                holes.add(Hole(runList.last().endPage -1, this.size))
            }
        }
    }


    fun firstFit() {
        var isFinished = false

        while (isFinished.not() && waitList.isNotEmpty()){
            var findHole = false
            val process = waitList.first()
            holes.forEach {
                if (process.size <= it.size){
                    println("Processo ${process.id} instanciado!")
                    process.defineStartPage(it.startPage)
                    runList.add(process)
                    waitList.remove(process)
                    calculateHoles()
                    findHole = true
                    return@forEach
                }
            }
            if (findHole.not()){
                isFinished = true
            }
        }
    }

    fun bestFit() {
        var isFinished = false

        while (isFinished.not() && waitList.isNotEmpty()){

            val process = waitList.first()
            val biggerHole = getBiggerHole()

            if (process.size <= biggerHole.size){
                println("Processo ${process.id} instanciado!")
                process.defineStartPage(biggerHole.startPage)
                runList.add(process)
                waitList.remove(process)
                calculateHoles()
            }
            else{
                isFinished = true
            }
        }
    }

    fun worstFit() {
        var isFinished = false

        while (isFinished.not() && waitList.isNotEmpty()){
            var findHole = false
            val process = waitList.first()
            holes.sortByDescending { it.size }
            holes.forEach {
                if (process.size <= it.size){
                    println("Processo ${process.id} instanciado!")
                    process.defineStartPage(process.startPage)
                    runList.add(process)
                    waitList.remove(process)
                    calculateHoles()
                    findHole = true
                    return@forEach
                }
            }

            if (findHole.not()){
                isFinished = true
            }
        }
    }


    fun verifyRunningProcess(){
        runList.forEach {
            it.decreaseTime()

            if (it.duration <= 0 && it.osType.not()){
                println("Processo ${it.id} finalizado!")
                completedList.add(it)
                runList.remove(it)
                calculateHoles()
                if (runList.isEmpty() && waitList.isEmpty()){
                 listener?.finishCount()
                }
            }
        }
    }


    fun increaseAllWaitTime(){
        waitList.forEach { it.increaseWaitTime() }
        runList.forEach { it.increaseWaitTime() }
    }

    fun getAverageWaitTime(){
        val totalWaitTime = completedList.fold(0) { acc, c -> acc + c.wait }
        var averageWaitTime = 0
        if (completedList.isNotEmpty()){
           averageWaitTime = totalWaitTime/completedList.size
        }
        println("Tempo médio de espera: $averageWaitTime")
    }

}