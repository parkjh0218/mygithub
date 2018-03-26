package com.bit.app.service;

public class BoardPage {
	// 페이지당 게시물 수 5로 나는 초기화했다 .
    public static final int PAGE_SCALE = 5;
    // 화면당 페이지 수(블록)
    public static final int BLOCK_SCALE = 3;
    private int curPage; 
    private int prevPage; 
    private int nextPage; 
    private int totalPage; 
    private int totalBlock; 
    private int curBlock;  
    private int prevBlock; 
    private int nextBlock;
    // WHERE rn BETWEEN #{start} AND #{end}
    private int pageBegin; // #{start}
    private int pageEnd; // #{end}
    
    // [이전] blockBegin -> 41 42 43 44 45 46 47 48 49 50 [다음]
    private int blockBegin; // 현재 페이지 블록의 시작번호
    
    // [이전] 41 42 43 44 45 46 47 48 49 50 <- blockEnd [다음]
    private int blockEnd; // 현재 페이지 블록의 끝번호
    


    public BoardPage(int count, int curPage){ //(게시물수, 현재 페이지 번호)
        curBlock = 1; //초기화
        this.curPage = curPage; 
        setTotalPage(count); // 전체 페이지 
        setPageRange(); // 
        setTotalBlock(); // 전체 페이지 블록 
        setBlockRange(); // 페이지 블록의 시작/// 끝 번호 
    }
    
    public void setBlockRange(){

        curBlock = (int)Math.ceil((curPage-1) / BLOCK_SCALE)+1;

        blockBegin = (curBlock-1)*BLOCK_SCALE+1;

        blockEnd = blockBegin+BLOCK_SCALE-1;

        if(blockEnd > totalPage) blockEnd = totalPage;

        prevPage = (curPage == 1)? 1:(curBlock-1)*BLOCK_SCALE;

        nextPage = curBlock > totalBlock ? (curBlock*BLOCK_SCALE) : (curBlock*BLOCK_SCALE)+1;

        if(nextPage >= totalPage) nextPage = totalPage;
    }
    
    public void setPageRange(){
    // WHERE rn BETWEEN #{start} AND #{end}
        // 시작번호 = (현재페이지-1)*페이지당 게시물수 +1
        pageBegin = (curPage-1)*PAGE_SCALE+1;
        // 끝번호 = 시작번호+페이지당 게시물수 -1
        pageEnd = pageBegin+PAGE_SCALE-1;
    }
    
    // Getter/Setter
    public int getCurPage() {
        return curPage;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
    public int getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int count) {
        // Math.ceil 올림 
        totalPage = (int) Math.ceil(count*1.0 / PAGE_SCALE);
    }
    public int getTotalBlock() {
        return totalBlock;
    }
    // 페이지 블록의 갯수 계산(총 100페이지라면 10개의 블록)
    public void setTotalBlock() {
        // 전체 페이지 갯수 / 10
        // 91 / 10 => 9.1 => 10개
        totalBlock = (int)Math.ceil(totalPage / BLOCK_SCALE);
    }
    
    public int getCurBlock() {
        return curBlock;
    }
    public void setCurBlock(int curBlock) {
        this.curBlock = curBlock;
    }
    public int getPrevBlock() {
        return prevBlock;
    }
    public void setPrevBlock(int prevBlock) {
        this.prevBlock = prevBlock;
    }
    public int getNextBlock() {
        return nextBlock;
    }
    public void setNextBlock(int nextBlock) {
        this.nextBlock = nextBlock;
    }
    public int getPageBegin() {
        return pageBegin;
    }
    public void setPageBegin(int pageBegin) {
        this.pageBegin = pageBegin;
    }
    public int getPageEnd() {
        return pageEnd;
    }
    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }
    public int getBlockBegin() {
        return blockBegin;
    }
    public void setBlockBegin(int blockBegin) {
        this.blockBegin = blockBegin;
    }
    public int getBlockEnd() {
        return blockEnd;
    }
    public void setBlockEnd(int blockEnd) {
        this.blockEnd = blockEnd;
    }
}
