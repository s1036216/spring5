package com.gms.web.board;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gms.web.board.ArticleDTO;
@Component
public interface BoardService {
	public String addArticle(ArticleDTO bean);
	public String countArticles();
	public List<ArticleDTO> listArticles(); 
	public ArticleDTO findBySeq(int seqNo);
	public List<ArticleDTO> findById(String id); 
	public String updateArticle(ArticleDTO update);
	public String deleteArticle(int seq);
}
