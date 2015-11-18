package com.syaku.bbs.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository(value = "bbsMapper")
public interface BbsMapper {
	
    List<BbsVo> select();
    BbsVo selectOne(int idx);
    void insert(BbsVo bbsVo);
    void update(BbsVo bbsVo);
    void delete(int idx);
}
