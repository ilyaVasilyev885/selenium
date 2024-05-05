package org.example.listeners;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;

public class ElementActionListener implements WebDriverListener {

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println(Arrays.toString(keysToSend) + " was typed into " + element.toString());
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println(element.getTagName()+ " " + element.getText() + " has been clicked.");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println("Text: " + result);
    }

}
