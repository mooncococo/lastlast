package board.controller;



import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardComments;
import board.model.BoardCommentsDao;
import board.model.BoardDao;

@Controller
public class BoardContentController {

    final String command = "content.bd";
    final String getPage = "contentForm";

    @Autowired
    private BoardDao boardDao;

    @Autowired
    BoardCommentsDao boardCommentsDao;

    @RequestMapping(value=command,method=RequestMethod.GET)
    public ModelAndView doAction(@RequestParam(value = "num") int num) {
	System.out.println("get 방식");
	System.out.println("num : " +num);
	BoardBean bean = boardDao.getOneBoard(num);
	
	BoardComments boardCom = boardCommentsDao.selectComments(num);
	ModelAndView mav = new ModelAndView();
	if(boardCom != null) {
	
	System.out.println("boardCom.getCdate():" +boardCom.getCdate());
	mav.addObject("boardComments", boardCom);
	mav.addObject("bean", bean);
	mav.setViewName(getPage);
	}
	else {
	    mav.addObject("bean", bean);
	    mav.setViewName(getPage);
	}
	return mav;

    }
   
    @RequestMapping(value=command,method=RequestMethod.POST)
    public ModelAndView doAction(HttpServletRequest request) {
	
	ModelAndView mav = new ModelAndView();
	BoardComments boardCom = new BoardComments();
	int num = Integer.parseInt(request.getParameter("num"));
	int ccnum = Integer.parseInt(request.getParameter("ccnum"));

	String cname = request.getParameter("cname");
	String crecom = request.getParameter("crecom");
	
	
	
	//requuest받아서 bean 담아서 해보기
	
	
	System.out.println("post 방식");
	System.out.println("num : " +num);
	System.out.println("ccnum : " +ccnum);
	
	System.out.println("cname:"+cname);
	System.out.println("crecom:"+crecom);
	
	
	
	BoardComments boardComments = new BoardComments();
	System.out.println("boardComments.getCcnum() : "+boardComments.getCcnum());
	
	boardComments.setCname(cname);
	boardComments.setCrecom(crecom);
	boardComments.setCcnum(ccnum);
	

	//System.out.println("num!!!! : "+num);
	BoardBean bean = boardDao.getOneBoard(num);
	if(num == boardComments.getCcnum()) {
	boardCommentsDao.insertComments(boardComments);
	System.out.println("인서트됨");
	System.out.println("확인num : " +num);
	System.out.println("확인ccnum : " +ccnum);
	boardCom = boardCommentsDao.selectComments(num);

	
	mav.addObject("bean", bean);
	mav.addObject("boardComments", boardCom);
	mav.setViewName(getPage);
	  
	  
	}
	return mav;
    }

}




