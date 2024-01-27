package org.example

import base.boudicca.api.enricher.EnricherClient
import base.boudicca.model.Event
import java.time.OffsetDateTime

fun main() {
    val enricherClient = EnricherClient("https://enricher.boudicca.events")

    val toEnrich = listOf(
        Event(
            "A concert",
            OffsetDateTime.now(),
            mapOf(
                "type" to "concert"
            )
        )
    )

    val result = enricherClient.enrichEvents(toEnrich)

    println("event data before enrichment: ")
    println(toEnrich[0].data)
    println("event data after enrichment: ")
    println(result[0].data)

}
