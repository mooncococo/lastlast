package order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import order.model.Order;
import order.model.OrderDao;

@Controller
public class ShowListController {
    
    @Autowired
    private OrderDao orderDao; 
    
    final String command = "showList.od";
    final String getPage = "user_showList_4";
    
    @RequestMapping(command)
    public ModelAndView doAction(HttpSession session ) {
	
	String mid = (String)session.getAttribute("loginInfo2");
	List<Order> lists = orderDao.getOrder(mid); 
	System.out.println("showlists size : "+ lists.size());
	
	
	
	
	ModelAndView mav = new ModelAndView();
	
	mav.addObject("lists", lists); 
	mav.setViewName(getPage);
	return mav;
    }
    	
}
