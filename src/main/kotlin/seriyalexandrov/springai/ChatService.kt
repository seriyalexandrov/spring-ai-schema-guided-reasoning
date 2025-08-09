package seriyalexandrov.springai

import org.springframework.ai.chat.client.ChatClient
import org.springframework.stereotype.Component

@Component
class ChatService(
    private val chatClient: ChatClient,
) {

    fun chat(prompt: String): String? =
        chatClient
            .prompt()
            .user { it.text(prompt) }
            .call()
            .content()
}
