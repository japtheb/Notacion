package evaluaciones.tests;

import static org.junit.Assert.*;

import java.util.List;

import notaciones.tests.InfijoTest;

import org.junit.Test;

import evaluaciones.Evaluations;

public class EvaluationTests {

	@Test
	public void testEvaluation() throws Exception {
		List<String> listIn = InfijoTest.listWith(new String[] { "2", "5", "+", "3", "2", "+", "<" });
		assertEquals(Evaluations.evaluate(listIn), true);
		
		listIn = InfijoTest.listWith(new String[] { "3", "2", ">"});
		assertEquals(Evaluations.evaluate(listIn), true);
		
		listIn = InfijoTest.listWith(new String[] { "2", "5", "+", "3", "2", "+", ">" });
		assertEquals(Evaluations.evaluate(listIn), false);
	}

}
