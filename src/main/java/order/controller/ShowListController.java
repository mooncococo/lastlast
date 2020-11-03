package order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.model.ProductDetail;
import admin.model.ProductDetailDao;
import order.model.Order;
import order.model.OrderDao;

@Controller
public class ShowListController {
    
    @Autowired
    private OrderDao orderDao; 
    
    @Autowired
    private ProductDetailDao productDetailDao;
    
    final String command = "showList.od";
    final String getPage = "order_showList_4";
    
    @RequestMapping(command)
    public ModelAndView doAction(HttpSession session) {
   
   String mid = (String)session.getAttribute("loginInfo2");
//   List<Order> lists = orderDao.getAll();
//   System.out.println(lists.size());
//   
//   List<Order> lists2 = new ArrayList<Order>();
//   
//   List<ProductDetail> lists3 = new ArrayList<ProductDetail>();
//   int dnum = 0 ;
//   for(int i=0;i<lists.size();i++) {
//       lists2 = orderDao.getOrder(mid); 
//       dnum =  lists2.get(i).getDnum();
//       System.out.println("dnum!!!!!!!! : " +dnum);
//       lists3 =  productDetailDao.getOption(dnum);
//   }

   List<Order> lists = orderDao.getOrder(mid); 
   
   ModelAndView mav = new ModelAndView();
   
   mav.addObject("lists", lists); 

   mav.setViewName(getPage);
   return mav;
    }
       
}