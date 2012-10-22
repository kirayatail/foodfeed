package edu.chl.dat076.foodfeed.model.flash;

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
