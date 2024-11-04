package org.springframework.ai.autoconfigure.chat.observation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChatObservationAutoConfiguration}.
 */
@Generated
public class ChatObservationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'chatObservationAutoConfiguration'.
   */
  public static BeanDefinition getChatObservationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatObservationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ChatObservationAutoConfiguration::new);
    return beanDefinition;
  }
}
