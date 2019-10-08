package net.nu75h311.demos.tasks;

import net.nu75h311.demos.ui.TodoMvcApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class StartWithAnEmptyList implements Task {

    TodoMvcApplicationHomePage todoMvcApplicationHomePage;

    @Override
    @Step("{0} starts with an empty todo list")
    public <T extends Actor> void performAs(final T actor) {
        actor.attemptsTo(
                Open.browserOn().the(todoMvcApplicationHomePage));
    }
}
