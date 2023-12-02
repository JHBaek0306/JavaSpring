package spring.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {

		Exam exam = new NewlecExam(1, 1, 1, 1);
		
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
				new Class[] {Exam.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						long start = System.currentTimeMillis();
						
						Object result = method.invoke(exam, args);
						
						long end = System.currentTimeMillis();
						String msg = (end - start) + "ms �ð��� �ɷȽ��ϴ�. ";
						System.out.println(msg);
						
						return result;
					}
				});
		
		System.out.printf("total is %d\n", proxy.total());
		System.out.printf("avg is %f\n", proxy.avg());
	}

}