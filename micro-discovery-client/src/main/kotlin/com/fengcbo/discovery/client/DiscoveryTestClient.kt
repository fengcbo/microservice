package com.fengcbo.discovery.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class DiscoveryTestClient

fun main(args: Array<String>) {
    runApplication<DiscoveryTestClient>(*args)
}
