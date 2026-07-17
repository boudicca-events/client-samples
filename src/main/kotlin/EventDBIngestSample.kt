package org.example

import base.boudicca.api.eventdb.ingest.DefaultEventDbIngestClient
import base.boudicca.model.Event
import java.time.OffsetDateTime

fun main() {
    val ingestClient = DefaultEventDbIngestClient("https://eventdb.boudicca.events", "ingest", "ingest")

    val newEvents = listOf(
        Event(
            "Boudicca Team Event",
            OffsetDateTime.now(),
            mapOf(
                "to.bring" to "cake",
                "agenda" to "eating cake"
            )
        )
    )

    //this will actually not work since "ingest:ingest" is not a valid ingest authentication on https://eventdb.boudicca.events
    ingestClient.ingestEvents(newEvents)
}