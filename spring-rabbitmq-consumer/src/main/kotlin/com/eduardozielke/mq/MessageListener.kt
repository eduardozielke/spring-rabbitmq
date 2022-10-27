package com.eduardozielke.mq

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MessageListener {

    @RabbitListener(queues = [MQConfig.QUEUE_NAME])
    fun listener(message: CustomMessage): Unit {
        println(message)
    }
}