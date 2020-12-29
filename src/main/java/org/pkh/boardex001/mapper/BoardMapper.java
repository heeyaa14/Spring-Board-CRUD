package org.pkh.boardex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.pkh.boardex001.domain.BoardVO;

public interface BoardMapper {
	
	//@Select("select * from board where bno>0")
	public List<BoardVO> getList();
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	public BoardVO read(long bno);
	public int update(BoardVO board);
	public int delete(long bno);
	
}
