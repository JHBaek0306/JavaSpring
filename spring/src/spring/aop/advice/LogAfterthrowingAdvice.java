package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterthrowingAdvice implements ThrowsAdvice{
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		System.out.println("Execption occured : " + e.getMessage());
	}
	
}
