import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


public class ApplicationCardTest {
    @BeforeEach
    void openSite() {
        open("http://localhost:9999");

    }

    @Test
    void positiveTestApplicationCard() {

        $("[data-test-id=name] input").setValue("Елена Байрамова");
        $("[data-test-id=phone] input").setValue("+79777306807");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Продолжить")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void positiveTestApplicationCardWithDash() {

        $("[data-test-id=name] input").setValue("Елена-Елена Байрамова");
        $("[data-test-id=phone] input").setValue("+79777306807");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Продолжить")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}



