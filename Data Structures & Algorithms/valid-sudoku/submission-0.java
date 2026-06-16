class Solution {

    public boolean check(char[][] board,int i,int j){
        List<Integer> temp=new ArrayList<>(Collections.nCopies(board[0].length+5,0));
        for(int k=i;k<i+3;k++){
            for(int l=j;l<j+3;l++){
                if(board[k][l]=='.') continue;
                int numb=board[k][l]-'0';
                if(temp.get(numb)==1) return false;
                temp.set(numb,1);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        
        List<Integer> temp=new ArrayList<>(Collections.nCopies(board[0].length+5,0));
        
        for(int i=0;i<board.length;i++){
            temp=new ArrayList<>(Collections.nCopies(board[0].length+5,0));
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                int numb=board[i][j]-'0';
                if(temp.get(numb)==1) return false;
                temp.set(numb,1);
            }
        }

        for(int j=0;j<board[0].length;j++){
            temp=new ArrayList<>(Collections.nCopies(board.length+5,0));
            for(int i=0;i<board.length;i++){
                if(board[i][j]=='.') continue;
                int numb=board[i][j]-'0';
                if(temp.get(numb)==1) return false;
                temp.set(numb,1);
            }
        }

        for(int i=0;i<board.length;i+=3){
            for(int j=0;j<board[0].length;j+=3){
                if(check(board,i,j)==false) return false;
            }
        }
        return true;
    }
}
