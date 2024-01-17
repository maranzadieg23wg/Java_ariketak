public class Loro extends Txori{


    private char zonaldea;
    private String kolorea;
    public Loro(char sexua, int adina, char zonaldea, String kolorea) {
        super(sexua, adina);
        this.zonaldea=zonaldea;
        this.kolorea=kolorea;
    }


    void nongoaZara(){
        if (this.zonaldea == 'I'){
            System.out.println("Iparraldea");
        } else if (this.zonaldea =='H') {
            System.out.println("Hegoaldea");
        } else if (this.zonaldea == 'E') {
            System.out.println("Ekialdea");
        }else {
            System.out.println("Mendebaldea");
        }
    }

    void setZonaldea(char zonaldea){
        this.zonaldea=zonaldea;
    }


}
