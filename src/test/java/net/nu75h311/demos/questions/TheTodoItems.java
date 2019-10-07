package net.nu75h311.demos.questions;

import java.util.List;

import net.nu75h311.demos.ui.TodoList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheTodoItems implements Question<List<String>> {

    public static Question<List<String>> displayed() {
        return new TheTodoItems();
    }

    @Override
    public List<String> answeredBy(final Actor actor) {
        return Text.of(TodoList.ITEMS)
                .viewedBy(actor)
                .asList();
    }
}
