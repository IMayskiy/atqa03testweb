package ru.netology.webselenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Selenide.open;

class WebOrderTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTest () {
        SelenideElement form = $("[class]");
        form.$("[data-test-id=name] input").setValue("Петров Олег");
        form.$("[data-test-id=phone] input").setValue("+79091234567");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
//        Thread.sleep(500);
    }
}