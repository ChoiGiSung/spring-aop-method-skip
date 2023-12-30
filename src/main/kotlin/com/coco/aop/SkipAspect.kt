package com.coco.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class SkipAspect {

    @Around("@annotation(annotation)")
    fun judgement(joinPoint: ProceedingJoinPoint, annotation: Skip): Any? {
        val target = annotation.targetParam
        val entityType = annotation.entityType
        return joinPoint.proceed()
    }


}