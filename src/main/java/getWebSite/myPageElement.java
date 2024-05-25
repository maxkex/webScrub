package getWebSite;
public class myPageElement {
    String fieldName;
    String extractedValue;
    ActionType actionType;
    SelectorType selectorType;
    String selector;
    
    public enum ActionType {
        CLICK,
        GETTEXT
    }
    public enum SelectorType {
        ID,
        NAME,
        CLASS_NAME,
        TAG_NAME,
        LINK_TEXT,
        PARTIAL_LINK_TEXT,
        CSS_SELECTOR,
        XPATH
    }

    public myPageElement(String fieldName, String extractedValue, ActionType actionType, SelectorType selectorType, String selector) {
        this.fieldName = fieldName;
        this.extractedValue = extractedValue;
        this.actionType = actionType;
        this.selectorType = selectorType;
        this.selector = selector;
    }
}
