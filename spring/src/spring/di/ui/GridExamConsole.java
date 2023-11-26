package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {
	
	@Autowired(required = false)
	@Qualifier("exam2")
	private Exam exam;
	
	public GridExamConsole() {
		System.out.println("construcator");
	}

	public GridExamConsole(	Exam exam) {
		System.out.println("overload");
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.println("-------------------");
		System.out.println("total     avg");
		System.out.println("-------------------");
		if(exam == null)
			System.out.printf("%3d      %3.2f\n", 0 ,0);
		else
			System.out.printf("%3d      %3.2f\n", exam.total(), exam.avg());
		System.out.println("-------------------");
	}
	

	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}

}
