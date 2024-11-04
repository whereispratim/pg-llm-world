package org.springframework.data.auditing;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.mapping.context.MappingContext;

/**
 * Bean definitions for {@link ReactiveIsNewAwareAuditingHandler}.
 */
@Generated
public class ReactiveIsNewAwareAuditingHandler__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'r2dbcAuditingHandler'.
   */
  private static BeanInstanceSupplier<ReactiveIsNewAwareAuditingHandler> getRdbcAuditingHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReactiveIsNewAwareAuditingHandler>forFactoryMethod(ReactiveIsNewAwareAuditingHandler.class, "from", MappingContext.class)
            .withGenerator((registeredBean, args) -> ReactiveIsNewAwareAuditingHandler.from(args.get(0, MappingContext.class)));
  }

  /**
   * Get the bean definition for 'r2dbcAuditingHandler'.
   */
  public static BeanDefinition getRdbcAuditingHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReactiveIsNewAwareAuditingHandler.class);
    beanDefinition.setTargetType(ReactiveIsNewAwareAuditingHandler.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, new RuntimeBeanReference("r2dbcMappingContext"));
    beanDefinition.getPropertyValues().addPropertyValue("dateTimeForNow", true);
    beanDefinition.getPropertyValues().addPropertyValue("modifyOnCreation", true);
    beanDefinition.getPropertyValues().addPropertyValue("dateTimeProvider", CurrentDateTimeProvider.INSTANCE);
    beanDefinition.setInstanceSupplier(getRdbcAuditingHandlerInstanceSupplier());
    return beanDefinition;
  }
}
