package com.example.cardinfofinder.data.models.info_finder

import java.io.Serializable

data class DomainCardDetails(
    val bank: String,
    val type: String,
    val country: String,
    val brand: String
) : Serializable