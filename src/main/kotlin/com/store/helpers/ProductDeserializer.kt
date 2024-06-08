package com.store.helpers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class ProductDeserializer : JsonDeserializer<String>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): String? {
        val currentToken = parser.currentToken
        if (currentToken.isBoolean || currentToken.isNumeric) {
            return null
        }
        return parser.text
    }
}