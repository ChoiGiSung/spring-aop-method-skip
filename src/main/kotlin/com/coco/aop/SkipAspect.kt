package com.coco.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component
import java.lang.NullPointerException
import java.lang.UnsupportedOperationException

@Aspect
@Component
class SkipAspect(
    private val skipValidator: SkipValidator
) {

    @Around("@annotation(annotation)")
    fun judgement(joinPoint: ProceedingJoinPoint, annotation: Skip): Any? {
        val target = annotation.targetParam
        val entityType = annotation.entityType
        val targetLong = getValue(joinPoint, target)
        if (skipValidator.validate(targetLong, entityType)) {
            return null
        }
        return joinPoint.proceed()
    }

    private fun getValue(joinPoint: ProceedingJoinPoint, target: String): Long {
        val parameterNames = (joinPoint.signature as MethodSignature).parameterNames
        val arguments = joinPoint.args
        for ((index, parameterName) in parameterNames.withIndex()) {
            if (target == parameterName) {
                return arguments[index].toString().toLong()
            }
        }
        throw NullPointerException(target)
    }

}