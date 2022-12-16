package resources.pages;

import filein.CredentialsInput;
import resources.data.ActiveUser;

import java.util.ArrayList;
import java.util.Arrays;

public class LogoutPage extends Page {
    @Override
    public boolean acceptChange(String page) {
        ArrayList<String> acceptedPage = new ArrayList<>
                (Arrays.asList("logout", "login", "register"));
        return acceptedPage.contains(page);
    }

    public void logout(CredentialsInput credentialsInput, ActiveUser user) {
    }
}
