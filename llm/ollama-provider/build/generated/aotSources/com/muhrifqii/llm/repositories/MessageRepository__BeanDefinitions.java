package com.muhrifqii.llm.repositories;

import java.lang.Class;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactoryBean;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * Bean definitions for {@link MessageRepository}.
 */
@Generated
public class MessageRepository__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'messageRepository'.
   */
  private static BeanInstanceSupplier<R2dbcRepositoryFactoryBean> getMessageRepositoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<R2dbcRepositoryFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new R2dbcRepositoryFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'messageRepository'.
   */
  public static BeanDefinition getMessageRepositoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(R2dbcRepositoryFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(R2dbcRepositoryFactoryBean.class, MessageRepository.class, MessageEntity.class, String.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "com.muhrifqii.llm.repositories.MessageRepository");
    beanDefinition.getPropertyValues().addPropertyValue("queryLookupStrategyKey", QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND);
    beanDefinition.getPropertyValues().addPropertyValue("lazyInit", false);
    beanDefinition.getPropertyValues().addPropertyValue("namedQueries", new RuntimeBeanReference("r2dbc.named-queries#1"));
    beanDefinition.getPropertyValues().addPropertyValue("repositoryFragments", new RuntimeBeanReference("r2dbc.MessageRepository.fragments#0"));
    beanDefinition.getPropertyValues().addPropertyValue("entityOperations", new RuntimeBeanReference("r2dbcEntityTemplate"));
    beanDefinition.setInstanceSupplier(getMessageRepositoryInstanceSupplier());
    return beanDefinition;
  }
}
