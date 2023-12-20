public class Palindromo {




    String karaktere;

    Palindromo(String karaktere){
        this.karaktere=karaktere;
    }


    public boolean palindromoaDa(){

        boolean palindromo = false;


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
        return karaktere.length();
    }




    public char digiPosN(int n){

        return karaktere.charAt(n);
    }



}
