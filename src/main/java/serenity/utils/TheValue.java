package serenity.utils;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.QuestionWithDefinedSubject;

//This is not supported in the 2.0.39 version so I just copy the code from
//https://github.com/serenity-bdd/serenity-core/blob/v2.0.89/serenity-screenplay/src/main/java/net/serenitybdd/screenplay/questions/TheValue.java
public class TheValue {
    public static <ANSWER> Question<ANSWER> of(ANSWER value) {
        return actor -> value;
    }

    public static <ANSWER> Question<ANSWER> of(String subject, ANSWER value) {
        return new QuestionWithDefinedSubject<>(of(value), subject);
    }
}
