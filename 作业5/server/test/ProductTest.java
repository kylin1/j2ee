import edu.nju.onlinestock.dao.CourseDaoImpl;
import org.junit.Test;

public class ProductTest {


    /*
     * 添加单元测试点
     * (@Test) public void runtest()启动JPA框架
     */
    @Test
    public void runtest() {
        CourseDaoImpl daoBean = new CourseDaoImpl();
        daoBean.getCourse(1);
    }
}