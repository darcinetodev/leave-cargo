package br.com.leavecargo.customer.domain.model

import br.com.leavecargo.customer.domain.model.validation.Birthdate
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Customer(
    @Id
    val id: UUID?,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    @field:Birthdate(minAge = 13)
    val birthdate: LocalDate,

    @field:NotBlank
    val username: String,

    @field:NotBlank
    @field:Size(min = 6, max = 128)
    val password: String,

    @JsonFormat(pattern = ModelHelper.ISO_DATE_TIME)
    val stampDatetime: ZonedDateTime?,
)
