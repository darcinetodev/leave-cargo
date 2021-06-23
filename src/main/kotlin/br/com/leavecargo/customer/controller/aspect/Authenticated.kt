package br.com.leavecargo.customer.controller.aspect

import io.micronaut.aop.Around
import io.micronaut.context.annotation.Type

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@Around
@Type(AuthenticationInterceptor::class)
annotation class Authenticated
