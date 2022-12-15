package resources.data;

import filein.CredentialsInput;

import java.util.Objects;

public class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public Credentials(String name, String password, String accountType, String country, String balance) {
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.country = country;
        this.balance = balance;
    }
    public Credentials(CredentialsInput credentialsInput) {
        name = credentialsInput.getName();
        password = credentialsInput.getPassword();
        accountType = credentialsInput.getAccountType();
        country = credentialsInput.getCountry();
        balance = credentialsInput.getBalance();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(name, that.name) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, accountType, country, balance);
    }
}
