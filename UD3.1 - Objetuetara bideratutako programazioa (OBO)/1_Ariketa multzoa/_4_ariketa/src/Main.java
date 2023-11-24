public class Main {
    public static void main(String[] args) {


        Liburutegia l1 = new Liburutegia();

        if (l1.bikoitiaDa(1450)){
            System.out.println("Sartutako zenbakia bikoitia da.");
        }else {
            System.out.println("Sartutako zenbakia ez bikoitia da.");
        }

        System.out.println("Sartutako zenbakiak "+l1.digituKopurua(7830)+" digitu ditu.");



        if (l1.bostDitu(1)){
            System.out.println("Zenbaki honek 5 digitu baino gehiago ditu.");
        }else {
            System.out.println("Zenbaki honek ez ditu 5 digitu baino gehiago.");
        }

        if (l1.bostDitu(12345)){
            System.out.println("Zenbaki honek 5 digitu baino gehiago ditu.");
        }else {
            System.out.println("Zenbaki honek ez ditu 5 digitu baino gehiago.");
        }

        if (l1.hamarrenMultiploa(10)){
            System.out.println("Sartutako zenbakia hamarren multiploa da.");
        }else {
            System.out.println("Sartutako zenbakia ez da hamarren multiploa.");
        }

        if (l1.hamarrenMultiploa(40521234)){
            System.out.println("Sartutako zenbakia hamarren multiploa da.");
        }else {
            System.out.println("Sartutako zenbakia ez da hamarren multiploa.");
        }


    }
}