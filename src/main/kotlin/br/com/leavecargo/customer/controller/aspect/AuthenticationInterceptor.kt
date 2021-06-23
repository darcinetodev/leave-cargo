package br.com.leavecargo.customer.controller.aspect

import br.com.leavecargo.customer.domain.service.AuthenticationService
import io.micronaut.aop.InvocationContext
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import io.micronaut.http.HttpResponse
import javax.inject.Singleton

@Singleton
class AuthenticationInterceptor(
    private val service: AuthenticationService
) : MethodInterceptor<Any, HttpResponse<Any>> {

    override fun intercept(context: MethodInvocationContext<Any, HttpResponse<Any>>): HttpResponse<Any> =
        service.validateSessionToken(getParam("customerToken", context), getParam("customerId", context))
            ?.let { context.proceed() }
            ?: HttpResponse.unauthorized()

    private inline fun <reified T> getParam(name: String, context: InvocationContext<Any, HttpResponse<Any>>) =
        context.parameterValueMap[name]
            ?.takeIf { it is T }
            ?.let { it as T }
            ?: throw IllegalArgumentException("Illegal $name param")

}
