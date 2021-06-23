package br.com.leavecargo.customer.controller

import br.com.leavecargo.customer.domain.model.Customer
import java.util.*

data class CustomerResponse(
    val id: UUID?,
    val username: String?
) {
    constructor(customer: Customer) : this(
        id = customer.id,
        username = customer.username
    )
}

data class AuthRequest(
    val username: String,
    val password: String
)

data class AuthResponse(
    val token: UUID,
    val customer: CustomerResponse?
)