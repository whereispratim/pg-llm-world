package org.springframework.cloud.function.cloudevent;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.function.core.FunctionInvocationHelper;
import org.springframework.core.ResolvableType;
import org.springframework.messaging.Message;

/**
 * Bean definitions for {@link CloudEventsFunctionExtensionConfiguration}.
 */
@Generated
public class CloudEventsFunctionExtensionConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'cloudEventsFunctionExtensionConfiguration'.
   */
  public static BeanDefinition getCloudEventsFunctionExtensionConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CloudEventsFunctionExtensionConfiguration.class);
    beanDefinition.setInstanceSupplier(CloudEventsFunctionExtensionConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nativeFunctionInvocationHelper'.
   */
  private static BeanInstanceSupplier<FunctionInvocationHelper> getNativeFunctionInvocationHelperInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FunctionInvocationHelper>forFactoryMethod(CloudEventsFunctionExtensionConfiguration.class, "nativeFunctionInvocationHelper", CloudEventHeaderEnricher.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CloudEventsFunctionExtensionConfiguration.class).nativeFunctionInvocationHelper(args.get(0)));
  }

  /**
   * Get the bean definition for 'nativeFunctionInvocationHelper'.
   */
  public static BeanDefinition getNativeFunctionInvocationHelperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FunctionInvocationHelper.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(FunctionInvocationHelper.class, ResolvableType.forClass(Message.class)));
    beanDefinition.setInstanceSupplier(getNativeFunctionInvocationHelperInstanceSupplier());
    return beanDefinition;
  }
}
