package com.example.cardinfofinder

import com.example.cardinfofinder.data.models.info_finder.CardBank
import com.example.cardinfofinder.data.models.info_finder.CardCountry
import com.example.cardinfofinder.data.models.info_finder.CardInfoResponse
import com.example.cardinfofinder.data.models.info_finder.CardNumber

object TestConstants {

    val CARD_DETAILS_RESPONSE = CardInfoResponse(
        number = CardNumber(length = 16, luhn = null),
        brand = "MASTERCARD",
        bank = CardBank("ZENITH BANK", null, null, "Lagos, Nigeria"),
        type = "DEBIT",
        country = CardCountry("", "", "Nigeria", "", "NGN", latitude = 0, longitude = 0),
        prepaid = false,
        scheme = "Debit"
    )

}