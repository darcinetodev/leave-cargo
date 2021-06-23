package br.com.leavecargo.customer.domain.model.validation

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import java.time.LocalDate
import java.time.Period
import javax.inject.Singleton

@Singleton
class BirthdateValidator : ConstraintValidator<Birthdate, LocalDate?> {

    override fun isValid(value: LocalDate?,
                         annotationMetadata: AnnotationValue<Birthdate>,
                         context: ConstraintValidatorContext): Boolean {
        if (value == null) return false
        return Period.between(value, LocalDate.now()).years >= annotationMetadata.intValue("minAge").asInt
    }

}