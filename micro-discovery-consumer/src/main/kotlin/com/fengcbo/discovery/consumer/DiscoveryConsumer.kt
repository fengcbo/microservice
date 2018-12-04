package com.fengcbo.discovery.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate



@SpringBootApplication
class DiscoveryConsumer {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {

    runApplication<DiscoveryConsumer>(*args)
}