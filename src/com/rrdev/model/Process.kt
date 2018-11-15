package com.rrdev.model

data class Process (val sizeOnMemory: Int,
                    val instanceTime: Int,
                    val durationTime: Int,
                    var allocationTime: Int?=null,
                    var finishedTime: Int?=null,
                    var waitTime: Int?=null)