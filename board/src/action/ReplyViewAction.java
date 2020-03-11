package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import persistence.BoardDAO;

@AllArgsConstructor
public class ReplyViewAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 페이지 나누기 후에 추가된 정보
		int page = Integer.parseInt(req.getParameter("page"));		
		
		
		//원본글 bno 가져오기
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		//원본글 정보 가져오기
		BoardDAO dao = new BoardDAO();
		BoardVO vo=dao.getRow(bno);
	
		if(vo!=null) {
			path+="?page="+page;
			req.setAttribute("vo", vo);
		}
		return new ActionForward(path, false);
	}

}






