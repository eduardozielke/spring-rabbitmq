package com.eduardozielke.mq

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringRabbitmqConsumerApplication

fun main(args: Array<String>) {
	runApplication<SpringRabbitmqConsumerApplication>(*args)
}
