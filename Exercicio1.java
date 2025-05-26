public class Exercicio1 {
   public static void main(String[] args) {
        String string1 = "ABCDCBDCBDACBDABDCBADF"; 
        String string2 = "ADF";
        System.out.println(compare(string1, string2));

   } 

   public static int compare (String string1, String string2){
    for(int i = 0; i < string1.length(); i++){
        if(string2.charAt(0) == string1.charAt(i)){
            if(string1.charAt(i) == string2.charAt(0)){
                int count = 0;
                for(int c = 0; c < string2.length(); c++){
                    if(string1.charAt(i+c) == string2.charAt(0+c)){
                        count++;
                    } else {
                        break;
                    }
                    if(count == string2.length()){
                        return i;
                    }
                    }
                }
            }
        }
        return 0;}
}