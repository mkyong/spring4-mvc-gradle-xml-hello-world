package board2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BoardDAOImple implements BoardDAO {

	// 어노테이션 없이 쓰려니 죽겠네
	// @Resource(name="testDao")
	private JdbcTemplate jdbaTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbaTemplate = new JdbcTemplate(dataSource);
	}

	// 게시글 수
	public int boardCount(Map<String, Object> searchMap) throws DataAccessException {

		int count = 0;
		String sql = "";
		if (searchMap.get("boardListSearchText") == null || searchMap.get("boardListSearchText").equals("")) {
			sql = "select count(*) from board02";
			count = jdbaTemplate.queryForObject(sql, Integer.class);

		} else {
			String boardListSelect = (String) searchMap.get("boardListSelect");
			String boardListSearchText = (String) searchMap.get("boardListSearchText");

			sql = "select count(*) from board02 where " + boardListSelect + " like '%" + boardListSearchText + "%'";
			count = jdbaTemplate.queryForObject(sql, Integer.class);

		}

		return count;
	}

	// 게시판 리스트
	public List<BoardDTO> boardList(Map<String, Object> searchMap) throws DataAccessException {

		List<BoardDTO> boardList = null;
		String sql = "";
		Object[] obj;

		if (searchMap.get("boardListSearchText") == null || searchMap.get("boardListSearchText").equals("")) {

			sql = "select * from ("
					+ "select  ROWNUM r,seq ,name,title ,TO_CHAR(regdate,'YYYY/MM/DD')as regdate, readcount,"
					+ "reply, reply_step, reply_level " + "from " + "(select * from board02 "
					+ "order by reply desc, reply_step asc" + ")" + ")" + "where r BETWEEN ? AND ?";

			obj = new Object[] { searchMap.get("startRow"), searchMap.get("endRow") };

		} else {
			String boardListSelect = (String) searchMap.get("boardListSelect");
			String boardListSearchText = (String) searchMap.get("boardListSearchText");

			sql = "select * from ("
					+ "select  ROWNUM r,seq ,name,title ,TO_CHAR(regdate,'YYYY/MM/DD')as regdate, readcount, "
					+ "reply, reply_step, reply_level " + "from " + "(select * from board02 " + "where " + " "
					+ boardListSelect + " like '%" + boardListSearchText + "%'" + "order by reply desc, reply_step asc"
					+ ")" + ")" + "where r BETWEEN ? AND ?";

			obj = new Object[] { searchMap.get("startRow"), searchMap.get("endRow") };

		}

		boardList = jdbaTemplate.query(sql, obj, new RowMapper<BoardDTO>() {
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

				BoardDTO boardDTO = new BoardDTO(rs.getString("seq"), rs.getString("name"), rs.getString("title"),
						rs.getString("regdate"), rs.getInt("readcount"), rs.getInt("reply_step"),
						rs.getInt("reply_level"));
				return boardDTO;
			}
		});

		return boardList;
	}
}
