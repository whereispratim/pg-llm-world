package com.muhrifqii.llm.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChatService}.
 */
@Generated
public class ChatService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'chatService'.
   */
  private static BeanInstanceSupplier<ChatService> getChatServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ChatService>forConstructor(ChatClient.class)
            .withGenerator((registeredBean, args) -> new ChatService(args.get(0)));
  }

  /**
   * Get the bean definition for 'chatService'.
   */
  public static BeanDefinition getChatServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatService.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getChatServiceInstanceSupplier());
    return beanDefinition;
  }
}
