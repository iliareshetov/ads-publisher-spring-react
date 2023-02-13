package fi.missingprojectfiles.adwize.exceptions;

public class EntryNotFoundException extends RuntimeException {

    public EntryNotFoundException() {
        super("Not found or removed from the system");
    }
}
