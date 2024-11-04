package org.springframework.data.r2dbc.mapping.event;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectFactory__BeanDefinitions;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReactiveAuditingEntityCallback}.
 */
@Generated
public class ReactiveAuditingEntityCallback__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.data.r2dbc.mapping.event.ReactiveAuditingEntityCallback'.
   */
  private static BeanInstanceSupplier<ReactiveAuditingEntityCallback> getReactiveAuditingEntityCallbackInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveAuditingEntityCallback>forConstructor(ObjectFactory.class)
            .withGenerator((registeredBean, args) -> new ReactiveAuditingEntityCallback(args.get(0)));
  }

  /**
   * Get the bean definition for 'reactiveAuditingEntityCallback'.
   */
  public static BeanDefinition getReactiveAuditingEntityCallbackBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveAuditingEntityCallback.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, ObjectFactory__BeanDefinitions.getReactiveAuditingEntityCallbackInnerBeanBeanDefinition());
    beanDefinition.setInstanceSupplier(getReactiveAuditingEntityCallbackInstanceSupplier());
    return beanDefinition;
  }
}
