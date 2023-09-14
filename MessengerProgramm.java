public class Main {
    public static void main(String[] args) {
        Messenger mess = new Messenger();
        Messenger.Nachrichtendienst dienst = mess.new Nachrichtendienst();
        Messenger.Empfaenger Empfanger1 = mess.new Empfaenger();
        Empfanger1.setName("Light Yagami");
        dienst.anmeldungBenutzer(Empfanger1);
        Messenger.Empfaenger Empfanger2 = mess.new Empfaenger();
        Empfanger2.setName("L");
        dienst.anmeldungBenutzer(Empfanger2);


        Messenger.Sender sender1 = mess.new Sender();
        sender1.setName("Will Smith");
        sender1.setNachrichtendienst(dienst);


        Messenger.Sender sender2 = mess.new Sender();

        sender2.setName("Jaden Smith");
        sender2.setNachrichtendienst(dienst);


        Messenger.Nachricht nachricht1 = sender1.NachrichtErstellen(" hello ", "Textnachricht");
        Messenger.Nachricht nachricht2 = sender2.NachrichtErstellen(" Absurdism " , "Textnachricht" );
        Messenger.Nachricht nachricht3 = sender2.NachrichtErstellen(" Das ist eine Nachricht fuer alle", "Textnachricht");

        sender1.send( Empfanger1.getName(), nachricht1);
        sender2.send( Empfanger2.getName(), nachricht2);
        sender1.send(nachricht3);


        System.out.println("message for empfaemger 1");
        Empfanger1.speicherAnzeigen();
        System.out.println("message for empfaemger 2");
        Empfanger2.speicherAnzeigen();
        dienst.abmeldenAllerEmpfaenger();


    }
}



import java.util.HashMap;
public class Messenger {

    public class Nachricht {
        private String Nachrichtentyp;
        private String Inhalt;

        public String getInhalt() {
            return Inhalt;
        }

        public void setInhalt(String inhalt) {
            Inhalt = inhalt;
        }

        public String getNachrichtentyp() {
            return Nachrichtentyp;
        }

        public void setNachrichtentyp(String nachrichtentyp) {
            Nachrichtentyp = nachrichtentyp;
        }
    }

    public class Nachrichtendienst  {
        private  HashMap<String, Empfaenger> empfaengerMap = new HashMap<>();
        private HashMap<String, Sender> SenderMap = new HashMap<String, Sender>();
        private Sender Sender;

        public void abmeldenAllerEmpfaenger() {
            empfaengerMap.values().clear();
        }




        public void Sender (Sender sender) {
            SenderMap.put(sender.getName(), sender);

        }
        public void anmeldungBenutzer(Empfaenger empfaenger) {
            empfaengerMap.put(empfaenger.getName(), empfaenger);
        }

        public void abmeldungBenutzer(String Name) {
            empfaengerMap.remove(Name);
        }

        public void Uebergabe(String Name, Nachricht n) {
            Empfaenger empfaenger = empfaengerMap.get(Name);
            if (empfaenger != null) {
                empfaenger.erhalteneNachricht(n);
            }
        }
        public void UebergabeAnAlle(Nachricht n){
            for (Empfaenger s : (empfaengerMap.values().toArray(new Empfaenger[0]))) {

               s.erhalteneNachricht(n);
            }


        }
    }



    public class Empfaenger {
        private String Name;
        private int ID;
        public Nachricht[] speicher = new Nachricht[20];

        Sender sender = new Sender();
        public void speicherAnzeigen() {
            for (int i = 0; i < speicher.length; i++) {
                if (speicher[i] != null) {
                    System.out.println("Inhalt = " + speicher[i].Inhalt + ", Nachrichtentyp = " + speicher[i].Nachrichtentyp + ", Empfänger = " + Name);

                }
            }
        }

        public void erhalteneNachricht(Nachricht n ) {


            for (int i = 0; i < speicher.length; i++) {
                if (speicher[i] == null) {
                    speicher[i] = n;
                    break;
                }
            }
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }


    }

    public class Sender {
        private String Name;

        private Nachricht N;
        private int ID;
        private Nachrichtendienst Nachrichtendienst;


        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public void send(String Name, Nachricht n) {
            getNachrichtendienst().Uebergabe(Name, n);
        }

        public void send(Nachricht n) {
            getNachrichtendienst().UebergabeAnAlle(n);
        }

        public Nachricht NachrichtErstellen(String Inhalt, String Nachrichtentyp) {
            Nachricht neu = new Nachricht();
            neu.setInhalt(Inhalt + " : Nachricht  von " + this.getName() );
            neu.setNachrichtentyp(Nachrichtentyp);
            return neu;
        }

        public Messenger.Nachrichtendienst getNachrichtendienst() {
            return Nachrichtendienst;
        }

        public void setNachrichtendienst(Messenger.Nachrichtendienst nachrichtendienst) {


            Nachrichtendienst = nachrichtendienst;

        }

    }}
