class Solution {
    public int solution(int[][] sizes) {
        
        int answer = 0;
        
        int row = sizes[0][0];
        int col = sizes[0][1];
        for(int i=1; i<sizes.length; i++){
            
            // 크기를 변경해야 한다면
            if( row < sizes[i][0] || col <sizes[i][1]){
                
                // 뒤집으면 되나요?
                if(row > sizes[i][1] && col > sizes[i][0]) continue;
                
                // 크기 변경하기
                if( Math.max(row, sizes[i][0]) * Math.max(col,sizes[i][1]) > 
                   Math.max( row, sizes[i][1]) * Math.max( col, sizes[i][0]) ){
                       row = Math.max(row, sizes[i][1]);
                       col = Math.max(col,sizes[i][0]); 
                }
                else {
                    row = Math.max(row,sizes[i][0]);
                    col = Math.max(col,sizes[i][1]);
                }
            }
        
        }
        
        //System.out.println( row + " " + col );
        answer = row * col;
        return answer;
    }
}