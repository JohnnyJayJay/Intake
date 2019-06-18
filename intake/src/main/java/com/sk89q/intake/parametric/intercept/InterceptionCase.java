package com.sk89q.intake.parametric.intercept;

import com.sk89q.intake.argument.CommandContext;

import java.lang.annotation.Annotation;

/**
 * A class representing a command-specific interception.
 * While {@link Interceptor} can be used across different commands for the same
 * annotation types, this class holds an instance of said annotation for a specific command,
 * binding its instances to single command methods.
 *
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public class InterceptionCase<T extends Annotation> {

  private final Interceptor<T> interceptor;
  private final T annotation;

  /**
   * Constructs a new instance of InterceptionCase.
   *
   * @param interceptor The interceptor to call when intercepting.
   * @param annotation The annotation instance on the command method.
   */
  public InterceptionCase(Interceptor<T> interceptor, T annotation) {
    this.interceptor = interceptor;
    this.annotation = annotation;
  }

  /**
   * Intercepts a command invocation in a specific CommandContext using the interceptor
   * and the annotation this instance holds.
   *
   * @param context The context in which the command will be executed.
   * @return {@code true}, if the invocation may proceed; {@code false},
   *         if the invocation should be aborted.
   */
  public boolean intercept(CommandContext context) {
    return interceptor.intercept(context, annotation);
  }

  /**
   * Returns the annotation instance this InterceptionCase holds.
   *
   * @return The annotation in this InterceptionCase.
   */
  public T getAnnotation() {
    return annotation;
  }

  /**
   * Returns the Interceptor this InterceptionCase holds.
   *
   * @return The Interceptor in this InterceptionCase.
   */
  public Interceptor<T> getInterceptor() {
    return interceptor;
  }
}
