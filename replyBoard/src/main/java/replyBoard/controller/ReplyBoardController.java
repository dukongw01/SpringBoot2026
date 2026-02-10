package replyBoard.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import replyBoard.dto.ReplyBoardDTO;
import replyBoard.service.ReplyBoardService;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ReplyBoardController {
	
	@Autowired
	//반드시 ReplyBoardService() 인터페이스를 의존객체로 삽입함을 주의
	ReplyBoardService replyBoardService;
	
	//게시글 목록으로 이동하는 컨트롤러
	@GetMapping("/board/list")
	public String boardList(Model model) {
		System.out.println("ReplyBoardController boardList() 호출");
		List<ReplyBoardDTO> replyList = replyBoardService.getAllReplyBoard();
		model.addAttribute("list",replyList);
		return "replyBoard/replyboardList";
	}
	
	@GetMapping("/board/writer")
	public String boardWriterForm() {
		System.out.println("호출");
		return "replyBoard/replyboardWrite_Form";
	}
	
//	@GetMapping("/board/writerPro")
//	public String boardWriterPro(ReplyBoardDTO rdto) {
//		System.out.println("호출");
//		replyBoardService.insertReplyBoard(rdto);
//		return "redirect:/board/list";
//	}
	
	//파일 업로드는 @PostMapping()만 가능
	@PostMapping("/board/writerPro")
	public String boardWriterPro(ReplyBoardDTO rdto, @RequestParam("file1") MultipartFile upload1, @RequestParam("file2") MultipartFile upload2) {
		System.out.println("ReplyBoardController boardWriterPro()호출");
		//WebConfig에서 설정한 'file:///c:/upload/'이 경로와 반드시 일치해야함
		String savePath = "c:/upload/";
		//2. 안전장치. 만약 c드라이브에 업로드 폴더가 존재하지 않으면 프로그램을 통해 자동 생성되도록 작성
		File saveDir = new File(savePath);
		//mkdirs는 폴더가 없어도 한꺼번에 만들어주는 메소드이다
		if(!saveDir.exists()) {saveDir.mkdirs();}
		//3. 첫번째 이미지 업로드 처리. 예외처리 이미지가 비어있으면 추가 안됨.
		if(!upload1.isEmpty()) {//사용자가 실체 파일을 선택해서 보냈는지 확인
				//사용자가 올린 원래 파일명 (예:20.jpg)를 가져온다.
				String originalName1 = upload1.getOriginalFilename();
				String saveName1 = originalName1;
		File file1 = new File(savePath + saveName1);
		upload1.transferTo(file1);
		rdto.setUpload1(saveName1);}
		
		//4. 두번째 이미지 업로드 처리. 예외처리 이미지가 비어있으면 추가 안됨.
		if(!upload2.isEmpty()) {
			String originalName1 = upload2.getOriginalFilename();
			String saveName2 = originalName2;
		File file2 = new File(savePath + saveName2);
		upload2.transferTo(file2);
		rdto.setUpload2(saveName2);}
		
		replyBoardService.insertReplyBoard(rdto);
		return "redirect:/board/list";
	
	}
	

	
	
	//하나의 상세 게시글
	@GetMapping("/board/detail")
	public String getOneString(@RequestParam("num") int num, Model model) {
		System.out.println("ReplyBoardController getOneBoard() 호출");
		ReplyBoardDTO oneList = replyBoardService.getOneBoard(num);
		model.addAttribute("onelist",oneList);
		return "/replyBoard/replyboardDetail";
	}
	
	//답글 작성하는 폼으로 이동하는 컨트롤러
	@GetMapping("/board/reply")
	public String reWriterForm(Model model,
			@RequestParam("num") int num, @RequestParam("ref") int ref,
			@RequestParam("re_step") int re_step, @RequestParam("re_leverl") int re_leverl) {
		System.out.println("ReplyBoardController reWriterForm()호출");
		model.addAttribute("num", num);
		model.addAttribute("ref", ref);
		model.addAttribute("re_step", re_step);
		model.addAttribute("re_leverl", re_leverl);
		return "/replyBoard/replyBoardReWrite_Form";
	}
	
	//답글 작성 처리 컨트롤러
	@PostMapping("/board/reWritePro")
	public String reWritePro(ReplyBoardDTO rdto) {
		replyBoardService.replyProcess(rdto);
		return "redirect:/board/list";
	}
	
	
}
