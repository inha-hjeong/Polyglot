package narzullaev.bekzod.translator_kmm.translate.data.history

import database.HistoryEntity
import narzullaev.bekzod.translator_kmm.translate.domain.history.HistoryItem

fun HistoryEntity.toHistoryItem(): HistoryItem {
    return HistoryItem(
        id = id,
        fromLanguageCode = fromLanguageCode,
        fromText = fromText,
        toLanguageCode = toLanguageCode,
        toText = toText
    )
}