package com.coco.aop

import org.springframework.stereotype.Service

@Service
class UserService {

    // sample
    fun findById(id: Long): Long? {
        if (id == 1L) {
            return null
        }
        return id
    }
}