package board.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myboardCommentsDao")
public class BoardCommentsDao {

    final String namespace="board.model.BoardComments";
    
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    
    public void insertComments(BoardComments boardComments) {
	sqlSessionTemplate.insert(namespace+".InsertComments", boardComments);
	
    }

    public BoardComments selectComments(int num) {
	BoardComments boardComments =sqlSessionTemplate.selectOne(namespace+".SelectComments", num);
	return boardComments;
	
    }

}
