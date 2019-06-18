package com.sk89q.intake.internal.parametric;

import com.sk89q.intake.parametric.intercept.Interceptor;
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

  private final InterceptorList interceptorList;
  private final Interceptor<T> interceptor;

  InternalInterceptorBindingBuilder(InterceptorList interceptorList, Interceptor<T> interceptor) {
    this.interceptorList = interceptorList;
    this.interceptor = interceptor;
  }

  @Override
  public void at(Class<T> annotation) {
    interceptorList.addInterceptor(annotation, interceptor);
  }
}
