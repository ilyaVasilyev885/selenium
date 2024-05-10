package org.example.listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;

public class ElementActionListener implements WebDriverListener {

    private static final Logger LOGGER = LogManager.getLogger(ElementActionListener.class);

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        LOGGER.debug(Arrays.toString(keysToSend) + " was typed into " + element.toString());
    }

    @Override
    public void afterClick(WebElement element) {
        LOGGER.debug(element.getTagName()+ " " + element.getText() + " has been clicked.");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        LOGGER.debug("Text: " + result);
    }

}
