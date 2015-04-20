package notaciones.tests;

import static org.junit.Assert.*;

import java.util.List;

import notaciones.infijo.InfijoHelper;
import notaciones.infijo.InfijoHelper.LOGIC_OPERATION;
import notaciones.infijo.InfijoHelper.OPERATION;

import org.junit.Test;

public class InfijoHelperTest {

	@Test
	public void testTypes() {
		assertEquals(InfijoHelper.getElementType("1"), InfijoHelper.TYPE.NUMBER);
		assertEquals(InfijoHelper.getElementType("q"), InfijoHelper.TYPE.OTHER);
		assertEquals(InfijoHelper.getElementType("/"),
				InfijoHelper.TYPE.OPERATION);
		assertEquals(InfijoHelper.getElementType("x"),
				InfijoHelper.TYPE.OPERATION);
		assertEquals(InfijoHelper.getElementType("+"),
				InfijoHelper.TYPE.OPERATION);
		assertEquals(InfijoHelper.getElementType("-"),
				InfijoHelper.TYPE.OPERATION);
		assertEquals(InfijoHelper.getElementType("("),
				InfijoHelper.TYPE.OPEN_PARENTHESIS);
		assertEquals(InfijoHelper.getElementType(")"),
				InfijoHelper.TYPE.CLOSE_PARENTHESIS);
		assertEquals(InfijoHelper.getElementType("#"),
				InfijoHelper.TYPE.LOGIC_OPERATION);
		assertEquals(InfijoHelper.getElementType("&"),
				InfijoHelper.TYPE.LOGIC_OPERATION);
		assertEquals(InfijoHelper.getElementType("|"),
				InfijoHelper.TYPE.LOGIC_OPERATION);
		assertEquals(InfijoHelper.getElementType("<"),
				InfijoHelper.TYPE.LOGIC_OPERATION);
		assertEquals(InfijoHelper.getElementType("?"),
				InfijoHelper.TYPE.LOGIC_OPERATION);
		assertEquals(InfijoHelper.getElementType(">"),
				InfijoHelper.TYPE.LOGIC_OPERATION);
		assertEquals(InfijoHelper.getElementType("À"),
				InfijoHelper.TYPE.LOGIC_OPERATION);
	}

	@Test
	public void testNumbers() {
		assertEquals(InfijoHelper.isNumber("1"), true);
		assertEquals(InfijoHelper.isNumber("1.0"), true);
		assertEquals(InfijoHelper.isNumber("–"), false);
		assertEquals(InfijoHelper.isNumber("x"), false);
		assertEquals(InfijoHelper.isNumber(".0"), true);
	}

	@Test
	public void testOperations() {
		assertEquals(InfijoHelper.isOperation("1"), false);
		assertEquals(InfijoHelper.isOperation("1.0"), false);
		assertEquals(InfijoHelper.isOperation("–"), false);
		assertEquals(InfijoHelper.isOperation("x"), true);
		assertEquals(InfijoHelper.isOperation("+"), true);
		assertEquals(InfijoHelper.isOperation("/"), true);
		assertEquals(InfijoHelper.isOperation("-"), true);
		assertEquals(InfijoHelper.isOperation("%"), true);
		assertEquals(InfijoHelper.isOperation(".0"), false);
	}

	@Test
	public void testOpenParenthesis() {
		assertEquals(InfijoHelper.isOpenParenthesis("("), true);
		assertEquals(InfijoHelper.isOpenParenthesis(")"), false);
		assertEquals(InfijoHelper.isOpenParenthesis("–"), false);
		assertEquals(InfijoHelper.isOpenParenthesis("x"), false);
		assertEquals(InfijoHelper.isOpenParenthesis("+"), false);
		assertEquals(InfijoHelper.isOpenParenthesis("/"), false);
		assertEquals(InfijoHelper.isOpenParenthesis("-"), false);
		assertEquals(InfijoHelper.isOpenParenthesis("%"), false);
		assertEquals(InfijoHelper.isOpenParenthesis(".0"), false);
	}

	@Test
	public void testCloseParenthesis() {
		assertEquals(InfijoHelper.isCloseParenthesis(")"), true);
		assertEquals(InfijoHelper.isCloseParenthesis("("), false);
		assertEquals(InfijoHelper.isCloseParenthesis("–"), false);
		assertEquals(InfijoHelper.isCloseParenthesis("x"), false);
		assertEquals(InfijoHelper.isCloseParenthesis("+"), false);
		assertEquals(InfijoHelper.isCloseParenthesis("/"), false);
		assertEquals(InfijoHelper.isCloseParenthesis("-"), false);
		assertEquals(InfijoHelper.isCloseParenthesis("%"), false);
		assertEquals(InfijoHelper.isCloseParenthesis(".0"), false);
	}

