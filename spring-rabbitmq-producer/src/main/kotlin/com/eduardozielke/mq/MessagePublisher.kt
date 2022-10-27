package com.eduardozielke.mq

import org.springframework.web.bind.annotation.RequestBody
import java.util.Date
import java.util.UUID

class MessagePublisher {

    fun publishMessage(@RequestBody message: CustomMessage): String {
        message.messageId = UUID.randomUUID().toString()
        message.messageDate(Date())

    }
}