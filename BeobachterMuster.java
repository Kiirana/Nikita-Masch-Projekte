import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Resource resource = null;
        ArrayList<Observer> observers = new ArrayList<Observer>();

        while (true) {
            System.out.println("-----------------------");
            System.out.println("1. Resource erstellen");
            System.out.println("2. Observer registrieren");
            System.out.println("3. Observer abmelden");
            System.out.println("4. Ressourcenstatus abfragen");
            System.out.println("5. Ressourcenstatus setzen");
            System.out.println("6. Beenden");
            System.out.println("-----------------------");
            System.out.println("Eingabe: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Ressourcentypen eingeben (1 für Ressourcentyp Apfel und 2 für Ressourcentyp Birne): ");
                int type = scanner.nextInt();
                System.out.println("Ressourcenstatus eingeben:");
                String state = scanner.next();
                resource = ResourceFactory.createResource(type, state);
                if (resource != null) {
                    System.out.println("Resource erstellt mit dem Status: " + state);
                } else {
                    System.out.println("Ressourcentyp ungültig!");
                }
            } else if (choice == 2) {
                if (resource == null) {
                    System.out.println("Erstelle zuerst eine Ressource!");
                    continue;
                }
                System.out.println("Observer namen eingeben:");
                String observerName = scanner.next();
                if(observerName!=null){
                    Observer observer = new ObserverX(resource,observerName);
                    observers.add(observer);
                    System.out.println("Observer " + observerName + " registriert.");
                }
                else {
                    System.out.println("ObserverName ungültig");
                }
            } else if (choice == 3) {
                if (resource == null) {
                    System.out.println("Erstelle erst eine Ressource!");
                    continue;
                }
                System.out.println("Observernamen eingeben:");
                String observerName = scanner.next();
                for (Observer observer : observers) {
                    if (observer.getName().contains(observerName)) {
                        resource.removeObserver(observer);
                        System.out.println("Observer " + observerName + " abgemeldet.");
                        break;
                    }
                }
            } else if (choice == 4) {
                if (resource == null) {
                    System.out.println("Erstelle erst eine Ressource!");
                    continue;
                }
                System.out.println("Resource state: " + resource.getState());
            } else if (choice == 5) {
                if (resource == null) {
                    System.out.println("Erstelle erst eine Ressource!");
                    continue;
                }
                System.out.println("Gebe neuen Ressourcentyp an:");
                String state = scanner.next();
                resource.setState(state);
                System.out.println("Ressourcenstatus gesetzt zu: " + state);
            } else if (choice == 6) {
                System.out.println("Beenden");
                break;
            } else {
                System.out.println("Eingabe ungültig, gültige Eingaben sind 1-6!");
            }
        }
        scanner.close();
    }
}

class ResourceFactory {
    public static Resource createResource(int type, String state) {
        if (type==1) {
            return new ResourceType1(state);
        } else if (type==2) {
            return new ResourceType2(state);
        } else {
            return null;
        }
    }
}


interface Observer {
    public void update();
    public String getName();
}


class ObserverX implements Observer {
    private Resource resource;
     private String  name;

    public ObserverX(Resource resource, String name) {
        this.resource = resource;
        this.name=name;
        resource.registerObserver(this);
    }

    public void update() {
        System.out.println("Observer"+name+": Resource state is now: " + resource.getState());
    }

    public String getName(){
        return name;
    }
}


import java.util.ArrayList;

abstract class Resource {
    protected ArrayList<Observer> observers = new ArrayList<Observer>();
    protected String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}


class ResourceType1 extends Resource {
    public ResourceType1(String state) {
        this.state = state;
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