	@Test
	public void testHierachy() throws Exception {
		int plusHierachy = InfijoHelper.getHierachy("+");
		int minusHierachy = InfijoHelper.getHierachy("-");
		int multiplyHierachy = InfijoHelper.getHierachy("x");
		int divideHierachy = InfijoHelper.getHierachy("/");
		int moduleHierachy = InfijoHelper.getHierachy("%");
		int differentHierachy = InfijoHelper.getHierachy("#");
		int andHierachy = InfijoHelper.getHierachy("&");
		int orHierachy = InfijoHelper.getHierachy("|");
		int lessHierachy = InfijoHelper.getHierachy("<");
		int lessOrEqualHierachy = InfijoHelper.getHierachy("?");
		int greaterHierachy = InfijoHelper.getHierachy(">");
		int greaterOrEqualsHierachy = InfijoHelper.getHierachy("À");
		int equalsHierachy = InfijoHelper.getHierachy("=");

		assertEquals(plusHierachy, InfijoHelper.Hierahchy.PLUS_HIERACHY);
		assertEquals(minusHierachy, InfijoHelper.Hierahchy.MINUS_HIERACHY);
		assertEquals(multiplyHierachy, InfijoHelper.Hierahchy.MULTIPLY_HIERACHY);
		assertEquals(divideHierachy, InfijoHelper.Hierahchy.DIVIDE_HIERACHY);
		assertEquals(moduleHierachy, InfijoHelper.Hierahchy.MODULE_HIERACHY);

		assertEquals(differentHierachy,
				InfijoHelper.Hierahchy.DIFFERENT_HIERACHY);
		assertEquals(andHierachy, InfijoHelper.Hierahchy.AND_HIERACHY);
		assertEquals(orHierachy, InfijoHelper.Hierahchy.OR_HIERACHY);
		assertEquals(lessHierachy, InfijoHelper.Hierahchy.LESS_HIERACHY);
		assertEquals(lessOrEqualHierachy,
				InfijoHelper.Hierahchy.LESS_OR_EQUALS_HIERACHY);
		assertEquals(greaterHierachy, InfijoHelper.Hierahchy.GREATER_HIERACHY);
		assertEquals(greaterOrEqualsHierachy,
				InfijoHelper.Hierahchy.GREATER_OR_EQUALS_HIERACHY);
		assertEquals(equalsHierachy, InfijoHelper.Hierahchy.EQUALS_HIERACHY);
	}

	@Test
	public void testOperationType() throws Exception {
		OPERATION plusOperation = InfijoHelper.getOperationType("+");
		OPERATION minusOperation = InfijoHelper.getOperationType("-");
		OPERATION multiplyOperation = InfijoHelper.getOperationType("x");
		OPERATION divideOperation = InfijoHelper.getOperationType("/");
		OPERATION moduleOperation = InfijoHelper.getOperationType("%");

		assertEquals(plusOperation, InfijoHelper.OPERATION.PLUS);
		assertEquals(minusOperation, InfijoHelper.OPERATION.MINUS);
		assertEquals(divideOperation, InfijoHelper.OPERATION.DIVIDE);
		assertEquals(multiplyOperation, InfijoHelper.OPERATION.MULTUPLY);
		assertEquals(moduleOperation, InfijoHelper.OPERATION.MODULE);

	}

	@Test
	public void testLogicOperationType() throws Exception {
		assertEquals(LOGIC_OPERATION.AND,
				InfijoHelper.getLogicOperationType("&"));
		assertEquals(LOGIC_OPERATION.OR,
				InfijoHelper.getLogicOperationType("|"));
		assertEquals(LOGIC_OPERATION.LESS,
				InfijoHelper.getLogicOperationType("<"));
		assertEquals(LOGIC_OPERATION.LESS_OR_EQUALS,
				InfijoHelper.getLogicOperationType("?"));
		assertEquals(LOGIC_OPERATION.GREATER,
				InfijoHelper.getLogicOperationType(">"));
		assertEquals(LOGIC_OPERATION.GREATER_OR_EQUALS,
				InfijoHelper.getLogicOperationType("À"));
		assertEquals(LOGIC_OPERATION.EQUALS,
				InfijoHelper.getLogicOperationType("="));
		assertEquals(LOGIC_OPERATION.DIFFERENT,
				InfijoHelper.getLogicOperationType("#"));
	}

	@Test
	public void testSubList() throws Exception {
		List<String> listIn = InfijoTest.listWith(new String[] { "2", "+", "(",
				"2", "+", "2", ")" });
		List<String> listOut = InfijoTest
				.listWith(new String[] { "2", "+", "2" });
		assertEquals(InfijoHelper.getSubList(listIn, listIn.get(2)), listOut);
	}

}
