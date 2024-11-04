package org.springframework.ai.autoconfigure.chat.client;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChatClientBuilderProperties}.
 */
@Generated
public class ChatClientBuilderProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'chatClientBuilderProperties'.
   */
  public static BeanDefinition getChatClientBuilderPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatClientBuilderProperties.class);
    beanDefinition.setInstanceSupplier(ChatClientBuilderProperties::new);
    return beanDefinition;
  }
}
