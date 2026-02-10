package replyBoard.service;

import java.util.List;

import replyBoard.dto.ReplyBoardDTO;

public interface ReplyBoardService {
	//각종 SQL을 위한 메소드 작성
	//인터페이스는 추상 메소드만 작성 가능
	//게시글 작성하여 추가하는 메소드
	public void insertReplyBoard(ReplyBoardDTO rdto);
	
	//게시글 전체 목록 검색
	public List<ReplyBoardDTO> getAllReplyBoard();
	
	//하나의 게시글 리턴 받은 메소드
	public ReplyBoardDTO getOneBoard(int num);
	
	//답글 작성 추가
	public void reWriteInsert(ReplyBoardDTO rdto);
	
	//답글 작성시 부모글 re_level 보다 큰 값들을 모두 1씩 증가
	//ref : 1, re_step : 1, re_level :1 => 원글
	//원글의 답글을 달 경우 => ref:1, re_step:2, re_level:2
	public void reSqUpdate(ReplyBoardDTO rdto);
	
	//답글 추가시 reSqUpdate()메소드가 먼저 실행되도록 묶음으로 만든 메소드
	//reWriteInsert() + reSqUpdate() 합쳐서 실행하는 메소드
	// 이유 : 답글은 추가되기 이전에 기존의 ref, re_step, re_level값이 변경되는
	//부분이 필요하므로 반드시 reSqUpdate()먼저, reWriteInsert()실행.
	public void replyProcess(ReplyBoardDTO rdto);
	
}
