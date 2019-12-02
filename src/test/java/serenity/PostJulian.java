package serenity;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Post;

import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostJulian extends RestInteraction {

    private final String resource;

    public PostJulian(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().post(as(actor).resolve(resource));
    }

    public static Post to(String resource) {
        return instrumented(Post.class, resource);
    }
}
