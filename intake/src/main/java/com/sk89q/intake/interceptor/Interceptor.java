package com.sk89q.intake.interceptor;

import com.sk89q.intake.argument.Namespace;
import java.lang.annotation.Annotation;

/**
 * https://github.com/Stupremee
 *
 * @author Stu
 * @since 16.06.19
 */
public interface Interceptor<T extends Annotation> {

  /**
   * Checks if a command should be called.
   *
   * @return true if the command should be called, false if the command shouldn't be called
   */
  boolean check(Namespace namespace, T annotation);

}
