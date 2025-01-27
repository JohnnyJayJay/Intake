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

package com.sk89q.intake.completion;

import com.sk89q.intake.CommandException;
import com.sk89q.intake.argument.Namespace;
import java.util.List;

/**
 * Provides a method that can provide tab completion for commands.
 */
public interface CommandCompleter {

  /**
   * Get a list of suggestions based on input.
   *
   * @param arguments the arguments entered up to this point
   * @param locals the locals
   * @return a list of suggestions
   * @throws CommandException thrown if there was a parsing error
   */
  List<String> getSuggestions(String arguments, Namespace locals) throws CommandException;

}
