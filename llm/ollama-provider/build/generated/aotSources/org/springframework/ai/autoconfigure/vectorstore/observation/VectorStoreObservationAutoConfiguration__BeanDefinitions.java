package org.springframework.ai.autoconfigure.vectorstore.observation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link VectorStoreObservationAutoConfiguration}.
 */
@Generated
public class VectorStoreObservationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'vectorStoreObservationAutoConfiguration'.
   */
  public static BeanDefinition getVectorStoreObservationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VectorStoreObservationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(VectorStoreObservationAutoConfiguration::new);
    return beanDefinition;
  }
}
