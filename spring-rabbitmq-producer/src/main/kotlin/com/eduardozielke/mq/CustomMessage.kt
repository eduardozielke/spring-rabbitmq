package com.eduardozielke.mq

import java.io.Serializable
import java.util.Date

class CustomMessage : Serializable {

    var messageId: String? = null
    var message: String? = null
    var messageDate: Date? = null
}