package resources.visitor;

public interface Visitable {
    void accept(Visitor v);
}
