package com.coco.aop

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Skip(
    val targetParam: String,
    val entityType: EntityType
)
