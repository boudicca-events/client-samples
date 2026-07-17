package org.example

import base.boudicca.api.eventdb.publisher.DefaultEventDbPublisherClient

fun main() {
    val publisherClient = DefaultEventDbPublisherClient("https://eventdb.boudicca.events")
    val allEvents = publisherClient.getAllEvents()
    //only print 20 because there are quite a lot of entries in our eventdb :)
    for (event in allEvents.take(20)) {
        println(event)
    }
}