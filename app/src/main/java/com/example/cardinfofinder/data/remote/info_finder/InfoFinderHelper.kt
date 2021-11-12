package com.example.cardinfofinder.data.remote.info_finder

import com.example.cardinfofinder.data.models.info_finder.CardInfoResponse
import com.example.cardinfofinder.data.remote.LookupBinService
import javax.inject.Inject

open class InfoFinderHelper @Inject constructor (
    private var lookupBinService: LookupBinService
) {

    suspend fun lookupBIN(bin: String): CardInfoResponse = lookupBinService.lookupBIN(bin)

}