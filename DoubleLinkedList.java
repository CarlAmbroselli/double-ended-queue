import de.uni_potsdam.hpi.*;

public class DoubleLinkedList implements Deque{

	private int capacity, count;
	private ListItem head;
	private ListItem tail;

	public DoubleLinkedList(int capacity){
		if(capacity > 0) this.capacity = capacity;
		else this.capacity = 0;
		this.count = 0;
		this.head = null;
		this.tail = null;
	}

	public int capacity(){
		return this.capacity;
	}
	
	public int size(){
		return this.count;
	}
	
	public void clear(){
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	public void addFirst(Object e) throws DequeFull{

		if(this.count == this.capacity){
			throw new DequeFull();
		}

		else if(this.head == null){
			this.head = new ListItem();
			this.head.setItem(e);
			this.tail = this.head;
			this.head.setNext(this.tail);
			this.tail.setBefore(this.head);

		}

		else {
			ListItem newItem = new ListItem(e, null, this.head);
			this.head.setBefore(newItem);
			this.head = newItem;
		}

		this.count++;
	}
	
	public void addLast(Object e) throws DequeFull{

		if(this.count == this.capacity){
			throw new DequeFull();
		}

		else if(this.tail == null){
			this.head = new ListItem();
			this.head.setItem(e);
			this.tail = this.head;
			this.head.setNext(this.tail);
			this.tail.setBefore(this.head);

		}

		else {
			ListItem newItem = new ListItem(e, this.tail, null);
			this.tail.setNext(newItem);
			this.tail = newItem;
		}

		this.count++;
	}
	
	public Object removeFirst() throws DequeEmpty{
		Object popedElement = this.head.item();
		this.head = this.head.next();
		this.count--;
		return popedElement;
	}
	
	public Object removeLast() throws DequeEmpty{
		Object popedElement = this.tail.item();
		this.tail = this.tail.before();
		this.count--;
		return popedElement;
	}

}

class ListItem{
	
	private Object item;
	private ListItem before;
	private ListItem next;

	public ListItem(){}

	public ListItem(Object item, ListItem before, ListItem next){
		this.item = item;
		this.before = before;
		this.next = next;
	}

	public void setBefore(ListItem before){
		this.before = before;
	}

	public ListItem before(){
		return this.before;
	}

	public void setNext(ListItem next){
		this.next = next;
	}

	public ListItem next(){
		return this.next;
	}

	public void setItem(Object item){
		this.item = item;
	}

	public Object item(){
		return this.item;
	}

	public ListItem clone(){
		return new ListItem(this.item, this.before, this.next);
	}

}