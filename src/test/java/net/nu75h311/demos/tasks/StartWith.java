package net.nu75h311.demos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.nu75h311.demos.ui.TodoMvcApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class StartWith implements Task {

    TodoMvcApplicationHomePage todoMvcApplicationHomePage;

    public static StartWith anEmptyTodoList() {
        return instrumented(StartWith.class);
    }

    @Override
    @Step("{0} starts with an empty todo list")
    public <T extends Actor> void performAs(final T actor) {
        actor.attemptsTo(
                Open.browserOn().the(todoMvcApplicationHomePage));
    }
}
