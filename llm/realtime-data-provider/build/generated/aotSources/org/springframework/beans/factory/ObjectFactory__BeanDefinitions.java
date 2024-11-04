package org.springframework.beans.factory;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ObjectFactory}.
 */
@Generated
public class ObjectFactory__BeanDefinitions {
  /**
   * Get the inner-bean definition for 'reactiveAuditingEntityCallbackInnerBean'.
   */
  public static BeanDefinition getReactiveAuditingEntityCallbackInnerBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ObjectFactoryCreatingFactoryBean.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.getPropertyValues().addPropertyValue("targetBeanName", "r2dbcAuditingHandler");
    beanDefinition.setInstanceSupplier(ObjectFactoryCreatingFactoryBean::new);
    return beanDefinition;
  }
}
