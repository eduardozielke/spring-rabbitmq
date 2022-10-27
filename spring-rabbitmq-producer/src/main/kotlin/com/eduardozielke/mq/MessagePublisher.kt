package com.eduardozielke.mq

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.Date
import java.util.UUID

@RestController
class MessagePublisher(
    private val template: RabbitTemplate,
    private val config: MQConfig
) {

    @PostMapping("/publish")
    fun publishMessage(@RequestBody message: CustomMessage): String {
        message.apply {
            messageId = UUID.randomUUID().toString()
            messageDate = Date()
        }

        template.convertAndSend(config.exchangeName, config.routingKey, message)
        return "Message published"
    }
}