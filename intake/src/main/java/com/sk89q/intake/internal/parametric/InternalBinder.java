/*
 * Intake, a command processing library
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) Intake team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.intake.internal.parametric;

import static com.google.common.base.Preconditions.checkNotNull;

import com.sk89q.intake.parametric.Key;
import com.sk89q.intake.parametric.binder.Binder;
import com.sk89q.intake.parametric.binder.BindingBuilder;
import com.sk89q.intake.parametric.binder.InterceptorBindingBuilder;
import com.sk89q.intake.parametric.intercept.Interceptor;

import java.lang.annotation.Annotation;

class InternalBinder implements Binder {

  private final BindingList bindings;
  private final InterceptorList interceptorList;

  InternalBinder(BindingList bindings,
      InterceptorList interceptorList) {
    checkNotNull(bindings, "bindings");
    checkNotNull(interceptorList);
    this.interceptorList = interceptorList;
    this.bindings = bindings;
  }

  @Override
  public <T> BindingBuilder<T> bind(Class<T> type) {
    return new InternalBinderBuilder<>(bindings, Key.get(type));
  }

  @Override
  public <T> BindingBuilder<T> bind(Key<T> type) {
    return new InternalBinderBuilder<>(bindings, type);
  }

  @Override
  public <T extends Annotation> InterceptorBindingBuilder<T> interceptWith(Interceptor<T> interceptor) {
    return new InternalInterceptorBindingBuilder<>(interceptorList, interceptor);
  }

}
