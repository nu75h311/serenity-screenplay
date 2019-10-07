package net.nu75h311.demos.features.record_items;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.CoreMatchers.hasItem;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.nu75h311.demos.questions.TheTodoItems;
import net.nu75h311.demos.tasks.AddATodoItem;
import net.nu75h311.demos.tasks.StartWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class AddItemsStory {

    Actor zeh = Actor.named("Zé");

    @Managed(uniqueSession = true)
    public WebDriver hisBrowser;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void zehCanBrowseTheWeb() {
        hisBrowser = new ChromeDriver();
        zeh.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void should_be_able_to_add_an_item_to_the_todo_list() {

        givenThat(zeh).wasAbleTo(StartWith.anEmptyTodoList());

        when(zeh).attemptsTo(AddATodoItem.called("Feed the cat"));

        then(zeh).should(seeThat(TheTodoItems.displayed(), hasItem("Feed the cat")));
    }
}
