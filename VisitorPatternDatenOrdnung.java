
public class Main {
    public static void main(String[] args) {

        Composite root = new Composite("root", 0);
        Composite home = new Composite("home", 1);
        Composite user = new Composite("user", 2);


        Leaf datei1 = new Leaf("datei1", 3, 100);
        Leaf datei2 = new Leaf("datei2", 3, 200);
        Leaf datei3 = new Leaf("datei3", 3, 500);
        user.add(datei1);
        user.add(datei2);
        user.add(datei3);
        home.add(user);
        root.add(home);


        InfoVisitor info = new InfoVisitor();
        PrintVisitor print = new PrintVisitor();

        root.accept(info);
        root.accept(print);
        System.out.println("Durchschnittstiefe: "+ info.averageDepth());
        System.out.println("Branch anzahl: " + info.branchCount());
        System.out.println("Leaf anzahl: " + info.leafCount());

    }

}





class Leaf extends Component {
    private int size;

    public Leaf(String name, int depth, int size) {
        super(name, depth);
        this.size = size;
    }

    public int operation() {
        return size;
    }


    public void print() {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(name + " (" + size + " bytes)");
    }
    public int getSize(){
        return size;
    }
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}

abstract class Component {
    protected String name;
    protected int depth;

    public Component(String name, int depth) {
        this.name = name;
        this.depth = depth;
    }

    public abstract int operation();

    public abstract void print();

    public abstract void accept(Visitor visitor);

    public String getName() {
        return name;
    }

    public int getDepth() {
        return depth;
    }
}

import java.util.ArrayList;
import java.util.List;

class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public Composite(String name, int depth) {
       super (name, depth);
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }
    public int operation() {
        int totalSize = 0;
        for (Component child : children) {
            totalSize += child.operation();
        }
        return totalSize;
    }


    public void print() {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(name + " (" + operation() + " bytes)");
        for (Component child : children) {
            child.print();
        }
    }

    public List<Component> getChildren() {
        return children;
    }



    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
    interface Visitor {
        void visit(Composite composite);
        void visit(Leaf leaf);
    }
class PrintVisitor implements Visitor {
    public void visit(Composite composite) {
        for (int i = 0; i < composite.getDepth(); i++) {
            System.out.print("  ");
        }
        System.out.println(composite.getName());
        for (Component child : composite.getChildren()) {
            child.accept(this);

        }
    }
    public void visit(Leaf leaf) {
        for (int i = 0; i < leaf.getDepth(); i++) {
            System.out.print("  ");
        }
        System.out.println(leaf.getName() + " (" + leaf.getSize() + " bytes)");
    }
}
class InfoVisitor implements Visitor {
    private int depthSum;
    private int leafCount;
    private int branchCount;

    public void visit(Composite composite) {
        depthSum += composite.getDepth();
        branchCount++;
        for (Component child : composite.getChildren()) {
            child.accept(this);
        }
    }

    public void visit(Leaf leaf) {
        leafCount++;
    }

    public double averageDepth() {
        return (double) depthSum / branchCount;
    }

    public int leafCount() {
        return leafCount;
    }

    public int branchCount() {
        return branchCount;
    }
}
