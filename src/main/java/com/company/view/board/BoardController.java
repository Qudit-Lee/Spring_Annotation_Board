package com.company.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.Spring_Annotation_Board.board.BoardDAO;
import com.company.Spring_Annotation_Board.board.BoardDO;

/* ��Ʈ�� MVC ������ 5���� xxxConstroller�� 
 * ������ Controller Class = Plain Old Java Object 
 * ���⼭ Plain Old Java Object�� �θ� Class�κ��� �ƹ��͵� ��� ���� ������,
 * � Interface�κ��� ������ ���� �ʴ� ������ Java Class */

/* BoardController Class ����� ����  @Controller Annotation�� ���̸�
 * Spring Container�� @Controller�� ����� ��ü�� �ڵ����� Controller ��ü�� �ν� */

/* �� Command ��ü�� Controller �޼ҵ��� �Ű������� ���� DO(Data Object)��ü
 *   ��> Command ��ü��?
 *   	 ��> Ŭ���̾�Ʈ�� �����ִ� �Ķ��Ƽ�� �ڵ����� ��ܼ� ��ȯ�Ǵ� ��ü�� �̰��� "�ڵ� ��ü ��ȯ"�̶�� ���ϸ�,
 *   		���� ū �ٽ� ����� �ش�*/

@Controller // => controller annotation
public class BoardController {
	// ��ü �Խñ� ��� ó�� �޼ҵ�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boarDO, BoardDAO boardDAO, Model model, String searchCondition, String searchKeyword) {
		
		model.addAttribute("boardList", boardDAO.getBoardList(searchCondition, searchKeyword));
		return "getBoardList.jsp";
	}
	
	// �Խñ� �󼼺��� ó�� �޼ҵ�
	@RequestMapping("/getBoard.do")
	public String getBoardList(BoardDO boarDO, BoardDAO boardDAO, Model model) {
		
		model.addAttribute("board", boardDAO.getBoard(boarDO));
		return "getBoard.jsp";
	}
	
	// �ű� �Խñ� ��� ó�� �޼ҵ�
	@RequestMapping("/insertBoard.do")
	public String InsertBoard(BoardDO boarDO, BoardDAO boardDAO) {
		
		boardDAO.insertBoard(boarDO);			
		return "getBoardList.do";
	}
	
	// �Խñ� ���� ó�� �޼ҵ�
	@RequestMapping("/updateBoard.do")
	public String UpdateBoard(BoardDO boarDO, BoardDAO boardDAO) {
			
		boardDAO.updateBoard(boarDO);			
		return "getBoardList.do";
	}

	// �Խñ� ���� ó�� �޼ҵ�
	@RequestMapping("/deleteBoard.do")
	public String DeleteBoard(BoardDO boarDO, BoardDAO boardDAO) {
			
		boardDAO.deleteBoard(boarDO);			
		return "getBoardList.do";
	}
}
