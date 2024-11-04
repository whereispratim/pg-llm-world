package org.springframework.cloud.function.context.config;

import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.function.context.DefaultMessageRoutingHandler;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.FunctionProperties;
import org.springframework.cloud.function.context.FunctionRegistry;
import org.springframework.cloud.function.context.MessageRoutingCallback;
import org.springframework.cloud.function.core.FunctionInvocationHelper;
import org.springframework.cloud.function.json.JsonMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Bean definitions for {@link ContextFunctionCatalogAutoConfiguration}.
 */
@Generated
public class ContextFunctionCatalogAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'contextFunctionCatalogAutoConfiguration'.
   */
  public static BeanDefinition getContextFunctionCatalogAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ContextFunctionCatalogAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ContextFunctionCatalogAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'functionCatalog'.
   */
  private static BeanInstanceSupplier<FunctionRegistry> getFunctionCatalogInstanceSupplier() {
    return BeanInstanceSupplier.<FunctionRegistry>forFactoryMethod(ContextFunctionCatalogAutoConfiguration.class, "functionCatalog", List.class, JsonMapper.class, ConfigurableApplicationContext.class, FunctionInvocationHelper.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ContextFunctionCatalogAutoConfiguration.class).functionCatalog(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'functionCatalog'.
   */
  public static BeanDefinition getFunctionCatalogBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FunctionRegistry.class);
    beanDefinition.setInstanceSupplier(getFunctionCatalogInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'functionRouter'.
   */
  private static BeanInstanceSupplier<RoutingFunction> getFunctionRouterInstanceSupplier() {
    return BeanInstanceSupplier.<RoutingFunction>forFactoryMethod(ContextFunctionCatalogAutoConfiguration.class, "functionRouter", FunctionCatalog.class, FunctionProperties.class, BeanFactory.class, MessageRoutingCallback.class, DefaultMessageRoutingHandler.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ContextFunctionCatalogAutoConfiguration.class).functionRouter(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'functionRouter'.
   */
  public static BeanDefinition getFunctionRouterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RoutingFunction.class);
    beanDefinition.setInstanceSupplier(getFunctionRouterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link ContextFunctionCatalogAutoConfiguration.PlainFunctionScanConfiguration}.
   */
  @Generated
  public static class PlainFunctionScanConfiguration {
    /**
     * Get the bean definition for 'plainFunctionScanConfiguration'.
     */
    public static BeanDefinition getPlainFunctionScanConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ContextFunctionCatalogAutoConfiguration.PlainFunctionScanConfiguration.class);
      beanDefinition.setInstanceSupplier(ContextFunctionCatalogAutoConfiguration.PlainFunctionScanConfiguration::new);
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link ContextFunctionCatalogAutoConfiguration.JsonMapperConfiguration}.
   */
  @Generated
  public static class JsonMapperConfiguration {
    /**
     * Get the bean definition for 'jsonMapperConfiguration'.
     */
    public static BeanDefinition getJsonMapperConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(ContextFunctionCatalogAutoConfiguration.JsonMapperConfiguration.class);
      beanDefinition.setInstanceSupplier(ContextFunctionCatalogAutoConfiguration.JsonMapperConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'jsonMapper'.
     */
    private static BeanInstanceSupplier<JsonMapper> getJsonMapperInstanceSupplier() {
      return BeanInstanceSupplier.<JsonMapper>forFactoryMethod(ContextFunctionCatalogAutoConfiguration.JsonMapperConfiguration.class, "jsonMapper", ApplicationContext.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ContextFunctionCatalogAutoConfiguration.JsonMapperConfiguration.class).jsonMapper(args.get(0)));
    }

    /**
     * Get the bean definition for 'jsonMapper'.
     */
    public static BeanDefinition getJsonMapperBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(JsonMapper.class);
      beanDefinition.setInstanceSupplier(getJsonMapperInstanceSupplier());
      return beanDefinition;
    }
  }
}
