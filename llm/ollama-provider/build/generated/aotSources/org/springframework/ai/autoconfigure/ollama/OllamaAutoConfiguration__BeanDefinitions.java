package org.springframework.ai.autoconfigure.ollama;

import java.util.List;
import org.springframework.ai.model.function.FunctionCallbackContext;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Bean definitions for {@link OllamaAutoConfiguration}.
 */
@Generated
public class OllamaAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'ollamaAutoConfiguration'.
   */
  public static BeanDefinition getOllamaAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OllamaAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(OllamaAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'ollamaConnectionDetails'.
   */
  private static BeanInstanceSupplier<OllamaAutoConfiguration.PropertiesOllamaConnectionDetails> getOllamaConnectionDetailsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OllamaAutoConfiguration.PropertiesOllamaConnectionDetails>forFactoryMethod(OllamaAutoConfiguration.class, "ollamaConnectionDetails", OllamaConnectionProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(OllamaAutoConfiguration.class).ollamaConnectionDetails(args.get(0)));
  }

  /**
   * Get the bean definition for 'ollamaConnectionDetails'.
   */
  public static BeanDefinition getOllamaConnectionDetailsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OllamaAutoConfiguration.PropertiesOllamaConnectionDetails.class);
    beanDefinition.setInstanceSupplier(getOllamaConnectionDetailsInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'ollamaApi'.
   */
  private static BeanInstanceSupplier<OllamaApi> getOllamaApiInstanceSupplier() {
    return BeanInstanceSupplier.<OllamaApi>forFactoryMethod(OllamaAutoConfiguration.class, "ollamaApi", OllamaConnectionDetails.class, RestClient.Builder.class, WebClient.Builder.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(OllamaAutoConfiguration.class).ollamaApi(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'ollamaApi'.
   */
  public static BeanDefinition getOllamaApiBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OllamaApi.class);
    beanDefinition.setInstanceSupplier(getOllamaApiInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'ollamaChatModel'.
   */
  private static BeanInstanceSupplier<OllamaChatModel> getOllamaChatModelInstanceSupplier() {
    return BeanInstanceSupplier.<OllamaChatModel>forFactoryMethod(OllamaAutoConfiguration.class, "ollamaChatModel", OllamaApi.class, OllamaChatProperties.class, List.class, FunctionCallbackContext.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(OllamaAutoConfiguration.class).ollamaChatModel(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'ollamaChatModel'.
   */
  public static BeanDefinition getOllamaChatModelBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OllamaChatModel.class);
    beanDefinition.setInstanceSupplier(getOllamaChatModelInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'ollamaEmbeddingModel'.
   */
  private static BeanInstanceSupplier<OllamaEmbeddingModel> getOllamaEmbeddingModelInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<OllamaEmbeddingModel>forFactoryMethod(OllamaAutoConfiguration.class, "ollamaEmbeddingModel", OllamaApi.class, OllamaEmbeddingProperties.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(OllamaAutoConfiguration.class).ollamaEmbeddingModel(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'ollamaEmbeddingModel'.
   */
  public static BeanDefinition getOllamaEmbeddingModelBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OllamaEmbeddingModel.class);
    beanDefinition.setInstanceSupplier(getOllamaEmbeddingModelInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springAiFunctionManager'.
   */
  private static BeanInstanceSupplier<FunctionCallbackContext> getSpringAiFunctionManagerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FunctionCallbackContext>forFactoryMethod(OllamaAutoConfiguration.class, "springAiFunctionManager", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(OllamaAutoConfiguration.class).springAiFunctionManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'springAiFunctionManager'.
   */
  public static BeanDefinition getSpringAiFunctionManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FunctionCallbackContext.class);
    beanDefinition.setInstanceSupplier(getSpringAiFunctionManagerInstanceSupplier());
    return beanDefinition;
  }
}
