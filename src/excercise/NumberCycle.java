package excercise;

import java.util.ArrayList;
import java.util.List;

public class NumberCycle {

	private List<Integer> m_input = new ArrayList<Integer>();
	private List<Integer> m_through = new ArrayList<Integer>();
	// private List<Integer> m_inputList = new ArrayList<Integer>();

	public NumberCycle(List<Integer> list) {
		this.m_input = list;
	}

	public void through(int index) {
		if (!checkExist(index)) {
			m_through.add(index);
			int value = m_input.get(index);
			int right = (index + value) % m_input.size();
			int left = (index - value + m_input.size()) % m_input.size();
			through(right);
			through(left);
			if (!checkResult()) {
				m_through.remove(index);
			} else {
				return;
			}
		}
	}

	public boolean checkExist(int index) {
		for (int i = 0; i < m_through.size(); i++) {
			if (index == m_through.get(i)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkResult() {
		if (m_input.size() == m_through.size()) {
			return true;
		} else {
			return false;
		}
	}

	public List<Integer> getResult(){
		for (int i = 0; i < m_input.size(); i++) {
			NumberCycle nc = new NumberCycle(m_input);
			List<Integer> r= new ArrayList<Integer>();
			try {
				nc.through(i);
				r = nc.m_through;
				//System.out.println(r);
			} catch (java.lang.IndexOutOfBoundsException e){
				r = new ArrayList<Integer>();
			}
			if (r.size()==m_input.size()){
				return r;
			}
		}
		return new ArrayList<Integer>();
	}
	
	
//	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.remove(1);
//		NumberCycle nc = new NumberCycle(list);
//		System.out.println(list);
//	}
}
