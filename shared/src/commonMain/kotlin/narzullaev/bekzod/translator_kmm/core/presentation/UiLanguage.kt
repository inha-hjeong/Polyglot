package narzullaev.bekzod.translator_kmm.core.presentation

import narzullaev.bekzod.translator_kmm.core.domain.language.Language

expect class UiLanguage {
    val language: Language
    companion object {
        fun byCode(langCode:String) : UiLanguage
        val allLanguages: List<UiLanguage>
    }
}