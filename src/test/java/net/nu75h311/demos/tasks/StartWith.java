package net.nu75h311.demos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.google.common.collect.Lists;

import net.serenitybdd.core.steps.Instrumented;

public class StartWith {

    public static StartWithAnEmptyList anEmptyTodoList() {
        return instrumented(StartWithAnEmptyList.class);
    }

    public static StartWithATodoListContaining aTodoListContaining(String... todos) {
        return Instrumented.instanceOf(StartWithATodoListContaining.class)
                .withProperties(Lists.newArrayList(todos));
    }
}
