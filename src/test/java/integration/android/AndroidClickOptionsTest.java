package integration.android;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.appium.AppiumClickOptions.doubleTap;
import static com.codeborne.selenide.appium.AppiumClickOptions.longPress;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.AppiumClickOptions.tapWithOffset;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AndroidClickOptionsTest extends BaseApiDemosTest {
  @BeforeEach
  void setUp() {
    closeWebDriver();
    SelenideAppium.launchApp();
  }

  @Test
  void testAndroidTap()  {
    $(AppiumBy.xpath(".//*[@text='Views']")).click(tap());
    $(AppiumBy.xpath(".//*[@text='Animation']")).shouldHave(visible);
  }

  @Test
  void testAndroidTapWithOffset()  {
    $(AppiumBy.xpath(".//*[@text='Views']")).click(tapWithOffset(0, -200)); //Find view but click Text
    $(AppiumBy.xpath(".//*[@text='KeyEventText']")).shouldHave(visible);
  }

  @Test
  void testAndroidLongPress() {
    $(AppiumBy.xpath(".//*[@text='Views']")).click();
    $(AppiumBy.xpath(".//*[@text='Expandable Lists']")).click();
    $(AppiumBy.xpath(".//*[@text='1. Custom Adapter']")).click();
    $(AppiumBy.xpath(".//*[@text='People Names']")).click(longPress());
    $(AppiumBy.xpath(".//*[@text='Sample menu']")).shouldHave(visible);
  }

  @Test
  void testAndroidDoubleTap() {
    $(AppiumBy.xpath(".//*[@text='Preference']")).click();
    $(AppiumBy.xpath(".//*[@text='1. Preferences from XML']")).click();
    $(AppiumBy.xpath(".//android.widget.CheckBox")).click(doubleTap());
    $(AppiumBy.xpath(".//android.widget.CheckBox"))
      .shouldHave(Condition.attribute("checked", "false"));
  }

}
