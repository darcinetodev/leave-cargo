package br.com.leavecargo.customer.domain.exception

import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException

class NotFoundException : HttpStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.reason)
