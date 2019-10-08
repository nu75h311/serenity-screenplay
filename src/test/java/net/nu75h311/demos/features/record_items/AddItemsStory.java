package net.nu75h311.demos.features.record_items;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.contains;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    @Managed
    public WebDriver hisBrowser;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void zehCanBrowseTheWeb() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        hisBrowser = new ChromeDriver(options);
        zeh.can(BrowseTheWeb.with(hisBrowser));
    }

    @After
    public void teardown() {
        if (hisBrowser != null) {
            hisBrowser.quit();
        }
    }

    @Test
    public void should_be_able_to_add_an_item_to_the_todo_list() {

        givenThat(zeh).wasAbleTo(StartWith.anEmptyTodoList());

        when(zeh).attemptsTo(AddATodoItem.called("Feed the cat"));

        then(zeh).should(seeThat(TheTodoItems.displayed(), hasItem("Feed the cat")));
    }

    @Test
    public void should_be_able_to_add_additional_todo_items() {

        givenThat(zeh).wasAbleTo(
                StartWith.aTodoListContaining("Feed the cat","Take out the garbage")
        );

        when(zeh).attemptsTo(AddATodoItem.called("Walk the dog"));

        then(zeh).should(seeThat(TheTodoItems.displayed(),
                contains("Feed the cat","Take out the garbage","Walk the dog")));
    }
}
