package replyBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import replyBoard.ReplyBoardApplication;
import replyBoard.dto.ReplyBoardDTO;
import replyBoard.mapper.ReplyBoardMapper;

@Service
public class ReplyBoardServiceImpl implements ReplyBoardService {

    private final ReplyBoardApplication replyBoardApplication;
	
	@Autowired
	ReplyBoardMapper replyBoardMapper;

    ReplyBoardServiceImpl(ReplyBoardApplication replyBoardApplication) {
        this.replyBoardApplication = replyBoardApplication;
    }

	@Override
	public void insertReplyBoard(ReplyBoardDTO rdto) {
		System.out.println("ReplyBoardServiceImpl insertReplyBoard()호출");
		replyBoardMapper.insertReplyBoard(rdto);
		
	}

	@Override
	public List<ReplyBoardDTO> getAllReplyBoard() {
		System.out.println("ReplyBoardServiceImpl getAllReplyBoard()호출");
		replyBoardMapper.insertReplyBoard(rdto);
		return null;
	}

	@Override
	public ReplyBoardDTO getOneBoard(int num) {
		System.out.println("ReplyBoardServiceImpl getOneBoard()호출");
		return replyBoardMapper.getOneBoard(num);
	}

	@Override
	public void reWriteInsert(ReplyBoardDTO rdto) {
		System.out.println("ReplyBoardServiceImpl reWriteInsert()호출");
		replyBoardMapper.reWriteInsert(rdto);
		
	}

	@Override
	public void reSqUpdate(ReplyBoardDTO rdto) {
		System.out.println("ReplyBoardServiceImpl reSqUpdate()호출");
		replyBoardMapper.reSqUpdate(rdto);
		
	}

	@Override
	public void replyProcess(ReplyBoardDTO rdto) {
		//반드시 update메소드 먼저 실행
		replyBoardMapper.reSqUpdate(rdto);
		//답글 insert
		replyBoardMapper.reWriteInsert(rdto);
		
	}
	
}
