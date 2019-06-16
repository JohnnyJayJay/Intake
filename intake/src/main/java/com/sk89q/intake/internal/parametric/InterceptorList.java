package com.sk89q.intake.internal.parametric;

import com.google.common.collect.Lists;
import com.sk89q.intake.parametric.intercept.Interceptor;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * https://github.com/Stupremee
 *
 * @author Stu
 * @since 16.06.19
 */
final class InterceptorList {

  private final List<Entry<?>> entries;

  InterceptorList() {
    this.entries = Lists.newArrayList();
  }

  public <T extends Annotation> void addInterceptor(Class<T> annotation, Interceptor<T> interceptor) {
    entries.add(new Entry<>(annotation, interceptor));
  }


  @SuppressWarnings("unchecked")
  <T extends Annotation> Interceptor<T> getInterceptor(Class<T> annotation) {
    return entries.stream()
        .filter(entry -> entry.type.equals(annotation))
        .findFirst()
        .map(entry -> (Interceptor<T>) entry.interceptor)
        .orElse(null);
  }

  private static final class Entry<T extends Annotation> {

    final Class<T> type;
    final Interceptor<T> interceptor;

    Entry(Class<T> type, Interceptor<T> interceptor) {
      this.type = type;
      this.interceptor = interceptor;
    }
  }

}
