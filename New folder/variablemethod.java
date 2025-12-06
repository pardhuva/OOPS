//containing variable number of inputs
class variablemethod{

    static void greatest(int ... a){
        int max=0;
        System.out.println("length: "+a.length);

        for(int i:a){
           if(i>max){
            max=i;
           }
        }

        System.out.println(max);

    }


    public static void main(String args[]){
        System.out.println("Question 5: ");

        greatest(2,3,4,5);

        greatest(2,3,4,5,6,7,8,9);
    }
}