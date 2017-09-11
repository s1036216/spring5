package com.gms.web.mapper;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gms.web.board.ArticleDTO;
@Repository 
public interface BoardMapper {
	public String insertArticle(ArticleDTO bean);
	public String countArticles();
	public List<ArticleDTO> listArticles(); 
	public ArticleDTO selectBySeq(int seqNo);
	public List<ArticleDTO> selectById(String id);
	public String updateArticle(ArticleDTO update);
	public String deleteArticle(int seq);
}
