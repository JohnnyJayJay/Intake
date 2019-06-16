package com.sk89q.intake.internal.parametric;

import com.sk89q.intake.interceptor.Interceptor;
import com.sk89q.intake.parametric.binder.InterceptorBindingBuilder;
import java.lang.annotation.Annotation;

/**
 * https://github.com/Stupremee
 *
 * @author Stu
 * @since 16.06.19
 */
final class InternalInterceptorBindingBuilder<T extends Annotation> implements
    InterceptorBindingBuilder<T> {

  private final InterceptorRegistry interceptorRegistry;
  private final Class<T> annotation;

  InternalInterceptorBindingBuilder(InterceptorRegistry interceptorRegistry, Class<T> annotation) {
    this.interceptorRegistry = interceptorRegistry;
    this.annotation = annotation;
  }

  @Override
  public void using(Interceptor<T> interceptor) {
    interceptorRegistry.add(annotation, interceptor);
  }
}
