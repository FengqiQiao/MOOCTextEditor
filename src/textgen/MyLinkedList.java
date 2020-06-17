package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>();
		tail = new LLNode<E>();
		size = 0;
		// create link for head and tail
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		tail.prev.next = newNode;
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev = newNode;
		size += 1;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		
		LLNode<E> currentPointer = new LLNode<E>();
		currentPointer = head;
		for (int i = 0; i <= index; i++) {
			currentPointer = currentPointer.next;
		}
		return currentPointer.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		
		LLNode<E> currentPointer = new LLNode<E>();
		currentPointer = head;
		for (int i = 0; i < index; i++) {
			currentPointer = currentPointer.next;
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = currentPointer.next;
		currentPointer.next.prev = newNode;
		newNode.prev = currentPointer;
		currentPointer.next = newNode;
		size += 1;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		
		LLNode<E> currentPointer = new LLNode<E>();
		currentPointer = head;
		for (int i = 0; i <= index; i++) {
			currentPointer = currentPointer.next;
		}
		E removeData;
		removeData = currentPointer.data;
		currentPointer.next.prev = currentPointer.prev;
		currentPointer.prev.next = currentPointer.next;
		size -= 1;
		
		return removeData;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Element cannot be null");
		}
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		
		E oldElement;
		LLNode<E> currentPointer = new LLNode<E>();
		currentPointer = head;
		for (int i = 0; i <= index; i++) {
			currentPointer = currentPointer.next;
		}
		oldElement = currentPointer.data;
		currentPointer.data = element;
		
		return oldElement;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode() 
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
