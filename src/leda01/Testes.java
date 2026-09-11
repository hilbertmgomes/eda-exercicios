package leda01;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static leda01.Algoritmos.*;

class Testes {
	
	//Testes para o algoritmo sem HashSet
	
	@Test
	void testPiorCaso() {
		String[] v = {"1", "2", "3", "4", "5"};
		
		assertEquals(false, temRepetido(v));
	}
	
	@Test
	void testMelhorCaso() {
		String[] v = {"3", "3", "2", "1"};
		
		assertEquals(true, temRepetido(v));
	}
	
	@Test
	void testCasoIntermediario() {
		String[] v = {"3", "1", "2", "5", "3"};
		
		assertEquals(true, temRepetido(v));
	}
	
	//Testes para algoritmo com HashSet
	
	@Test
	void testPiorCasoHashSet() {
		String[] v = {"1", "2", "3", "4", "5"};
		
		assertEquals(false, temRepetidoHashSet(v));
	}
	
	@Test
	void testMelhorCasoHashSet() {
		String[] v = {"3", "3", "2", "1"};
		
		assertEquals(true, temRepetidoHashSet(v));
	}
	
	@Test
	void testCasoIntermediarioHashSet() {
		String[] v = {"3", "1", "2", "5", "3"};
		
		assertEquals(true, temRepetidoHashSet(v));
	}
}
