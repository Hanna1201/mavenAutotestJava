package selenide.object_based_po;

import static com.codeborne.selenide.Selenide.$;

public class MenuPage {

    public void clickRubberDucksInMenu() {
        $("nav#site-menu li.category-1").click();
    }

    public void openSubcategory() {
        $("nav#site-menu li.category-1").hover();
        $("nav#site-menu li.category-2").click();
    }

    public void clickHomeInMenu() {
        $("nav#site-menu li.general-0").click();
    }
}
