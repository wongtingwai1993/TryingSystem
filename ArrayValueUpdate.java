public class ArrayValueUpdate
{
    
    public static int searchGreatValue(int totalNumber, int totalValue, int timesValue){
        if(totalNumber *  timesValue > totalValue ){
            return totalNumber;
        }
        return searchGreatValue(totalNumber +1, totalValue, timesValue);
    }
    
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        int totalNumber = 5;                // Reading input from STDIN
        String[] splitValue = "1 2 3 4 5".split(" ");
        int [] intValues = new int[splitValue.length];
        int totalValue = 0;

        for(int x =0; x < splitValue.length; x++){
            totalValue += Integer.parseInt( splitValue[x] ) ;
        }
        System.out.println(searchGreatValue(totalValue/ totalNumber, totalValue,totalNumber));
    }
} 
