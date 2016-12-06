package se1app.applicationcore.accountcomponent;

import org.springframework.beans.factory.annotation.Autowired;
import se1app.applicationcore.util.AccountNumberType;

/**
 * Created by Neak on 04.12.2016.
 */


/*
1. Die Kontokomponente bietet in Ihrer Schnittstelle KontoKomponenteInterface eine
Operation "überweise(quellKontonummer, zielKontonummer, betrag)" an.
Diese Operation wird in der KontoUseCases-Klasse wie folgt implementiert (siehe auch Innensicht unten):
a. Mit Hilfe des KontoRepository werden die Konto-Objekte (Quell- und Zielkonto)
gesucht. Das Format der Kontonummern ist Ihnen freigestellt; sinnvoll ist es, einen
eigenen Datentyp zu definieren (KontoNrTyp).
b. Der Betrag wird vom Quellkonto abgebucht (Methode "quellkonto.buche(-betrag)").
c. Der Betrag wird auf das Zielkonto gebucht (Methode "zielkonto.buche(betrag)").
Hinweise:
• Die buche()-Methode legt dabei eine neue Buchungsposition an (um die Buchung zu
vermerken).
• Der Gesamtkontostand (kontoStand-Attribut in der Klasse Konto) soll durch Iteration
über die Buchungspositionen berechnet werden.
Optional:
• Optional können Sie die Fehlerfälle KontoNichtGedecktException und
KontoNichtGefundenException implementieren. */

public class AccountUseCase {

    @Autowired
    private AccountNumberType accountNumberType;

    @Autowired
    private AccountRepository accountRepository;

    private AccountComponentInterface accountComponentInterface;

    public void transfer(Integer sour, Integer tar, Integer mon) throws AccountNotFoundException, AccountIsLowOnMoneyException {
        accountComponentInterface = new AccountComponent(accountRepository);
        accountComponentInterface.transferMoney(sour, tar, mon);
    }



}
