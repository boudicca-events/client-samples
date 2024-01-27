package org.example

import base.boudicca.api.eventdb.publisher.EventDbPublisherClient

fun main() {
    val publisherClient = EventDbPublisherClient("https://eventdb.boudicca.events")
    val allEvents = publisherClient.getAllEvents()
    //only print 20 because there are quite a lot of entries in our eventdb :)
    for (event in allEvents.take(20)) {
        println(event)
    }
}