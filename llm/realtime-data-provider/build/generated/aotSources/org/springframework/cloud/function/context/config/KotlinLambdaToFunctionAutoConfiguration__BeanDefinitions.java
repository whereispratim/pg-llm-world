package org.springframework.cloud.function.context.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link KotlinLambdaToFunctionAutoConfiguration}.
 */
@Generated
public class KotlinLambdaToFunctionAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'kotlinLambdaToFunctionAutoConfiguration'.
   */
  public static BeanDefinition getKotlinLambdaToFunctionAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KotlinLambdaToFunctionAutoConfiguration.class);
    beanDefinition.setTargetType(KotlinLambdaToFunctionAutoConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(KotlinLambdaToFunctionAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(KotlinLambdaToFunctionAutoConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
