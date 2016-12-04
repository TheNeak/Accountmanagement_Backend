package se1app.applicationcore.util;

import java.io.Serializable;

/**
 * Created by Neak on 04.12.2016.
 */
public class AccountNumberType implements Serializable {
    private String accountNr;

    /**
     * ^                 # start-of-string
     * (?=.*[0-9])       # a digit must occur at least once
     * (?=\S+$)          # no whitespace allowed in the entire string
     * .{8,}             # anything, at least eight places though
     * $                 # end-of-string
     */
    private static final String ACCOUNTNR_PATTERN =
            "^(.*[0-9]).(?=\\S+$).{8,}$";

    public AccountNumberType(String accountNr) {
        if (!isValidPassword(accountNr)) {
            // Wir verhindern, dass ein ungültiges Objekt erzeugt werden kann
            throw new IllegalArgumentException("Keine gültige Kontonr:" + accountNr);
        }
        this.accountNr = accountNr;
    }

    public String getAccountNr() {
        return accountNr;
    }

    // Mit Hilfe der statischen Methode kann vor Instanziierung eines Email-Objekts geprüft werden,
    // ob eine gültige Email-Adresse vorliegt. Dies ist an vielen Stellen im Code einer Applikation
    // nützlich, bspw. in der GUI und in der Geschäftslogik. Durch die Definition des Datentyps
    // ist diese Prüfung an dieser Stelle zentralisiert.
    public static boolean isValidPassword(String accountNr) {
        return accountNr.matches(ACCOUNTNR_PATTERN);
    }
}
