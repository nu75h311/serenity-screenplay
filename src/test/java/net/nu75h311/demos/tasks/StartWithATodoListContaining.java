package net.nu75h311.demos.tasks;

import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class StartWithATodoListContaining implements Task {

    private final List<String> todos;

    public StartWithATodoListContaining(List<String> todos) {
        this.todos = todos;
    }

    @Override
    @Step("{0} starts with a todo list containing #todos")
    public <T extends Actor> void performAs(final T actor) {
        actor.attemptsTo(StartWith.anEmptyTodoList());
        todos.forEach(
                todoItem -> actor.attemptsTo(AddATodoItem.called(todoItem)));
    }
}
