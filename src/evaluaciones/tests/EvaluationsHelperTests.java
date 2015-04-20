package evaluaciones.tests;

import static org.junit.Assert.*;

import java.util.Stack;

import notaciones.infijo.InfijoHelper.LOGIC_OPERATION;
import notaciones.infijo.InfijoHelper.OPERATION;
import notaciones.tests.InfijoHelperTest;
import notaciones.tests.InfijoTest;

import org.junit.Test;

import evaluaciones.EvaluationsHelper;

public class EvaluationsHelperTests {

	@Test
	public void testEvaluateOperation() throws Exception {
		String lastElement = "2";
		String preLastElement = "3";
		OPERATION operation = OPERATION.PLUS;
		assertEquals(EvaluationsHelper.evaluateOperation(lastElement,
				preLastElement, operation), "5.0");

		lastElement = "2";
		preLastElement = "3";
		operation = OPERATION.MINUS;
		assertEquals(EvaluationsHelper.evaluateOperation(lastElement,
				preLastElement, operation), "-1.0");

		lastElement = "2";
		preLastElement = "3";
		operation = OPERATION.MULTUPLY;
		assertEquals(EvaluationsHelper.evaluateOperation(lastElement,
				preLastElement, operation), "6.0");

		lastElement = "4";
		preLastElement = "2";
		operation = OPERATION.DIVIDE;
		assertEquals(EvaluationsHelper.evaluateOperation(lastElement,
				preLastElement, operation), "2.0");

		lastElement = "4";
		preLastElement = "2";
		operation = OPERATION.MODULE;
		assertEquals(EvaluationsHelper.evaluateOperation(lastElement,
				preLastElement, operation), "0.0");
	}

	@Test
	public void testEvaluateLogicOperation() throws Exception {
		double lastNumber = 3;
		double preLastNumber = 2;
		LOGIC_OPERATION logicOperation = LOGIC_OPERATION.GREATER;
		assertEquals(true, EvaluationsHelper.evaluateLogicOperation(lastNumber,
				preLastNumber, logicOperation));

		lastNumber = 3;
		preLastNumber = 2;
		logicOperation = LOGIC_OPERATION.LESS;
		assertEquals(false, EvaluationsHelper.evaluateLogicOperation(
				lastNumber, preLastNumber, logicOperation));
		
		lastNumber = 2;
		preLastNumber = 3;
		logicOperation = LOGIC_OPERATION.LESS;
		assertEquals(true, EvaluationsHelper.evaluateLogicOperation(
				lastNumber, preLastNumber, logicOperation));
	}

	@Test
	public void testEvaluateLogicOperations() throws Exception {
		Stack<String> numbersStack = InfijoTest.stackWith(new String[] { "3",
				"2" });
		Stack<String> logicOperatorsStack = InfijoTest
				.stackWith(new String[] { "<" });
		boolean expectedResult = true;
		assertEquals(expectedResult, EvaluationsHelper.evaluateLogicOperations(
				numbersStack, logicOperatorsStack));
	}

}
