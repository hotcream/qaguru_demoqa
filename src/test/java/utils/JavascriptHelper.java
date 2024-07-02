package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JavascriptHelper {

    public static void removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}