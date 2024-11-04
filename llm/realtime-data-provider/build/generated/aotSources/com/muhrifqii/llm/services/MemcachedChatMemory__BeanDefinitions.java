package com.muhrifqii.llm.services;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MemcachedChatMemory}.
 */
@Generated
public class MemcachedChatMemory__BeanDefinitions {
  /**
   * Get the bean definition for 'memcachedChatMemory'.
   */
  public static BeanDefinition getMemcachedChatMemoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MemcachedChatMemory.class);
    beanDefinition.setInstanceSupplier(MemcachedChatMemory::new);
    return beanDefinition;
  }
}
