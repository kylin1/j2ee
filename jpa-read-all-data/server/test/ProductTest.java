import edu.nju.onlinestock.dao.CourseDaoBean;
import org.junit.Test;

public class ProductTest {


    /*
     * 添加单元测试点
     * (@Test) public void runtest()启动JPA框架
     */
    @Test
    public void runtest(){
        CourseDaoBean daoBean = new CourseDaoBean();
        daoBean.getCourse(1);
    }
}