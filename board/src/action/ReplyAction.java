package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import persistence.BoardDAO;
import upload.UploadUtil;

@AllArgsConstructor
public class ReplyAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// qna_board_reply 값 가져오기
		UploadUtil uplodUtil = new UploadUtil();
		HashMap<String, String> dataMap=uplodUtil.getItem(req);
		
		int page = Integer.parseInt(dataMap.get("page"));
		
		
		String name=dataMap.get("name");
		String title = dataMap.get("title");
		String content = dataMap.get("content");
		String password = dataMap.get("password");
		String attach=null;
		if(dataMap.containsKey("file")) {
			attach=dataMap.get("file");
		}		
		//원본글의 re_ref,re_lev,re_seq => hidden 태그 값		
		int re_ref=Integer.parseInt(dataMap.get("re_ref"));
		int re_lev=Integer.parseInt(dataMap.get("re_lev"));
		int re_seq=Integer.parseInt(dataMap.get("re_seq"));
		
		BoardVO vo=new BoardVO();		
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setPassword(password);
		vo.setAttach(attach);
		vo.setRe_ref(re_ref);
		vo.setRe_lev(re_lev);
		vo.setRe_seq(re_seq);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.replyArticle(vo);
		
		if(result==0) {
			path="";
		}else {
			path+="?page="+page;
		}
		
		return new ActionForward(path, true);
	}

}






