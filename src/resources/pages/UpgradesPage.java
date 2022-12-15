package resources.pages;

import resources.data.ActiveUser;
import resources.visitor.Visitable;
import resources.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;

public class UpgradesPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("homepage autentificat", "movies", "upgrades", "logout"));
        return acceptedPage.contains(page);
    }

    @Override
    public void buyTokens(ActiveUser activeUser, int count) {
        int balance = Integer.parseInt(activeUser.getUser().getCredentials().getBalance());
        balance -= count;
        if(balance < 0) {
            error();
            return;
        }
        activeUser.getUser().addTokes(count);
        activeUser.getUser().getCredentials().setBalance(Integer.toString(balance));
    }
    @Override
    public void buyPremium(ActiveUser activeUser) {
        int tokens = activeUser.getUser().getTokensCount();
        tokens -= 10;
        if(tokens < 0) {
            error();
            return;
        }
        activeUser.getUser().removeTokes(10);
        activeUser.getUser().getCredentials().setAccountType("premium");
    }
}
