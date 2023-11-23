package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/*
		Exam exam = new NewlecExam();
		ExamConsole console = new GridExamConsole();
		
		console.setExam(exam);
		*/
		
		ApplicationContext context = 				
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
	}

}
