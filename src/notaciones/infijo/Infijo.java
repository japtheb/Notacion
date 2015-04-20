package notaciones.infijo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Infijo {

	public static List<String> calcular(List<String> listIn) throws Exception {
		List<String> listOut = new ArrayList<String>();
		Stack<String> stackOperations = new Stack<String>();

		for (int i = 0; i < listIn.size(); i++) {
			String element = listIn.get(i);
			InfijoHelper.TYPE elementType = InfijoHelper
					.getElementType(element);
			switch (elementType) {
			case NUMBER:
				listOut.add(element);
				break;

			case OPERATION:
			case LOGIC_OPERATION:
				if (!stackOperations.isEmpty()) {
					String lastElementInStack = stackOperations.peek();
					int hierachyLastElementInStack = InfijoHelper
							.getHierachy(lastElementInStack);
					int hierachyActualElement = InfijoHelper
							.getHierachy(element);
					if (hierachyActualElement > hierachyLastElementInStack) {
						listOut.add(element);
					} else {
						stackOperations.push(element);
					}
				} else {
					stackOperations.push(element);
				}
				break;

			case OPEN_PARENTHESIS:
				List<String> sublistIn = InfijoHelper.getSubList(listIn,
						element);
				List<String> sublistOut = calcular(sublistIn);
				listOut.addAll(sublistOut);
				i = i + sublistOut.size();
				break;
			case OTHER:
				throw new Exception("This is not allowed");

			default:
				break;
			}
		}

		while (!stackOperations.isEmpty()) {
			listOut.add(stackOperations.pop());
		}

		return listOut;
	}
}
