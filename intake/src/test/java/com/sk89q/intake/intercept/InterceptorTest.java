package com.sk89q.intake.intercept;

import com.sk89q.intake.Command;
import com.sk89q.intake.CommandException;
import com.sk89q.intake.Intake;
import com.sk89q.intake.InvocationCommandException;
import com.sk89q.intake.argument.CommandContext;
import com.sk89q.intake.argument.Namespace;
import com.sk89q.intake.dispatcher.Dispatcher;
import com.sk89q.intake.dispatcher.SimpleDispatcher;
import com.sk89q.intake.parametric.Injector;
import com.sk89q.intake.parametric.ParametricBuilder;
import com.sk89q.intake.parametric.intercept.Interceptor;
import com.sk89q.intake.util.auth.AuthorizationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public class InterceptorTest {

  private static final String ABORTED_COMMAND_NAME = "abort";
  private static final String EXECUTED_COMMAND_NAME = "execute";

  private Dispatcher dispatcher;
  private boolean executed;

  @Before
  public void setUp() {
    Injector injector = Intake.createInjector();
    injector.install((binder) -> binder.interceptAt(SampleIntercept.class).using(new SampleInterceptor()));
    ParametricBuilder builder = new ParametricBuilder(injector);
    Dispatcher dispatcher = new SimpleDispatcher();
    builder.registerMethodsAsCommands(dispatcher, this);
    this.dispatcher = dispatcher;
    executed = false;
  }

  @Test
  public void testAbortedCommand() {
    this.call(ABORTED_COMMAND_NAME);
    Assert.assertFalse(executed);
  }

  @Test
  public void testExecutedCommand() {
    this.call(EXECUTED_COMMAND_NAME);
    Assert.assertTrue(executed);
  }

  private void call(String command) {
    try {
      dispatcher.call(command, new Namespace(), Collections.singletonList(command));
    } catch (CommandException | InvocationCommandException | AuthorizationException e) {
      Assert.fail("No exception expected");
    }
  }

  @Command(aliases = ABORTED_COMMAND_NAME, desc = "")
  @SampleIntercept(abort = true)
  public void abortedCommand() {
    executed = true;
  }

  @Command(aliases = EXECUTED_COMMAND_NAME, desc = "")
  @SampleIntercept(abort = false)
  public void executedCommand() {
    executed = true;
  }

  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.RUNTIME)
  private @interface SampleIntercept {
    boolean abort();
  }

  private static class SampleInterceptor implements Interceptor<SampleIntercept> {

    @Override
    public boolean intercept(CommandContext context, SampleIntercept annotation) {
      return !annotation.abort();
    }
  }

}
