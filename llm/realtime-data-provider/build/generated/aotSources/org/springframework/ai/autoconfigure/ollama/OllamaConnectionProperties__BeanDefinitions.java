package org.springframework.ai.autoconfigure.ollama;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OllamaConnectionProperties}.
 */
@Generated
public class OllamaConnectionProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'ollamaConnectionProperties'.
   */
  public static BeanDefinition getOllamaConnectionPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OllamaConnectionProperties.class);
    beanDefinition.setInstanceSupplier(OllamaConnectionProperties::new);
    return beanDefinition;
  }
}
