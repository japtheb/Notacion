package evaluaciones;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import notaciones.infijo.InfijoHelper;
import notaciones.infijo.InfijoHelper.LOGIC_OPERATION;
import notaciones.infijo.InfijoHelper.OPERATION;
import notaciones.infijo.InfijoHelper.TYPE;

public class Evaluations {

	public static String evaluate(List<String> listIn) throws Exception {
		Stack<String> numbersStack = new Stack<String>();
		Stack<Boolean> logicOperatorsStack = new Stack<Boolean>();
		for (String element : listIn) {
			TYPE elementType = InfijoHelper.getElementType(element);
			switch (elementType) {
			case NUMBER:
				numbersStack.push(element);
				break;

			case OPERATION:
				if (numbersStack.size() < 2) {
					throw new Exception("Malfermed evaluation");
				}
				String lastElement = numbersStack.pop();
				String preLastElement = numbersStack.pop();
				OPERATION operation = InfijoHelper.getOperationType(element);
				String resultOperation = EvaluationsHelper.evaluateOperation(
						lastElement, preLastElement, operation);
				numbersStack.push(resultOperation);
				break;
			case LOGIC_OPERATION:
				if (numbersStack.size() < 2) {
					throw new Exception("Malfermed evaluation");
				}
				lastElement = numbersStack.pop();
				preLastElement = numbersStack.pop();
				LOGIC_OPERATION logicOperation = InfijoHelper
						.getLogicOperationType(element);
				boolean resultLogicOperation = EvaluationsHelper
						.evaluateLogicOperation(lastElement, preLastElement,
								logicOperation);
				logicOperatorsStack.push(resultLogicOperation);
				break;
			default:
				break;
			}
		}
		if (logicOperatorsStack.isEmpty()) {
			return numbersStack.pop();
		} else {
			return String.valueOf(logicOperatorsStack.pop());
		}

	}

}
