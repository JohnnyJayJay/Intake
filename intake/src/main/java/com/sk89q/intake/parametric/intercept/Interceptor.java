package com.sk89q.intake.parametric.intercept;

import com.sk89q.intake.argument.CommandContext;
import com.sk89q.intake.argument.Namespace;
import java.lang.annotation.Annotation;

/**
 * https://github.com/Stupremee
 *
 * @author Stu
 * @since 16.06.19
 */
// TODO: 16.06.2019 docs
public interface Interceptor<T extends Annotation> {

  /**
   * Checks if a command should be called.
   *
   * @return true if the command should be called, false if the command shouldn't be called
   */
  boolean intercept(CommandContext context, T annotation);

}
