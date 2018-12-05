package com.fengcbo.discovery.consumer.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient("discovery-client1")
interface DcClient {

    @GetMapping("/dc")
    fun consumer(): String
}