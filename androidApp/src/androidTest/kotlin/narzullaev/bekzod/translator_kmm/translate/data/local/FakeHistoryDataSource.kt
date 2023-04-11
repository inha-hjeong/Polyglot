package narzullaev.bekzod.translator_kmm.translate.data.local

import kotlinx.coroutines.flow.MutableStateFlow
import narzullaev.bekzod.translator_kmm.core.domain.util.CommonFlow
import narzullaev.bekzod.translator_kmm.core.domain.util.toCommonFlow
import narzullaev.bekzod.translator_kmm.translate.domain.history.HistoryDataSource
import narzullaev.bekzod.translator_kmm.translate.domain.history.HistoryItem

class FakeHistoryDataSource: HistoryDataSource {

    private val _data = MutableStateFlow<List<HistoryItem>>(emptyList())

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return _data.toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        _data.value += item
    }
}