package org.springframework.boot.autoconfigure.flyway;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlywayAutoConfiguration}.
 */
@Generated
public class FlywayAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'flywayAutoConfiguration'.
   */
  public static BeanDefinition getFlywayAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlywayAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(FlywayAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'stringOrNumberMigrationVersionConverter'.
   */
  private static BeanInstanceSupplier<FlywayAutoConfiguration.StringOrNumberToMigrationVersionConverter> getStringOrNumberMigrationVersionConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FlywayAutoConfiguration.StringOrNumberToMigrationVersionConverter>forFactoryMethod(FlywayAutoConfiguration.class, "stringOrNumberMigrationVersionConverter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(FlywayAutoConfiguration.class).stringOrNumberMigrationVersionConverter());
  }

  /**
   * Get the bean definition for 'stringOrNumberMigrationVersionConverter'.
   */
  public static BeanDefinition getStringOrNumberMigrationVersionConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlywayAutoConfiguration.StringOrNumberToMigrationVersionConverter.class);
    beanDefinition.setInstanceSupplier(getStringOrNumberMigrationVersionConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'flywayDefaultDdlModeProvider'.
   */
  private static BeanInstanceSupplier<FlywaySchemaManagementProvider> getFlywayDefaultDdlModeProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FlywaySchemaManagementProvider>forFactoryMethod(FlywayAutoConfiguration.class, "flywayDefaultDdlModeProvider", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(FlywayAutoConfiguration.class).flywayDefaultDdlModeProvider(args.get(0)));
  }

  /**
   * Get the bean definition for 'flywayDefaultDdlModeProvider'.
   */
  public static BeanDefinition getFlywayDefaultDdlModeProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FlywaySchemaManagementProvider.class);
    beanDefinition.setInstanceSupplier(getFlywayDefaultDdlModeProviderInstanceSupplier());
    return beanDefinition;
  }
}
