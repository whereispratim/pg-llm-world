package org.springframework.ai.autoconfigure.ollama;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OllamaEmbeddingProperties}.
 */
@Generated
public class OllamaEmbeddingProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'ollamaEmbeddingProperties'.
   */
  public static BeanDefinition getOllamaEmbeddingPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OllamaEmbeddingProperties.class);
    beanDefinition.setInstanceSupplier(OllamaEmbeddingProperties::new);
    return beanDefinition;
  }
}
