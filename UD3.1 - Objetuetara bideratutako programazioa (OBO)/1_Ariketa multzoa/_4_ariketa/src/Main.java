public class Main {
    public static void main(String[] args) {



        if (Liburutegia.bikoitiaDa(1450)){
            System.out.println("Sartutako zenbakia bikoitia da.");
        }else {
            System.out.println("Sartutako zenbakia ez bikoitia da.");
        }

        System.out.println("Sartutako zenbakiak "+Liburutegia.digituKopurua(7830)+" digitu ditu.");



        if (Liburutegia.bostDitu(1)){
            System.out.println("Zenbaki honek 5 digitu baino gehiago ditu.");
        }else {
            System.out.println("Zenbaki honek ez ditu 5 digitu baino gehiago.");
        }

        if (Liburutegia.bostDitu(12345)){
            System.out.println("Zenbaki honek 5 digitu baino gehiago ditu.");
        }else {
            System.out.println("Zenbaki honek ez ditu 5 digitu baino gehiago.");
        }

        if (Liburutegia.hamarrenMultiploa(10)){
            System.out.println("Sartutako zenbakia hamarren multiploa da.");
        }else {
            System.out.println("Sartutako zenbakia ez da hamarren multiploa.");
        }

        if (Liburutegia.hamarrenMultiploa(40521234)){
            System.out.println("Sartutako zenbakia hamarren multiploa da.");
        }else {
            System.out.println("Sartutako zenbakia ez da hamarren multiploa.");
        }


    }
}