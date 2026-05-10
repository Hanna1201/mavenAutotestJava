package selenide.object_based_po;

import static com.codeborne.selenide.Selenide.$;

public class SubCategoryPage {

    public String getSubcategoryText() {
        return $("h1.title").getText();
    }
}

