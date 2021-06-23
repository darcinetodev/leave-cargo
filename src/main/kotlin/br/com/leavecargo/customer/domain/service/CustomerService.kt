package br.com.leavecargo.customer.domain.service

import br.com.leavecargo.customer.domain.exception.NotFoundException
import br.com.leavecargo.customer.domain.exception.UserAlreadyExistsException
import br.com.leavecargo.customer.domain.model.Customer
import br.com.leavecargo.customer.domain.repository.CustomerRepository
import br.com.leavecargo.customer.utils.HashUtils
import java.time.ZonedDateTime
import java.util.*
import javax.inject.Singleton

interface CustomerService {
    fun save(customer: Customer): Customer
    fun findById(customerId: UUID): Customer?
    fun updatePassword(customerId: UUID, password: String): Customer
    fun findByUsername(username: String): Customer?
}

@Singleton
class CustomerServiceImpl(
    private val repository: CustomerRepository,
    private val helper: ServiceHelper
) : CustomerService {

    override fun save(customer: Customer): Customer {
        repository.findByUsername(customer.username)
            .ifPresent { throw UserAlreadyExistsException() }

        val stampDatetime = ZonedDateTime.now(helper.getApplicationClock())
        val uuid = UUID.randomUUID()
        val encryptedPassword = HashUtils.encryptPassword(uuid.toString(), customer.password)
        val customerToSave = customer.copy(
            id = uuid,
            password = encryptedPassword,
            stampDatetime = stampDatetime
        )

        return repository.save(customerToSave)
    }

    override fun findById(customerId: UUID): Customer? =
        repository.findById(customerId)
            .orElse(null)

    override fun findByUsername(username: String): Customer? =
        repository.findByUsername(username)
            .orElse(null)

    override fun updatePassword(customerId: UUID, password: String) =
        findById(customerId)?.let {
            val customerToUpdate = it.copy(
                password = HashUtils.encryptPassword(customerId.toString(), password)
            )

            repository.update(customerToUpdate)
        } ?: throw NotFoundException()

}