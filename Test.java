public class Test {

	public static void main(String[] args) {
		int capacity = 500;

		try {
			DoubleLinkedList linkedList = new DoubleLinkedList(capacity);
			for(int i=1; i < capacity; i++){
				linkedList.addFirst(i);
			}
			for(int i=1; i < capacity; i++){
				System.out.println(linkedList.removeLast());
			}
		}
		catch(de.uni_potsdam.hpi.DequeFull e){
			p("Deque Full");
		}
		catch(de.uni_potsdam.hpi.DequeEmpty e){
			p("Deque Empty");
		}
	}

	public static void p(Object o){
		System.out.println(o);
	}


}