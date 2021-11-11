package com.example.cardinfofinder.data.models.info_finder

data class CardInfoResponse(
    val number: CardNumber?,
    val country: CardCountry?,
    val bank: CardBank?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
)

data class CardNumber(
    val length: Int?,
    val luhn: Boolean?
)

data class CardCountry(
    val numeric: String?,
    val alpha2: String?,
    val name: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Int?,
    val longitude: Int?
)

data class CardBank(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?,
)
