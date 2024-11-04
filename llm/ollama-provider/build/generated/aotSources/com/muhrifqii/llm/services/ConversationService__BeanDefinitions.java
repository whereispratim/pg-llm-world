package com.muhrifqii.llm.services;

import com.muhrifqii.llm.repositories.ConversationRepository;
import com.muhrifqii.llm.repositories.MessageRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ConversationService}.
 */
@Generated
public class ConversationService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'conversationService'.
   */
  private static BeanInstanceSupplier<ConversationService> getConversationServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ConversationService>forConstructor(ConversationRepository.class, MessageRepository.class)
            .withGenerator((registeredBean, args) -> new ConversationService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'conversationService'.
   */
  public static BeanDefinition getConversationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ConversationService.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getConversationServiceInstanceSupplier());
    return beanDefinition;
  }
}
