package se1app.applicationcore.officecomponent;

/**
 * Created by Neak on 04.12.2016.
 *
 */
public class OfficeNotFoundException extends Exception {
    private static final long serialVersionUID = 5234151235599771228L;

    public OfficeNotFoundException(Integer officeNr){
        super("office with nr " + officeNr + " was not found");
    }
}

