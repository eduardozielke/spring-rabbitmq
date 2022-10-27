package com.eduardozielke.mq

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

//@Component
@Configuration
class MQConfig {
    val queueName = "message_queue"
    val exchangeName = "message_exchange"
    val routingKey = "message_routingKey"

    fun queue(): Queue {
        return Queue(queueName)
    }

    fun exchange(): TopicExchange {
        return TopicExchange(exchangeName)
    }

    fun binding(queue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey)
    }

    fun messageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }

    fun template(connectionFactory: ConnectionFactory): AmqpTemplate {
        val template = RabbitTemplate(connectionFactory)
        template.messageConverter = messageConverter()
        return template
    }

}
