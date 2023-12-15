public class Palindromo {

    
    long zenbaki;

    Palindromo(){
        this.zenbaki=0;
    }



    public boolean palindromoaDa(int zenbaki){

        boolean palindromo = false;


        for (int i =0;i<digituKop(zenbaki);i++){
            if (digiPosN(zenbaki,i) !=digiPosN(zenbaki,digituKop(zenbaki)-i-1)){
                palindromo = false;
                i=digituKop(zenbaki)+1;
            }else {
                palindromo = true;
            }
        }

        return palindromo;

    }



    public int digituKop(int zenbaki){

        return (int)(Math.log10(zenbaki)+1);
    }


    public int digiPosN(long zenbaki,int n){

        String s = String.valueOf(zenbaki);
        return s.charAt(n);
    }


}
