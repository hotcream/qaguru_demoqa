package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        String dayLocator = ".react-datepicker__day--0" + day;
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(dayLocator).click();
    }
}