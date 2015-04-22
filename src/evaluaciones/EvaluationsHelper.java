package evaluaciones;

import java.util.Stack;

import notaciones.infijo.InfijoHelper;
import notaciones.infijo.InfijoHelper.LOGIC_OPERATION;
import notaciones.infijo.InfijoHelper.OPERATION;

public class EvaluationsHelper {
	public static String evaluateOperation(String lastElement,
			String preLastElement, OPERATION operation) throws Exception {
		double lastNumber = Double.parseDouble(lastElement);
		double preLastNumber = Double.parseDouble(preLastElement);
		double result = 0;
		switch (operation) {
		case PLUS:
			result = lastNumber + preLastNumber;
			break;
		case MINUS:
			result = lastNumber - preLastNumber;
			break;
		case MULTUPLY:
			result = lastNumber * preLastNumber;
			break;
		case DIVIDE:
			result = lastNumber / preLastNumber;
			break;
		case MODULE:
			result = lastNumber % preLastNumber;
			break;
		default:
			throw new Exception("is not a valid operation");
		}
		return String.format("%s", result);
	}

	public static boolean evaluateLogicOperations(Stack<String> numbersStack,
			Stack<String> logicOperatorsStack) throws Exception {
		while (!logicOperatorsStack.isEmpty()) {
			if (numbersStack.size() < 2) {
				throw new Exception("malformed evaluation");
			}
			String lastNumber = numbersStack.pop();
			String preLastNumber = numbersStack.pop();
			LOGIC_OPERATION logicOperation = InfijoHelper
					.getLogicOperationType(logicOperatorsStack.pop());
			return EvaluationsHelper.evaluateLogicOperation(lastNumber,
					preLastNumber, logicOperation);

		}
		throw new Exception("malformed evaluation");
	}

	public static boolean evaluateLogicOperation(String lastElement,
			String preLastElement, LOGIC_OPERATION logicOperation)
			throws Exception {

		double lastNumber = Double.parseDouble(lastElement);
		double preLastNumber = Double.parseDouble(preLastElement);

		switch (logicOperation) {
		case EQUALS:
			return preLastNumber == lastNumber;

		case DIFFERENT:
			return preLastNumber != lastNumber;

		case LESS:
			return preLastNumber < lastNumber;

		case LESS_OR_EQUALS:
			return preLastNumber <= lastNumber;

		case GREATER:
			return preLastNumber > lastNumber;

		case GREATER_OR_EQUALS:
			return preLastNumber >= lastNumber;

		case AND:
		case OR:
			throw new Exception("not yet implemented");

		default:
			throw new Exception("not a valid logic operation");
		}
	}
}
