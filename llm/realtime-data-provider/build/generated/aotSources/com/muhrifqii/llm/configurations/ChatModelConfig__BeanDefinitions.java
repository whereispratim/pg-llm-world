package com.muhrifqii.llm.configurations;

import com.muhrifqii.llm.services.MessageStoreAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ChatModelConfig}.
 */
@Generated
public class ChatModelConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'chatModelConfig'.
   */
  public static BeanDefinition getChatModelConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatModelConfig.class);
    beanDefinition.setTargetType(ChatModelConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(ChatModelConfig.class);
    beanDefinition.setInstanceSupplier(ChatModelConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'chatClient'.
   */
  private static BeanInstanceSupplier<ChatClient> getChatClientInstanceSupplier() {
    return BeanInstanceSupplier.<ChatClient>forFactoryMethod(ChatModelConfig.class, "chatClient", ChatClient.Builder.class, MessageStoreAdvisor.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ChatModelConfig.class).chatClient(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'chatClient'.
   */
  public static BeanDefinition getChatClientBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatClient.class);
    beanDefinition.setInstanceSupplier(getChatClientInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'restClientCustomizer'.
   */
  private static BeanInstanceSupplier<RestClientCustomizer> getRestClientCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RestClientCustomizer>forFactoryMethod(ChatModelConfig.class, "restClientCustomizer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ChatModelConfig.class).restClientCustomizer());
  }

  /**
   * Get the bean definition for 'restClientCustomizer'.
   */
  public static BeanDefinition getRestClientCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestClientCustomizer.class);
    beanDefinition.setInstanceSupplier(getRestClientCustomizerInstanceSupplier());
    return beanDefinition;
  }
}
