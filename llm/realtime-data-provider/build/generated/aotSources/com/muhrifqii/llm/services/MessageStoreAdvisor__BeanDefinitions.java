package com.muhrifqii.llm.services;

import com.muhrifqii.llm.api.usecases.MessageStoreUsecase;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MessageStoreAdvisor}.
 */
@Generated
public class MessageStoreAdvisor__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'messageStoreAdvisor'.
   */
  private static BeanInstanceSupplier<MessageStoreAdvisor> getMessageStoreAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MessageStoreAdvisor>forConstructor(ChatMemory.class, MessageStoreUsecase.class)
            .withGenerator((registeredBean, args) -> new MessageStoreAdvisor(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'messageStoreAdvisor'.
   */
  public static BeanDefinition getMessageStoreAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MessageStoreAdvisor.class);
    beanDefinition.setInstanceSupplier(getMessageStoreAdvisorInstanceSupplier());
    return beanDefinition;
  }
}
