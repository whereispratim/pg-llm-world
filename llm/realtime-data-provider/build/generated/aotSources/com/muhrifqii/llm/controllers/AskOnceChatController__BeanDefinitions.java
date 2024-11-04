package com.muhrifqii.llm.controllers;

import com.muhrifqii.llm.api.usecases.PromptModelUsecase;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AskOnceChatController}.
 */
@Generated
public class AskOnceChatController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'askOnceChatController'.
   */
  private static BeanInstanceSupplier<AskOnceChatController> getAskOnceChatControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AskOnceChatController>forConstructor(PromptModelUsecase.class)
            .withGenerator((registeredBean, args) -> new AskOnceChatController(args.get(0)));
  }

  /**
   * Get the bean definition for 'askOnceChatController'.
   */
  public static BeanDefinition getAskOnceChatControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AskOnceChatController.class);
    beanDefinition.setInstanceSupplier(getAskOnceChatControllerInstanceSupplier());
    return beanDefinition;
  }
}
