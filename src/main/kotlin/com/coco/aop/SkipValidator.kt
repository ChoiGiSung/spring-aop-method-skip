package com.coco.aop

import org.springframework.stereotype.Component

@Component
class SkipValidator(
    private val userService: UserService
) {

    private val skipEntityMethods = mapOf(
        EntityType.USER to userService::findById
    )

    fun validate(id: Long, entityType: EntityType): Boolean {
        return skipEntityMethods[entityType]?.invoke(id) != null
    }
}