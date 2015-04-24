package notaciones.infijo;

import java.util.ArrayList;
import java.util.List;

import notaciones.infijo.InfijoHelper.LOGIC_OPERATION;

public class InfijoHelper {

	public class Hierahchy {
		public static final int DIFFERENT_HIERACHY = 0;
		public static final int LESS_HIERACHY = 0;
		public static final int LESS_OR_EQUALS_HIERACHY = 0;
		public static final int GREATER_HIERACHY = 0;
		public static final int GREATER_OR_EQUALS_HIERACHY = 0;
		public static final int EQUALS_HIERACHY = 0;
		public static final int PLUS_HIERACHY = 1;
		public static final int MINUS_HIERACHY = 1;
		public static final int MULTIPLY_HIERACHY = 2;
		public static final int DIVIDE_HIERACHY = 2;
		public static final int MODULE_HIERACHY = 2;
		public static final int AND_HIERACHY = 4;
		public static final int OR_HIERACHY = 3;
		
	}

	public enum TYPE {
		NUMBER, OPERATION, OPEN_PARENTHESIS, CLOSE_PARENTHESIS, OTHER, LOGIC_OPERATION, BOOLEAN_LOGIC_OPERATION
	}

	public enum OPERATION {
		PLUS, MINUS, MULTUPLY, DIVIDE, MODULE
	}

	public enum LOGIC_OPERATION {
		AND, OR, LESS, LESS_OR_EQUALS, GREATER, GREATER_OR_EQUALS, EQUALS, DIFFERENT
	}

	public static List<String> getSubList(List<String> listIn, int startIndex)
			throws Exception {
		List<String> listOut = new ArrayList<String>();
		for (int i = startIndex; i < listIn.size(); i++) {
			String actualElement = listIn.get(i);
			TYPE actualElementType = getElementType(actualElement);
			switch (actualElementType) {
			case OPEN_PARENTHESIS:
				break;

			case CLOSE_PARENTHESIS:
				return listOut;
			default:

				listOut.add(actualElement);
				break;
			}
		}
		throw new Exception("the object dis not find a close parethesis");
	}

	public static int getHierachy(String element) throws Exception {
		if (element.equals("x")) {
			return Hierahchy.MULTIPLY_HIERACHY;
		} else if (element.equals("/")) {
			return Hierahchy.DIVIDE_HIERACHY;
		} else if (element.equals("+")) {
			return Hierahchy.PLUS_HIERACHY;
		} else if (element.equals("-")) {
			return Hierahchy.MINUS_HIERACHY;
		} else if (element.equals("%")) {
			return Hierahchy.MODULE_HIERACHY;
		} else if (element.equals("&")) {
			return Hierahchy.AND_HIERACHY;
		} else if (element.equals("|")) {
			return Hierahchy.OR_HIERACHY;
		} else if (element.equals("<")) {
			return Hierahchy.LESS_HIERACHY;
		} else if (element.equals("?")) {
			return Hierahchy.LESS_OR_EQUALS_HIERACHY;
		} else if (element.equals(">")) {
			return Hierahchy.GREATER_HIERACHY;
		} else if (element.equals("À")) {
			return Hierahchy.GREATER_OR_EQUALS_HIERACHY;
		} else if (element.equals("=")) {
			return Hierahchy.EQUALS_HIERACHY;
		} else if (element.equals("#")) {
			return Hierahchy.DIFFERENT_HIERACHY;
		} else {
			throw new Exception("This is not allowed");
		}
	}

	public static TYPE getElementType(String element) {
		if (isNumber(element)) {
			return TYPE.NUMBER;
		} else if (isOperation(element)) {
			return TYPE.OPERATION;
		} else if (isLogicOperation(element)) {
			return TYPE.LOGIC_OPERATION;
		} else if (isBooleanLogicOperation(element)) {
			return TYPE.BOOLEAN_LOGIC_OPERATION;
		} else if (isOpenParenthesis(element)) {
			return TYPE.OPEN_PARENTHESIS;
		} else if (isCloseParenthesis(element)) {
			return TYPE.CLOSE_PARENTHESIS;
		} else {
			return TYPE.OTHER;
		}
	}

	public static boolean isBooleanLogicOperation(String element) {
		if (element.equals("&")) {
			return true;
		} else if (element.equals("|")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isOpenParenthesis(String element) {
		if (element.equals("(")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isCloseParenthesis(String element) {
		if (element.equals(")")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isOperation(String element) {
		if (element.equals("x")) {
			return true;
		} else if (element.equals("/")) {
			return true;
		} else if (element.equals("+")) {
			return true;
		} else if (element.equals("-")) {
			return true;
		} else if (element.equals("%")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isLogicOperation(String element) {
		if (element.equals("#")) {
			return true;
		} else if (element.equals("<")) {
			return true;
		} else if (element.equals("?")) {
			return true;
		} else if (element.equals(">")) {
			return true;
		} else if (element.equals("À")) {
			return true;
		} else if (element.equals("=")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNumber(String element) {
		try {
			Float.parseFloat(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static OPERATION getOperationType(String element) throws Exception {
		if (element.equals("x")) {
			return OPERATION.MULTUPLY;
		} else if (element.equals("/")) {
			return OPERATION.DIVIDE;
		} else if (element.equals("+")) {
			return OPERATION.PLUS;
		} else if (element.equals("-")) {
			return OPERATION.MINUS;
		} else if (element.equals("%")) {
			return OPERATION.MODULE;
		} else {
			throw new Exception("is not an operation");
		}
	}

	public static LOGIC_OPERATION getLogicOperationType(String element)
			throws Exception {
		if (element.equals("#")) {
			return LOGIC_OPERATION.DIFFERENT;
		} else if (element.equals("&")) {
			return LOGIC_OPERATION.AND;
		} else if (element.equals("|")) {
			return LOGIC_OPERATION.OR;
		} else if (element.equals("<")) {
			return LOGIC_OPERATION.LESS;
		} else if (element.equals("?")) {
			return LOGIC_OPERATION.LESS_OR_EQUALS;
		} else if (element.equals(">")) {
			return LOGIC_OPERATION.GREATER;
		} else if (element.equals("À")) {
			return LOGIC_OPERATION.GREATER_OR_EQUALS;
		} else if (element.equals("=")) {
			return LOGIC_OPERATION.EQUALS;
		} else {
			throw new Exception("is not a logic operation");
		}
	}
}
