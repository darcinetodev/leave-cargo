package br.com.leavecargo.customer.domain.service

import io.micronaut.context.annotation.Value
import java.time.Clock
import java.time.ZoneId
import javax.inject.Singleton

@Singleton
class ServiceHelper(
    @Value("\${app.service.zone-id}")
    private val zoneId: String
) {

    fun getApplicationClock(): Clock {
        return Clock.system(ZoneId.of(zoneId))
    }

}
