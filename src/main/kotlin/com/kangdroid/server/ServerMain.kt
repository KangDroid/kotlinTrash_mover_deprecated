package com.kangdroid.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ServerMain

fun main(args: Array<String>) {
    SpringApplication.run(ServerMain::class.java, *args)
}