package com.fengcbo.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class MicroDiscovery

fun main(args: Array<String>) {
    runApplication<MicroDiscovery>(*args)
}
