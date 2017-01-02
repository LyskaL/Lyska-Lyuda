package lyskal.module9.evaluationofstudents;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

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
		
		List<Evaluation> evaluations2 = new ArrayList<>(5);
		evaluations2.add(Evaluation.FOUR);
		evaluations2.add(Evaluation.FIVE);
		evaluations2.add(Evaluation.FOUR);
		evaluations2.add(Evaluation.FIVE);
		evaluations2.add(Evaluation.FIVE);
		group.add("Minnic", evaluations2);
		
		List<Evaluation> evaluations3 = new ArrayList<>(5);
		evaluations3.add(Evaluation.THREE);
		evaluations3.add(Evaluation.FIVE);
		evaluations3.add(Evaluation.FOUR);
		evaluations3.add(Evaluation.THREE);
		evaluations3.add(Evaluation.THREE);
		group.add("Verena", evaluations3);
		
		group.add("Denisov", evaluations);
		
		show(group);
	}
	
	public static void show(final Group group) {
		for (Entry<String, List<Evaluation>> elements : group.getGroup().entrySet()) {
			System.out.println(elements.getKey() + " = " + elements.getValue());
		}	
	}
}
