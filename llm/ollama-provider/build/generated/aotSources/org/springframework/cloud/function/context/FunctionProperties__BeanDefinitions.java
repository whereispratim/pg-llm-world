package org.springframework.cloud.function.context;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FunctionProperties}.
 */
@Generated
public class FunctionProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'functionProperties'.
   */
  public static BeanDefinition getFunctionPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FunctionProperties.class);
    beanDefinition.setInstanceSupplier(FunctionProperties::new);
    return beanDefinition;
  }
}
