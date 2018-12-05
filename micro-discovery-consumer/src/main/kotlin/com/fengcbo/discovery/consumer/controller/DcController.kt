package com.fengcbo.discovery.consumer.controller

import com.fengcbo.discovery.consumer.client.DcClient
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
    @Resource
    private lateinit var dcClient: DcClient

    @GetMapping("/consumer")
    fun dc(): String {
        val serviceInstance = loadBalancerClient.choose("discovery-client1")
        val url = "http://" + serviceInstance.host + ":" + serviceInstance.port + "/dc"
        println(url)
        return restTemplate.getForObject(url, String::class.java) ?: "fail"
    }

    @GetMapping("/consumer2")
    fun dc2(): String {
        return restTemplate.getForObject("http://discovery-client1/dc", String::class.java) ?: "fail"
    }

    @GetMapping("/consumer3")
    fun dc3(): String {
        return dcClient.consumer()
    }
}