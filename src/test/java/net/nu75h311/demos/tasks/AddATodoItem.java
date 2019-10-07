package net.nu75h311.demos.tasks;

import org.openqa.selenium.Keys;

import net.nu75h311.demos.ui.TodoList;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AddATodoItem implements Task {

    private final String itemName;

    public AddATodoItem(String itemName) {
        this.itemName = itemName;
    }

    public static Task called(String itemName) {
        return Instrumented.instanceOf(AddATodoItem.class)
                .withProperties(itemName);
    }

    @Override
    @Step("{0} adds an item called '#itemName'")
    public <T extends Actor> void performAs(final T actor) {
        actor.attemptsTo(
                Enter.theValue(itemName).into(TodoList.WHAT_NEEDS_TO_BE_DONE)
                .thenHit(Keys.RETURN)
        );
    }
}
