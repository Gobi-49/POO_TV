package resources.data;

import filein.CredentialsInput;

import java.util.Objects;

public class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public Credentials(final String name, final String password,
                       final String accountType, final String country,
                       final String balance) {
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.country = country;
        this.balance = balance;
    }
    public Credentials(final CredentialsInput credentialsInput) {
        name = credentialsInput.getName();
        password = credentialsInput.getPassword();
        accountType = credentialsInput.getAccountType();
        country = credentialsInput.getCountry();
        balance = credentialsInput.getBalance();
    }
    public Credentials(final Credentials credentials) {
        name = credentials.getName();
        password = credentials.getPassword();
        accountType = credentials.getAccountType();
        country = credentials.getCountry();
        balance = credentials.getBalance();
    }
    public final String getName() {
        return name;
    }
    public final void setName(final String name) {
        this.name = name;
    }
    public final String getPassword() {
        return password;
    }
    public final void setPassword(final String password) {
        this.password = password;
    }
    public final String getAccountType() {
        return accountType;
    }
    public final void setAccountType(final String accountType) {
        this.accountType = accountType;
    }
    public final String getCountry() {
        return country;
    }
    public final void setCountry(final String country) {
        this.country = country;
    }
    public final String getBalance() {
        return balance;
    }
    public final void setBalance(final String balance) {
        this.balance = balance;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Credentials that = (Credentials) o;
        return Objects.equals(name, that.name) && Objects.equals(password, that.password);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, password, accountType, country, balance);
    }
}
