package org.springframework.ai.autoconfigure.chat.client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChatClientAutoConfiguration}.
 */
@Generated
public class ChatClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'chatClientAutoConfiguration'.
   */
  public static BeanDefinition getChatClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(ChatClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'chatClientBuilderConfigurer'.
   */
  private static BeanInstanceSupplier<ChatClientBuilderConfigurer> getChatClientBuilderConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ChatClientBuilderConfigurer>forFactoryMethod(ChatClientAutoConfiguration.class, "chatClientBuilderConfigurer", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ChatClientAutoConfiguration.class).chatClientBuilderConfigurer(args.get(0)));
  }

  /**
   * Get the bean definition for 'chatClientBuilderConfigurer'.
   */
  public static BeanDefinition getChatClientBuilderConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatClientBuilderConfigurer.class);
    beanDefinition.setInstanceSupplier(getChatClientBuilderConfigurerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'chatClientBuilder'.
   */
  private static BeanInstanceSupplier<ChatClient.Builder> getChatClientBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<ChatClient.Builder>forFactoryMethod(ChatClientAutoConfiguration.class, "chatClientBuilder", ChatClientBuilderConfigurer.class, ChatModel.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ChatClientAutoConfiguration.class).chatClientBuilder(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'chatClientBuilder'.
   */
  public static BeanDefinition getChatClientBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatClient.Builder.class);
    beanDefinition.setScope("prototype");
    beanDefinition.setInstanceSupplier(getChatClientBuilderInstanceSupplier());
    return beanDefinition;
  }
}
