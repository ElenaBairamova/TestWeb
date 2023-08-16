import org.junit.jupiter.api.Test;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


public class ApplicationCardTest {

    @Test
    void positiveTestApplicationCard(){
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Елена Байрамова");
      $("[data-test-id=phone] input").setValue("+79777306807");
       $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Продолжить")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
    @Test
    void positiveTestApplicationCardWithDash(){
        open("http://localhost:9999");

        $("[data-test-id=name] input").setValue("Елена-Елена Байрамова");
        $("[data-test-id=phone] input").setValue("+79777306807");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Продолжить")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}



