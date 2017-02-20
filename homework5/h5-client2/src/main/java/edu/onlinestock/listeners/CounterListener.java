package edu.onlinestock.listeners;

import edu.onlinestock.tools.FileIOHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * Application Lifecycle Listener implementation class CounterListener
 * <p>
 * 安装在一个服务器中的一个特定URL名字空间（比如，/myapplication）下的
 * 所有Servlet，JSP，JavaBean等Web部件的集合构成了一个Web的应用，
 * 每一个Web应用（同一JVM），容器都会有一个背景对象，
 * 而javax.servlet.ServletContext接口就提供了访问这个背景对象的途径。
 */
@WebListener
public class CounterListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener{

    //总人数
    int total;

    //已经登录
    int logged;

    //游客人数
    int guest;

    String counterFilePath = "/Users/kylin/Desktop/Code/微软/counter.txt";

    /**
     * 服务器启动
     *
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent cse) {
        try {

            //读取本地文件信息
            System.out.println("Reading Start");
            List<String> input = FileIOHelper.readTxtFileLines(counterFilePath);
            assert input.size() == 2 : "存储人数的文件格式错误, 应该是两行数字";
            //登录-游客-总
            String strLogged = input.get(0);
            String strGuest = input.get(1);
            String strTotal = input.get(2);

            //获取人数
            this.logged = Integer.parseInt(strLogged);
            this.guest = Integer.parseInt(strGuest);
            this.total = Integer.parseInt(strTotal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置属性
        ServletContext servletContext = cse.getServletContext();
        servletContext.setAttribute("logged", this.logged);
        servletContext.setAttribute("guest", this.guest);
        servletContext.setAttribute("total", this.total);

        System.out.println("logged=" + logged + ", guest=" + guest + ", total=" + total);
        System.out.println("Application initialized");
    }

    /**
     * 服务器启动
     *
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0) {
        System.out.println("ServletContextattribute added");
    }


    /**
     * 属性被重新设置的时候调用
     *
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("ServletContextattribute replaced");
        writeCounter(scae);
    }

    /**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        System.out.println("ServletContextattribute removed");
    }

    /**
     * 服务器终止调用
     *
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Application shut down");
    }

    /**
     * 控制并发
     * 保证在同一时刻最多只有一个线程执行该段代码
     * <p>
     * 当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。
     * 其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
     *
     * @param scae
     */
    synchronized void writeCounter(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        this.guest = (int) servletContext.getAttribute("guest");
        this.logged = (int) servletContext.getAttribute("logged");
        this.total = (int) servletContext.getAttribute("total");
        //写入新的数据
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(counterFilePath));
            writer.write(Integer.toString(this.logged));
            writer.write("\n");
            writer.write(Integer.toString(this.guest));
            writer.write("\n");
            writer.write(Integer.toString(this.total));
            writer.close();
            System.out.println("Writing");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("create session");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed");
    }
}
