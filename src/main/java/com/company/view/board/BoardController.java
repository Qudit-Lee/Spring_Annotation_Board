package com.company.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.Spring_Annotation_Board.board.BoardDAO;
import com.company.Spring_Annotation_Board.board.BoardDO;

/* 스트링 MVC 구조의 5개의 xxxConstroller를 
 * 통합한 Controller Class = Plain Old Java Object 
 * 여기서 Plain Old Java Object는 부모 Class로부터 아무것도 상속 받지 않으며,
 * 어떤 Interface로부터 구현도 받지 않는 순수한 Java Class */

/* BoardController Class 선언부 위에  @Controller Annotation을 붙이면
 * Spring Container는 @Controller이 선언된 객체를 자동으로 Controller 객체로 인식 */

/* ※ Command 객체는 Controller 메소드의 매개변수로 받은 DO(Data Object)객체
 *   └> Command 객체란?
 *   	 └> 클라이언트가 보내주는 파라미티가 자동으로 담겨서 변환되는 객체로 이것을 "자동 객체 변환"이라고 말하며,
 *   		가장 큰 핵심 기술에 해당*/

@Controller // => controller annotation
public class BoardController {
	// 전체 게시글 목록 처리 메소드
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boarDO, BoardDAO boardDAO, Model model, String searchCondition, String searchKeyword) {
		
		model.addAttribute("boardList", boardDAO.getBoardList(searchCondition, searchKeyword));
		return "getBoardList.jsp";
	}
	
	// 게시글 상세보기 처리 메소드
	@RequestMapping("/getBoard.do")
	public String getBoardList(BoardDO boarDO, BoardDAO boardDAO, Model model) {
		
		model.addAttribute("board", boardDAO.getBoard(boarDO));
		return "getBoard.jsp";
	}
	
	// 신규 게시글 등록 처리 메소드
	@RequestMapping("/insertBoard.do")
	public String InsertBoard(BoardDO boarDO, BoardDAO boardDAO) {
		
		boardDAO.insertBoard(boarDO);			
		return "getBoardList.do";
	}
	
	// 게시글 수정 처리 메소드
	@RequestMapping("/updateBoard.do")
	public String UpdateBoard(BoardDO boarDO, BoardDAO boardDAO) {
			
		boardDAO.updateBoard(boarDO);			
		return "getBoardList.do";
	}

	// 게시글 삭제 처리 메소드
	@RequestMapping("/deleteBoard.do")
	public String DeleteBoard(BoardDO boarDO, BoardDAO boardDAO) {
			
		boardDAO.deleteBoard(boarDO);			
		return "getBoardList.do";
	}
}
