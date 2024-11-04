package org.springframework.ai.autoconfigure.ollama;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OllamaChatProperties}.
 */
@Generated
public class OllamaChatProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'ollamaChatProperties'.
   */
  public static BeanDefinition getOllamaChatPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OllamaChatProperties.class);
    beanDefinition.setInstanceSupplier(OllamaChatProperties::new);
    return beanDefinition;
  }
}
