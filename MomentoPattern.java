import java.util.ArrayList;
import java.util.List;

public class MomentoPattern {

	public static class Memento {
		private String state;

		public Memento(String state) {
			this.state = state;
		}

		public String getState() {
			return this.state;
		}
	}

	public static class Caretaker {
		private List<Memento> stateList = new ArrayList<>();

		public void addState(Memento mem) {
			this.stateList.add(mem);
		}

		public Memento getState(int index) {
			return this.stateList.get(index);
		}

		public int getSize() {
			return this.stateList.size() - 1;
		}
	}

	public static class Originator {
		private String state;

		public Originator(String state) {
			this.state = state;
		}

		public String getState() {
			return this.state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Memento createMemento() {
			return new Memento(this.state);
		}

		public void restoreState(Memento memento) {
			this.state = memento.getState();
		}
	}

	public static void main(String[] args) {
		Caretaker caretaker = new Caretaker();


		Originator org = new Originator("state1");
		caretaker.addState(org.createMemento());

		org.setState("state2");
		caretaker.addState(org.createMemento());

		org.setState("state3");
		caretaker.addState(org.createMemento());

		org.restoreState(caretaker.getState(caretaker.getSize() - 1));
		System.out.println(org.getState());

	}
}
