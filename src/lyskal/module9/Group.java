package lyskal.module9;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Разработать программу, которая хранит информацию
 * о школьниках и их оценках за 5 экзаменов в виде мапы (map). 
 * Каждый элемент отображения должен иметь следующий вид: 
 * ключ – фамилия ученика, значение – набор оценок за пять экзаменов. 
 * Написать тестовый main.
 * 
 */
public class Group {
	private Map<String, List<Evaluation>> _group;
	
	public Group() {
		_group = new HashMap<String, List<Evaluation>>();
	}
	
	public void add(final String lastName, 
					final List<Evaluation> evaluations){
		_group.put(lastName, evaluations);
	}
	
	public void remove(final String lastName) {
		_group.remove(lastName);
	}
	
	public List<Evaluation> getValue(final String lastName) {
		return Collections.unmodifiableList(_group.get(lastName));
	}
	
	public int size() {
		return _group.size();
	}
}