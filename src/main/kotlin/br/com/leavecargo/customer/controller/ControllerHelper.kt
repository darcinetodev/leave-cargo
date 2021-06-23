package br.com.leavecargo.customer.controller

import io.micronaut.context.annotation.Value
import io.micronaut.data.model.Pageable
import javax.inject.Singleton

@Singleton
class ControllerHelper(
    @Value("\${app.controller.page-size}")
    private val pageSize: Int
) {

    fun buildPageable(page: Int?): Pageable {
        return Pageable.from(page?:0, pageSize)
    }

}