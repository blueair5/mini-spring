package org.springframework.test.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.service.WorldService;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class AutoProxyTest {
	/*
	 * 怎么实现一个注解拦截的功能：
	 * 1.我们自定义一个注解
	 * 2.为这个注解设置一个切面，这个切面需要让 spring 容器进行管理, 在这个切面里面，我们可以定义切点表达式
	 * 3.spring 容器加载所有的切面，然后对应的切面对每个 spring 容器管理的 Bean 进行扫描，判断是否可以命中切面
	 *   命中则进行代理
	 */


	@Test
	public void testAutoProxy() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");

		//获取代理对象
		WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
		worldService.explode();
	}
}
