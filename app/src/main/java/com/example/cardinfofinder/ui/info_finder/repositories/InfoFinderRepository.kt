package com.example.cardinfofinder.ui.info_finder.repositories

import com.example.cardinfofinder.data.models.info_finder.CardInfoResponse
import com.example.cardinfofinder.data.remote.info_finder.InfoFinderHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

open class InfoFinderRepository @Inject constructor(
    var infoFinderHelper: InfoFinderHelper
) {

    suspend fun lookupBIN(bin: String): CardInfoResponse {
        return withContext(Dispatchers.IO) {
            infoFinderHelper.lookupBIN(bin)
        }
    }

}