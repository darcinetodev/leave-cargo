package br.com.leavecargo.customer.domain.service

import br.com.leavecargo.customer.domain.model.Customer
import br.com.leavecargo.customer.domain.model.SessionToken
import br.com.leavecargo.customer.domain.repository.SessionTokenRepository
import br.com.leavecargo.customer.utils.HashUtils
import java.time.ZonedDateTime
import java.util.*
import javax.inject.Singleton

@Singleton
class AuthenticationService(
    private val customerService: CustomerService,
    private val sessionTokenRepository: SessionTokenRepository
) {

    fun authenticate(username: String, password: String) =
        customerService.findByUsername(username)
            ?.takeIf { HashUtils.checkEncryptedString(password, it.password) }
            ?.let { Pair(createSessionToken(it), it) }

    fun validateSessionToken(token: UUID, customerId: UUID) =
        getLastSessionToken(customerId)?.takeIf { it.token == token }

    private fun getLastSessionToken(customerId: UUID) =
        sessionTokenRepository.findByCustomerIdOrderByStampDatetimeDesc(customerId).orElse(null)

    private fun createSessionToken(customer: Customer) =
        sessionTokenRepository.save(
            SessionToken(
            UUID.randomUUID(),
            customer.id!!,
            ZonedDateTime.now())
        )
}