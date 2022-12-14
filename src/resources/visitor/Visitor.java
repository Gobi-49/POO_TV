package resources.visitor;

import resources.pages.*;

public interface Visitor {
    void visit(HomepageUnauthenticated homepageUnauthenticated);
    void visit(HomepageAuthenticated homepageAuthenticated);
    void visit(DetailsPage detailsPage);
    void visit(LoginPage loginPage);
    void visit(LogoutPage logoutPage);
    void visit(MoviesPage moviesPage);
    void visit(RegisterPage registerPage);
    void visit(UpgradesPage upgradesPage);

}
