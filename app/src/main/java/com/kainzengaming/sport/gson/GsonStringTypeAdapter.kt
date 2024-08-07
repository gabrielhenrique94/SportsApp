package com.kainzengaming.sport.gson

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

class GsonStringTypeAdapter : TypeAdapter<String?>() {

    override fun write(out: JsonWriter?, value: String?) {
        if (value == null) {
            out?.nullValue()
        } else {
            out?.value(value)
        }
    }

    override fun read(reader: JsonReader?): String? {
        val jsonToken = reader?.peek()
        if (jsonToken == JsonToken.STRING) {
            return reader.nextString().orEmpty()
        } else {
            reader?.skipValue()
            return null
        }
    }

}