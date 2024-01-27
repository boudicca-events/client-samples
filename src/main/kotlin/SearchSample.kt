package org.example

import base.boudicca.api.search.FilterQueryDTO
import base.boudicca.api.search.FilterQueryEntryDTO
import base.boudicca.api.search.QueryDTO
import base.boudicca.api.search.SearchClient

fun main() {
    val searchClient = SearchClient("https://search.boudicca.events")

    sendQuery(searchClient)
    getFilters(searchClient)
}

fun getFilters(searchClient: SearchClient) {
    val filterQueryDTO = FilterQueryDTO(
        listOf(
            FilterQueryEntryDTO("location.name", false),
            FilterQueryEntryDTO("location.city", true)
        )
    )

    val result = searchClient.getFiltersFor(filterQueryDTO)

    println()
    println("all different location names:")
    for (locationName in result["location.name"]!!) {
        println(locationName)
    }

    println()
    println("all different cities of boudicca:")
    for (locationCity in result["location.city"]!!) {
        println(locationCity)
    }
}

fun sendQuery(searchClient: SearchClient) {
    val queryDTO = QueryDTO(
        """ "location.name" equals "posthof" """,
        0,
        20
    )

    val result = searchClient.queryEvents(queryDTO)

    println("query found ${result.totalResults} results in total, printing the first 20")
    for (event in result.result) {
        println(event)
    }
}
