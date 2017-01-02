package lyskal.module9.evaluationofstudents;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(final String[] args) {
		Group group = new Group();
		List<Evaluation> evaluations= new ArrayList<>(5);
		evaluations.add(Evaluation.FIVE);
		evaluations.add(Evaluation.THREE);
		evaluations.add(Evaluation.FOUR);
		evaluations.add(Evaluation.FIVE);
		evaluations.add(Evaluation.FIVE);
		
		group.add("Ivanov", evaluations);
		
		
		
	}
	
	public static void show(final Group group) {
		
	}
}
