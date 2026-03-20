package io.github.PercivalGebashe.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FactorialPage {

    private final Page page;

    private final Locator inputField;
    private final Locator submitButton;
    private final Locator resultText;

    private final Locator aboutLink;
    private final Locator termsLink;
    private final Locator privacyLink;

    public FactorialPage(Page page) {
        this.page = page;

        this.inputField = page.locator("input[type='text']");
        this.submitButton = page.locator("button[type='submit']");
        this.resultText = page.locator("#resultDiv");
        this.aboutLink = page.locator("text=About");
        this.termsLink = page.locator("text=Terms");
        this.privacyLink = page.locator("text=Privacy");
    }

    public void navigate() {
        page.navigate("https://qainterview.pythonanywhere.com/");
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

    public String getResultText() {
        waitForResult();
        return resultText.textContent();
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

    public void navigateTo(String page){
        switch (page.toLowerCase()){
            case "about":
                clickAbout();
                break;
            case "Terms and Conditions":
                clickTerms();
                break;
            case "Privacy":
                clickPrivacy();
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

    private void waitForResult() {
        try {
            resultText.waitFor();
        } catch (Exception e) {
            // fallback for error or server crash cases
        }
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
