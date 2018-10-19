public class Encryption {
    static String encryption(String s) {
        String text = "";
        for (int i = 0; i < s.length(); i++){
            if (!s.substring(i, i+1).equals(" ")){
                text += s.substring(i, i+1);
            }
        }
        int row = (int)Math.sqrt(text.length());
        int column = (int)Math.sqrt(text.length()) + 1;

        //Expand the columns if the sentence doesn't fit in a square matrix
        column = (s.length() > row*row) ? row+1 : row;

        //Expand the rows if the sentence still doesn't fit
        row = (s.length() > row*column) ? row+1 : row;

        String[][] value = new String[row][column];

        int index = 0;

        boolean found = false;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (index < s.length()){
                    value[i][j] = s.substring(index, index + 1);
                    index ++;
                }else{
                    found = false;
                    break;
                }
            }
            if (found){
                break;
            }
        }

        String returnVal = "";

        for (int j = 0; j < column; j++){
            for (int i = 0; i < row; i++){
                if (value[i][j] != null){
                    returnVal += value[i][j];
                }
            }
            returnVal += " ";
        }
        return returnVal;
    }

    static int x = 3;

    public static void main (String[] args){
        System.out.println(x);
    }
}