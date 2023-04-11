package narzullaev.bekzod.translator_kmm.di

import narzullaev.bekzod.translator_kmm.database.TranslateDatabase
import narzullaev.bekzod.translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import narzullaev.bekzod.translator_kmm.translate.data.local.DatabaseDriverFactory
import narzullaev.bekzod.translator_kmm.translate.data.remote.HttpClientFactory
import narzullaev.bekzod.translator_kmm.translate.data.translate.KtorTranslateClient
import narzullaev.bekzod.translator_kmm.translate.domain.history.HistoryDataSource
import narzullaev.bekzod.translator_kmm.translate.domain.translate.Translate
import narzullaev.bekzod.translator_kmm.translate.domain.translate.TranslateClient

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    val translateUseCase: Translate by lazy {
        Translate(translateClient, historyDataSource)
    }

}