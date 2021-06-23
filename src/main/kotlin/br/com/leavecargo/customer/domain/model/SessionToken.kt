package br.com.leavecargo.customer.domain.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
data class SessionToken(
    @Id
    val token: UUID,

    @field:NotNull
    val customerId: UUID,

    @JsonFormat(pattern = ModelHelper.ISO_DATE_TIME)
    val stampDatetime: ZonedDateTime
)
