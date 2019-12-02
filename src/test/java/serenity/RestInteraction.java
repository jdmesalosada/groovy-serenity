package serenity;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class RestInteraction implements Interaction {

    List<Function<RequestSpecification, RequestSpecification>> restConfigurations = new ArrayList<>();

    public RestInteraction con(RestQueryFunction restConfiguration) {
        this.restConfigurations.add(restConfiguration);
        return this;
    }

    public RestInteraction con(List<RestQueryFunction> restConfigurations) {
        this.restConfigurations.addAll(restConfigurations);
        return this;
    }

    protected RequestSpecification rest() {
        RequestSpecification requestSpecification = SerenityRest.given();
        for(Function<RequestSpecification, RequestSpecification> restConfiguration : restConfigurations) {
            requestSpecification = restConfiguration.apply(requestSpecification);
        }
        return requestSpecification;
    }
}