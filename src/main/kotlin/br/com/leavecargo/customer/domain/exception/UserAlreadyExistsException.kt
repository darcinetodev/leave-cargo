package br.com.leavecargo.customer.domain.exception

import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException

class UserAlreadyExistsException : HttpStatusException(HttpStatus.BAD_REQUEST, "Usuário já cadastrado.")
