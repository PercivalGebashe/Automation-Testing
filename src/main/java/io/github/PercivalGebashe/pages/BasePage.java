package io.github.PercivalGebashe.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;

public class BasePage {

    private final Page page;

    private final Locator inputField;
    private final Locator submitButton;
    private final Locator resultText;

    private final Locator aboutLink;
    private final Locator termsLink;
    private final Locator privacyLink;

    public BasePage(Page page) {
        this.page = page;

        this.inputField = page.locator("input[type='text']");
        this.submitButton = page.locator("button[type='submit']");
        this.resultText = page.locator("#resultDiv");
        this.aboutLink = page.locator("a[href='/about']");
        this.termsLink = page.locator("a[href='/terms']");
        this.privacyLink = page.locator("a[href='/privacy']");
    }

    private void enterNumber(String number) {
        inputField.clear();
        inputField.fill(number);
    }

    private void submit() {
        submitButton.click();
    }

    public void submitNumber(String number) {
        enterNumber(number);
        submit();
    }

    public String getResultText() throws TimeoutError{
        try {
            resultText.waitFor();
            return resultText.textContent();
        }catch (TimeoutError e){
            throw new RuntimeException("Locator not found");
        }


    }


    public boolean isResultVisible() {
        return resultText.isVisible();
    }

    public boolean isInputHighlighted() {
        String classAttr = inputField.getAttribute("style");
        return classAttr != null && classAttr.contains("solid red");
    }

    public void clickAbout() {
        aboutLink.click();
    }

    public void navigateTo(String link){
        switch (link.toLowerCase()){
            case "about":
                clickAbout();
                break;
            case "terms":
                clickTerms();
                break;
            case "privacy":
                clickPrivacy();
                break;
            default:
                throw new RuntimeException(String.format("Page: %s does not exist", link));
        }
    }

    public void clickTerms() {
        termsLink.click();
    }

    public void clickPrivacy() {
        privacyLink.click();
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public String getPageContent() {
        return page.content();
    }

    public void listenForFactorialRequest() {
        page.onRequest(request -> {
            if (request.url().contains("/factorial")) {
                System.out.println("Request Method: " + request.method());
                System.out.println("Request URL: " + request.url());
                System.out.println("Request Post Data: " + request.postData());
            }
        });
    }

    public Locator getResultTextLocator(){
        return resultText;
    }
}
