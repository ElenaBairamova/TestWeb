import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class NegativeApplicationCardTest {
    @Test
    void testApplicationCardFieldBlank() {
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue(" ");
        $("[data-test-id=phone] input").setValue("+79777306807");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
    @Test
    void testApplicationCardNameEnglish() {
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Elena Popova");
        $("[data-test-id=phone] input").setValue("+79777306807");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Продолжить")).click();
        $(".input_theme_alfa-on-white.input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
    @Test
    void testApplicationCardPhoneLessNumber() {
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Елена Байрамова");
        $("[data-test-id=phone] input").setValue("+797773068077");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Продолжить")).click();
        $(".input_theme_alfa-on-white.input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

}