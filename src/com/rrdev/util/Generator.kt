package com.rrdev.util

import com.rrdev.extension.instantiateProcesses
import com.rrdev.model.Memory
import com.rrdev.model.Process
import java.util.*

class Generator(private val memory: Memory) {

    private var minCreationTime = 0
    private var maxCreationTime = 0
    private var minExecTime = 0
    private var maxExecTime = 0
    private var minSize = 0
    private var maxSize = 0
    private var qntProcess = 0
    private var lastCreateTime=0
    private val p: MutableList<Process> = ArrayList()


    init {
        println("AAA")
        val scan = Scanner(System.`in`)
        print("Quantidade de processos: ")
        qntProcess = scan.nextLine().toInt()
        print("Tempo minimo de execução: ")
        minExecTime = scan.nextLine().toInt()
        print("Tempo máximo de execução: ")
        maxExecTime = scan.nextLine().toInt()
        print("Tempo minimo de criação: ")
        minCreationTime = scan.nextLine().toInt()
        print("Tempo máximo de criação: ")
        maxCreationTime = scan.nextLine().toInt()
        print("Tamanho minimo do processo: ")
        minSize = scan.nextLine().toInt()
        print("Tamanho máximo do processo: ")
        maxSize = scan.nextLine().toInt()

        generateProcesses()
        memory.instantiateProcesses(AllocationStrategy.FIRST_FIT)

    }


    fun generateProcesses(){
        var id = 0
        val random = Random()
        for (i in 0..qntProcess){
            p.add(Process(id=id.toString(),
                    size = random.nextInt((maxSize+1)-minSize)+minSize,
                    creationTime = random.nextInt((maxCreationTime+1)-minCreationTime)+minCreationTime,
                    duration = random.nextInt((maxExecTime+1)-minExecTime)+minExecTime))
            id++
        }
    }


    fun elapsedSecond(elapsedTime: Int){
        var processCreated = false
        p.forEach {
            if (it.creationTime + lastCreateTime == elapsedTime){
                println("Processo ${it.id} foi para lista de espera")
                memory.waitList.add(it)
                p.remove(it)
                processCreated = true
                return@forEach
            }
        }
        if (processCreated){
            lastCreateTime = elapsedTime
            if (p.isEmpty()){
                println("Todo os processo foram criados.")
            }
        }
    }
















}