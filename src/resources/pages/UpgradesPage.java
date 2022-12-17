package resources.pages;

import resources.MagicNumbers;
import resources.data.ActiveUser;

import java.util.ArrayList;
import java.util.Arrays;

public class UpgradesPage extends Page {
    @Override
    public final boolean acceptChange(final String page) {
        ArrayList<String> acceptedPage = new ArrayList<>(
                Arrays.asList("homepage autentificat", "movies", "upgrades", "logout"));
        return acceptedPage.contains(page);
    }

    @Override
    public final void buyTokens(final ActiveUser activeUser, final int count) {
        int balance = Integer.parseInt(activeUser.getUser().getCredentials().getBalance());
        balance -= count;
        if (balance < 0) {
            error();
            return;
        }
        activeUser.getUser().addTokes(count);
        activeUser.getUser().getCredentials().setBalance(Integer.toString(balance));
    }
    @Override
    public final void buyPremium(final ActiveUser activeUser) {
        int tokens = activeUser.getUser().getTokensCount();
        tokens -= MagicNumbers.PREMIUMCOST;
        if (tokens < 0) {
            error();
            return;
        }
        activeUser.getUser().removeTokes(MagicNumbers.PREMIUMCOST);
        activeUser.getUser().getCredentials().setAccountType("premium");
    }
}
