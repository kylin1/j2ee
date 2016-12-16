package edu.nju.listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Application Lifecycle Listener implementation class CounterListener
 *
 * 安装在一个服务器中的一个特定URL名字空间（比如，/myapplication）下的
 * 所有Servlet，JSP，JavaBean等Web部件的集合构成了一个Web的应用，
 * 每一个Web应用（同一JVM），容器都会有一个背景对象，
 * 而javax.servlet.ServletContext接口就提供了访问这个背景对象的途径。
 *
 */
@WebListener
public class CounterListener implements ServletContextListener, ServletContextAttributeListener {

	int counter;

	String counterFilePath = "/Users/kylin/Desktop/Study/第二学期作业/j2ee/homework2/web/data/counter.txt";

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent cse) {
		try {
			//读取本地文件信息
			System.out.println("Reading Start");
			BufferedReader reader = new BufferedReader(new FileReader(counterFilePath));
			counter = Integer.parseInt(reader.readLine());
			reader.close();
			System.out.println("Reading " + counter);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		//设置属性
		ServletContext servletContext = cse.getServletContext();
		servletContext.setAttribute("webCounter", Integer.toString(counter));
		System.out.println("Application initialized");
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("ServletContextattribute added");
	}

	/**
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
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Application shut down");
	}

	/**
	 * 控制并发
	 * 保证在同一时刻最多只有一个线程执行该段代码
	 *
	 * 当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。
	 * 其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
	 *
	 * @param scae
	 */
	synchronized void writeCounter(ServletContextAttributeEvent scae) {
		ServletContext servletContext = scae.getServletContext();
		counter = Integer.parseInt((String) servletContext.getAttribute("webCounter"));
		//重新读取
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(counterFilePath));
			writer.write(Integer.toString(counter));
			writer.close();
			System.out.println("Writing");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
