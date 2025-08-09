package seriyalexandrov.springai

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatModel
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatConfig(
    private val chatModel: ChatModel
) {

    @Bean
    fun chatClient(): ChatClient = ChatClient.builder(chatModel)
        .defaultAdvisors()
        .build()
}