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
  private final Class<T> annotation;

  InternalInterceptorBindingBuilder(InterceptorList interceptorList, Class<T> annotation) {
    this.interceptorList = interceptorList;
    this.annotation = annotation;
  }

  @Override
  public void using(Interceptor<T> interceptor) {
    interceptorList.addInterceptor(annotation, interceptor);
  }
}
