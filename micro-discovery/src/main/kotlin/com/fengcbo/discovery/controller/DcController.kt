package com.fengcbo.discovery.controller

import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
class DcController {

    @Resource
    private lateinit var discoveryClient: DiscoveryClient

    @GetMapping("/dc")
    fun dc(): String {
        val services: String = "Services: " + discoveryClient.services
        println(services)
        return services
    }

}