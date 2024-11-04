package com.muhrifqii.llm.configurations;

import org.flywaydb.core.Flyway;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link DatabaseConfig}.
 */
@Generated
public class DatabaseConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'databaseConfig'.
   */
  public static BeanDefinition getDatabaseConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DatabaseConfig.class);
    beanDefinition.setTargetType(DatabaseConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(DatabaseConfig.class);
    beanDefinition.setInstanceSupplier(DatabaseConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'flyway'.
   */
  private static BeanInstanceSupplier<Flyway> getFlywayInstanceSupplier() {
    return BeanInstanceSupplier.<Flyway>forFactoryMethod(DatabaseConfig.class, "flyway", FlywayProperties.class, R2dbcProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DatabaseConfig.class).flyway(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'flyway'.
   */
  public static BeanDefinition getFlywayBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Flyway.class);
    beanDefinition.setInitMethodNames("migrate");
    beanDefinition.setInstanceSupplier(getFlywayInstanceSupplier());
    return beanDefinition;
  }
}
