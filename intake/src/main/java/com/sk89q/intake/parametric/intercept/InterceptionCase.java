package com.sk89q.intake.parametric.intercept;

import java.lang.annotation.Annotation;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public class InterceptionCase<T extends Annotation> {

  private final Interceptor<T> interceptor;
  private final T annotation;


  private InterceptionCase(Interceptor<T> interceptor, T annotation) {
    this.interceptor = interceptor;
    this.annotation = annotation;
  }

  public static <T extends Annotation> InterceptionCase<T> create(Interceptor<T> interceptor, T annotation) {
    return new InterceptionCase<T>(interceptor, annotation);
  }

  public T getAnnotation() {
    return annotation;
  }

  public Interceptor<T> getInterceptor() {
    return interceptor;
  }
}
