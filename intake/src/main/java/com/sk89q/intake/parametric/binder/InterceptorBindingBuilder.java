package com.sk89q.intake.parametric.binder;

import com.sk89q.intake.interceptor.Interceptor;
import java.lang.annotation.Annotation;

/**
 * https://github.com/Stupremee
 *
 * @author Stu
 * @since 16.06.19
 */
public interface InterceptorBindingBuilder<T extends Annotation> {

  /**
   * Binds a {@link com.sk89q.intake.interceptor.Interceptor} to a specific annotation.
   */
  void using(Interceptor<T> interceptor);
}
