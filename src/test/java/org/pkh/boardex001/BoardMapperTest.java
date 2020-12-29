package org.pkh.boardex001;

import java.sql.Connection;

import javax.sql.DataSource;
import javax.swing.border.Border;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pkh.boardex001.domain.BoardVO;
import org.pkh.boardex001.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_= @Autowired)
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection conn=dataSource.getConnection()) {
			log.info(conn);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testGList() {
		mapper.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새글 제목");
		board.setContent("새글 내용");
		board.setWriter("new User");
		mapper.insert(board);
		log.info(board);
		
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(1L);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		int n = mapper.delete(21);
		if(n==1) {
			 log.info("삭제성공");
		}
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(1L);
		board.setTitle("수정제목");
		board.setContent("수정내용");
		board.setWriter("user4");
		int n = mapper.update(board);
		if(n==1) {
			log.info("수정성공");
		}
	}
	
}
