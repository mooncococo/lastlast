package order.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDao")
public class OrderDao {
    
    final String namespace = "order.model.Order";
    
    @Autowired
    SqlSessionTemplate sqlsessionTemplate;
    
    
    
    public List<Order> getOrder(String mid) {
	List<Order> lists = new ArrayList<Order>();
	lists = sqlsessionTemplate.selectList(namespace+".GetOrder", mid);
	return lists;
    }
    
}
