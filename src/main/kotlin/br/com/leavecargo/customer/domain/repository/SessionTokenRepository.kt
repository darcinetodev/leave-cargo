package br.com.leavecargo.customer.domain.repository

import br.com.leavecargo.customer.domain.model.SessionToken
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface SessionTokenRepository : JpaRepository<SessionToken, UUID> {
    fun findByCustomerIdOrderByStampDatetimeDesc(customerId: UUID): Optional<SessionToken>
}