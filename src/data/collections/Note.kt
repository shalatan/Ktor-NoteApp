package com.shalatan.data.collections

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Note(
    val title: String,
    val content: String,
    val date: Long,
    val owners: List<String>,
    val colour: String,
    @BsonId //tell mongo that it's id
    val id: String = ObjectId().toString()
)
