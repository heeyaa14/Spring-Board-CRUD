package org.pkh.boardex001.service;

import java.util.List;
import org.pkh.boardex001.domain.BoardVO;
import org.pkh.boardex001.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;
	
	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		int n = boardMapper.update(board);
		if(n==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		int n = boardMapper.delete(bno);
		if(n==1)
			return true;
		else 
			return false;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return boardMapper.getList();
	}
}
