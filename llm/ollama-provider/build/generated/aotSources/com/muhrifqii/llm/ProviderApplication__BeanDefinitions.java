package com.muhrifqii.llm;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ProviderApplication}.
 */
@Generated
public class ProviderApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'providerApplication'.
   */
  public static BeanDefinition getProviderApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProviderApplication.class);
    beanDefinition.setTargetType(ProviderApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(ProviderApplication.class);
    beanDefinition.setInstanceSupplier(ProviderApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
