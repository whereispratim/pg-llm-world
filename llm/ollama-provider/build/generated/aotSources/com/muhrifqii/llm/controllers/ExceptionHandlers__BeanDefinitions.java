package com.muhrifqii.llm.controllers;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ExceptionHandlers}.
 */
@Generated
public class ExceptionHandlers__BeanDefinitions {
  /**
   * Get the bean definition for 'exceptionHandlers'.
   */
  public static BeanDefinition getExceptionHandlersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExceptionHandlers.class);
    beanDefinition.setInstanceSupplier(ExceptionHandlers::new);
    return beanDefinition;
  }
}
