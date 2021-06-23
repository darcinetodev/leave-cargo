package br.com.leavecargo.customer.controller

import br.com.leavecargo.customer.controller.aspect.Authenticated
import br.com.leavecargo.customer.domain.service.AuthenticationService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/auth")
open class AuthenticationController(
    private val service: AuthenticationService
) {

    @Post
    fun auth(@Body request: AuthRequest): HttpResponse<AuthResponse> =
        service.authenticate(request.username, request.password)?.let {
            HttpResponse.created(AuthResponse(it.first.token, CustomerResponse(it.second)))
        }?: HttpResponse.unauthorized()

    @Get("/validate")
    @Authenticated
    open fun validateSessionToken(
        @Header("x-customer-token") customerToken: UUID,
        @QueryValue("customerId") customerId: UUID
    ): HttpResponse<AuthResponse> =
        HttpResponse.ok(AuthResponse(customerToken, null))

}