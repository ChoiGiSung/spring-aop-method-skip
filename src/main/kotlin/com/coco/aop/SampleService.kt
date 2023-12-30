package com.coco.aop

import org.springframework.stereotype.Service

@Service
class SampleService {

    @Skip(targetParam = "id", entityType = EntityType.USER)
    fun sample1(id: Long) {
        println(id)
    }
}