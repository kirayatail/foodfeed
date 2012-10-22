package edu.chl.dat076.foodfeed.model.flash;

/**
 * Enum describing the type of a FlashMessage.
 */
public enum FlashType {

    INFO("Information", "info"),
    WARNING("Warning", "warning"),
    ERROR("Error", "error");
    private String name;
    private String cssClass;

    private FlashType(String name, String cssClass) {
        this.name = name;
        this.cssClass = cssClass;
    }

    public String getName() {
        return name;
    }

    public String getCssClass() {
        return cssClass;
    }
}