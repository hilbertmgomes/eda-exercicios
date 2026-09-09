package analiseassintotica;

import static analiseassintotica.ListaClassroom.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListaClassroomTestes {
	
	//Testes para a questão 5

	@Test
	void primeiroTesteQuestão5() {
		int[] arr = {1, 2, 3, 4, 5, 6};
		
		assertEquals(false, temRepetido(arr));
	}
	
	@Test
	void segundoTesteQuestão5() {
		int[] arr = {1, 2, 3, 2, 5, 6};
		
		assertEquals(true, temRepetido(arr));
	}

}
