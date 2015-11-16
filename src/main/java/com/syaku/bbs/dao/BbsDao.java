package com.syaku.bbs.dao;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value = "bbsDao")
public class BbsDao {
	
	@Resource(name = "bbsMapper")
	private BbsMapper bbsMapper;

	public List<BbsVo> getSelect() {
		return this.bbsMapper.select();
	}

	public BbsVo getSelectOne(int idx) {
		return this.bbsMapper.selectOne(idx);
	}

	public void insert(BbsVo bbsVo) {
		this.bbsMapper.insert(bbsVo);
	}

	public void update(BbsVo bbsVo) {
		this.bbsMapper.update(bbsVo);
	}

	public void delete(int idx) {
		this.bbsMapper.delete(idx);
	}
}
