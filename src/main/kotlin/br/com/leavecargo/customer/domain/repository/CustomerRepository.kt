package br.com.leavecargo.customer.domain.repository

import br.com.leavecargo.customer.domain.model.Customer
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface CustomerRepository : JpaRepository<Customer, UUID> {
    fun update(@Id id: UUID, password: String)
    fun findByUsername(username: String): Optional<Customer>
}