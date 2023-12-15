public class Palindromo {




    long zenbaki;

    Palindromo(long zenbaki){
        this.zenbaki=zenbaki;
    }

    Palindromo(){
        this.zenbaki=0;
    }


    public boolean palindromoaDa(){

        boolean palindromo = false;

        char [] lista = new char[digituKop()];

        for (int i =0;i<digituKop()/2;i++){
            lista[i]= digiPosN(i);
        }
        //Ikusteko nola dagoen lista
        /*for (int i =0;i<digituKop()/2;i++){
            System.out.print(lista[i]+" ");
        }*/

        for (int i =0;i<digituKop();i++){
            if (digiPosN(i) !=digiPosN(digituKop()-i-1)){
                palindromo = false;
                i=digituKop()+1;
            }else {
                palindromo = true;
            }
        }

        return palindromo;

    }


    public int digituKop(){
        return (int)(Math.log10(this.zenbaki)+1);
    }

    public int digituKop(int zenbaki){
        return (int)(Math.log10(zenbaki)+1);
    }



    public char digiPosN(int n){

        String s = String.valueOf(this.zenbaki);
        return s.charAt(n);
    }

    public int digiPosN(long zenbaki,int n){

        String s = String.valueOf(zenbaki);
        return s.charAt(n);
    }


}
