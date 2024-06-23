package Assignments.Assignment2.junit;
//import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Assignments.Assignment2.MyQueue;
import Assignments.Assignment2.Exceptions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a = "a", b = "b", c = "c", d = "d", e = "e", f = "f";
	public ArrayList<String> fill = new ArrayList<String>();

	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests

	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);

		doubleQ = new MyQueue<>(6);
		doubleQ.enqueue(1.0);
		doubleQ.enqueue(2.3);
		doubleQ.enqueue(0.5);
		doubleQ.enqueue(10.2);

		// STUDENT: add setup for doubleQ for student tests
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() throws QueueUnderflowException {
		assertEquals(false, stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
		while (!doubleQ.isEmpty()) {
			doubleQ.dequeue();
		}
		assertEquals(true, doubleQ.isEmpty());

	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			// Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue(false, "This should have caused an QueueUnderflowException");
		} catch (QueueUnderflowException e) {
			assertTrue(true, "This should have caused an QueueUnderflowException");
		} catch (Exception e) {
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
	}

	@Test
	public void testDequeueStudent() {
		try {
			assertEquals(1.0, doubleQ.dequeue());
			assertEquals(2.3, doubleQ.dequeue());
			assertEquals(0.5, doubleQ.dequeue());
			assertEquals(10.2, doubleQ.dequeue());

		} catch (QueueUnderflowException e) {
			assertTrue(true, "This should have caused an QueueUnderflowException");
		} catch (Exception e) {
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}

	}

	@Test
	public void testSize() throws QueueOverflowException, QueueUnderflowException {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			// Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue(false, "This should have caused an QueueOverflowException");
		} catch (QueueOverflowException e) {
			assertTrue(true, "This should have caused an QueueOverflowException");
		} catch (Exception e) {
			assertTrue(false, "This should have caused an QueueOverflowException");
		}
	}

	@Test
	public void testEnqueueStudent() {
		try {
			assertEquals(4, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(3.9));
			assertEquals(5, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(5.5));
			assertEquals(6, doubleQ.size());
			// Queue is full, next statement should cause QueueOverFlowException
			doubleQ.enqueue(2.0);
			assertTrue(false, "This should have caused an QueueOverflowException");
		} catch (QueueOverflowException e) {
			assertTrue(true, "This should have caused an QueueOverflowException");
		} catch (Exception e) {
			assertTrue(false, "This should have caused an QueueOverflowException");
		}
	}

	@Test
	public void testIsFull() throws QueueOverflowException {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() throws QueueOverflowException {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}

	@Test
	public void testToStringStudent() throws QueueOverflowException {
		assertEquals("1.02.30.510.2", doubleQ.toString());
		doubleQ.enqueue(3.0);
		assertEquals("1.02.30.510.23.0", doubleQ.toString());
		doubleQ.enqueue(5.3);
		assertEquals("1.02.30.510.23.05.3", doubleQ.toString());

	}

	@Test
	public void testToStringDelimiter() throws QueueOverflowException {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() throws QueueOverflowException, QueueUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		// start with an empty queue
		stringQ = new MyQueue<String>(5);
		// fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3, stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());
	}

}
