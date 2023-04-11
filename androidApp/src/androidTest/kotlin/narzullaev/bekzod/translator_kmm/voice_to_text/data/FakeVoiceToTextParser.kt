package narzullaev.bekzod.translator_kmm.voice_to_text.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import narzullaev.bekzod.translator_kmm.core.domain.util.CommonStateFlow
import narzullaev.bekzod.translator_kmm.core.domain.util.toCommonStateFlow
import narzullaev.bekzod.translator_kmm.voice_to_text.domain.VoiceToTextParser
import narzullaev.bekzod.translator_kmm.voice_to_text.domain.VoiceToTextParserState

class FakeVoiceToTextParser: VoiceToTextParser {

    private val _state = MutableStateFlow(VoiceToTextParserState())
    override val state: CommonStateFlow<VoiceToTextParserState>
        get() = _state.toCommonStateFlow()

    var voiceResult = "test result"

    override fun startListening(languageCode: String) {
        _state.update { it.copy(
            result = "",
            isSpeaking = true
        ) }
    }

    override fun stopListening() {
        _state.update { it.copy(
            result =  voiceResult,
            isSpeaking = false
        ) }
    }

    override fun cancel() = Unit

    override fun reset() {
        _state.update { VoiceToTextParserState() }
    }
}