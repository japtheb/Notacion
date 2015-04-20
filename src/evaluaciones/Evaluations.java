package evaluaciones;

import java.util.List;
import java.util.Stack;

import notaciones.infijo.InfijoHelper;
import notaciones.infijo.InfijoHelper.OPERATION;
import notaciones.infijo.InfijoHelper.TYPE;

public class Evaluations {

	public static boolean evaluate(List<String> listIn) throws Exception {
		Stack<String> numbersStack = new Stack<String>();
		Stack<String> logicOperatorsStack = new Stack<String>();
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
				logicOperatorsStack.push(element);
				break;
			default:
				break;
			}
		}
		return EvaluationsHelper.evaluateLogicOperations(numbersStack,
				logicOperatorsStack);
	}

}
