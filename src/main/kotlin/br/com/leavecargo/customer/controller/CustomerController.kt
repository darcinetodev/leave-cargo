package br.com.leavecargo.customer.controller

import br.com.leavecargo.customer.controller.aspect.Authenticated
import br.com.leavecargo.customer.domain.exception.NotFoundException
import br.com.leavecargo.customer.domain.model.Customer
import br.com.leavecargo.customer.domain.service.CustomerService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/customers")
open class CustomerController(
    private val service: CustomerService
) {
    @Post
    @Status(HttpStatus.CREATED)
    fun save(@Body customer: Customer): CustomerResponse =
        CustomerResponse(service.save(customer))

    @Get("/{id}")
    @Authenticated
    open fun findById(@Header("x-customer-token") customerToken: UUID,
                      @PathVariable("id") customerId: UUID): HttpResponse<CustomerResponse> =
        HttpResponse.ok(service.findById(customerId)
            ?.let { CustomerResponse(it) }
            ?: throw NotFoundException())

    @Put("/{id}/password")
    @Authenticated
    open fun updatePassword(@Header("x-customer-token") customerToken: UUID,
                            @PathVariable("id") customerId: UUID,
                            @QueryValue password: String): HttpResponse<CustomerResponse> =
        HttpResponse.ok(CustomerResponse(service.updatePassword(customerId, password)))
}