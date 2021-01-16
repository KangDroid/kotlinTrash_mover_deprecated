package com.kangdroid.main.server

import org.springframework.web.client.RestTemplate

class ServerChecker {
    private var isServerAlive: Boolean = false

    fun checkServerAlive() {
        val restTemplate: RestTemplate = RestTemplate()
        val url: String = "http://127.0.0.1:8080/"
        var responseString: String

        try {
            responseString = restTemplate.getForObject(url, String::class.java) ?: "Nope"
            isServerAlive = true
        } catch (e: Exception) {
            println("Failed to get Object : ${e.message}")
            isServerAlive = false
        }
    }
}