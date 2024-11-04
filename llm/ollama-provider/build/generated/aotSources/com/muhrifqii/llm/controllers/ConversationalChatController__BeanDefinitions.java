package com.muhrifqii.llm.controllers;

import com.muhrifqii.llm.api.traits.ChatServiceTrait;
import com.muhrifqii.llm.api.traits.ConversationServiceTrait;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ConversationalChatController}.
 */
@Generated
public class ConversationalChatController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'conversationalChatController'.
   */
  private static BeanInstanceSupplier<ConversationalChatController> getConversationalChatControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ConversationalChatController>forConstructor(ChatServiceTrait.class, ConversationServiceTrait.class)
            .withGenerator((registeredBean, args) -> new ConversationalChatController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'conversationalChatController'.
   */
  public static BeanDefinition getConversationalChatControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ConversationalChatController.class);
    beanDefinition.setInstanceSupplier(getConversationalChatControllerInstanceSupplier());
    return beanDefinition;
  }
}
