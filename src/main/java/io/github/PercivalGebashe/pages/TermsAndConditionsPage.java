package io.github.PercivalGebashe.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;

public class TermsAndConditionsPage extends BasePage implements LoadablePage{

    private final Locator home;

    public TermsAndConditionsPage(Page page) {
        super(page);
        this.home = page.locator("a[href='/']");
    }

    public String getBodyText(){
        return home.textContent();
    }

    @Override
    public void waitUntilLoaded() {

    }

    public boolean isLoaded() {
        try {
            home.waitFor();
        }catch (TimeoutError e){
            return false;
        }
        return true;
    }
}
