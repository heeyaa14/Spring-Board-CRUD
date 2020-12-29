package org.pkh.boardex001.controller;

import org.pkh.boardex001.domain.BoardVO;
import org.pkh.boardex001.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list.....................!");
		model.addAttribute("list",service.getList());
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String registerPro(BoardVO board, RedirectAttributes rttr) {
		log.info("registerPro");
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:list";
	}
	
	@GetMapping("/get")
	public void get(Long bno, Model model) {
		log.info("get");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/update")
	public String update(BoardVO board) {
		log.info("update");
		if(service.modify(board)) {
			return "redirect:list";
		} else {
			return "redirect:get";
		}
	}
	
	@GetMapping("/delete")
	public String delete(Long bno) {
		log.info("delete");
		if(service.remove(bno)) {
			return "redirect:list";
		} else {
			return "redirect:get";
		}
	}
}
