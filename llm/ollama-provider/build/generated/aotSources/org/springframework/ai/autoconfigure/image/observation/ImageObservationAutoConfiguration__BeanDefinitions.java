package org.springframework.ai.autoconfigure.image.observation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ImageObservationAutoConfiguration}.
 */
@Generated
public class ImageObservationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'imageObservationAutoConfiguration'.
   */
  public static BeanDefinition getImageObservationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ImageObservationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ImageObservationAutoConfiguration::new);
    return beanDefinition;
  }
}
