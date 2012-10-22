package edu.chl.dat076.foodfeed.model.flash;

/**
 * Class for use with Spring flash attributes. Provides a way to show a message
 * after a redirect in a form submission.
 */
public class FlashMessage {

    private final String message;
    private final FlashType type;

    public FlashMessage(String message, FlashType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public FlashType getType() {
        return type;
    }
}
