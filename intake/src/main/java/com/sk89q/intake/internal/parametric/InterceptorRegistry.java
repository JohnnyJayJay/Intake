package com.sk89q.intake.internal.parametric;

import com.sk89q.intake.interceptor.Interceptor;
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
final class InterceptorRegistry {

  private final List<Entry<?>> entries;

  InterceptorRegistry() {
    this.entries = new ArrayList<>();
  }

  public <T extends Annotation> void add(Class<T> annotation, Interceptor<T> interceptor) {
    entries.add(new Entry<>(annotation, interceptor));
  }

  @SuppressWarnings("unchecked")
  <T extends Annotation> Optional<Interceptor<T>> getInterceptor(Class<T> annotation) {
    return entries.stream()
        .filter(entry -> entry.type.equals(annotation))
        .findFirst()
        .map(entry -> (Interceptor<T>) entry.interceptor);
  }

  private static final class Entry<T extends Annotation> {

    private final Class<T> type;
    private final Interceptor<T> interceptor;

    private Entry(Class<T> type, Interceptor<T> interceptor) {
      this.type = type;
      this.interceptor = interceptor;
    }
  }

}
