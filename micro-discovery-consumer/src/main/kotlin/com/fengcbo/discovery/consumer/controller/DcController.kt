package com.fengcbo.discovery.consumer.controller

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import javax.annotation.Resource


@RestController
class DcController {

    @Resource
    private lateinit var loadBalancerClient: LoadBalancerClient
    @Resource
    private lateinit var restTemplate: RestTemplate

    @GetMapping("/consumer")
    fun dc(): String {
        val serviceInstance = loadBalancerClient.choose("discovery-client1")
        val url = "http://" + serviceInstance.host + ":" + serviceInstance.port + "/dc"
        println(url)
        return restTemplate.getForObject(url, String::class.java) ?: "fail"
    }
}