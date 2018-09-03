    static String encryption(String s) {
        String text;
        for (int i = 0; i < s.length(); i++){
            if (!s.subString(i, i+1).equals(" ")){
                text += s.subString(i, i+1);
            }
        }
        int row = (int)Math.sqrt(text.length());
        int column = (int)Math.sqrt(text.length()) + 1;
        
        String[][] value = new Stirng[row][column];
        
        int index = 0;
        
        for (int i = 0; i < row){
            for (int j = 0; j < column){
                value[i][j] = s.subStirng(index, index + 1);
            }
        }
        
        String returnVal;
        
        for ()
        
    }