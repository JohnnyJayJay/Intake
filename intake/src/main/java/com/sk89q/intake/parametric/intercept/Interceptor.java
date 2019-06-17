package com.sk89q.intake.parametric.intercept;

import com.sk89q.intake.argument.CommandContext;
import java.lang.annotation.Annotation;

/**
 * An interface that can be used to intercept in command invocations based on annotations
 * as an alternative to {@link com.sk89q.intake.parametric.handler.InvokeListener}.
 *
 * The generic type represents the annotation type this interceptor is bound to.
 *
 * @author Stu
 * @since 16.06.19
 */
public interface Interceptor<T extends Annotation> {

  /**
   * Checks if a command should be called.
   *
   * @param context The {@link CommandContext} in which this command should be invoked.
   * @param annotation The annotation the command is annotated with and whose type this interceptor is associated with.
   * @return true if the command should be called, false if the command shouldn't be called
   */
  boolean intercept(CommandContext context, T annotation);

}
