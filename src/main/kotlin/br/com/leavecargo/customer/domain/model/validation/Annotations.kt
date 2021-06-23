package br.com.leavecargo.customer.domain.model.validation

import javax.validation.Constraint
import javax.validation.constraints.NotBlank

@NotBlank
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [])
annotation class Birthdate (
        val message: String = "Date of birth is invalid.",
        val minAge: Int
)