package narzullaev.bekzod.translator_kmm.translate.domain.history

import narzullaev.bekzod.translator_kmm.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}