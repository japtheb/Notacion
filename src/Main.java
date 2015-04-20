import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import evaluaciones.Evaluations;
import notaciones.infijo.Infijo;

public class Main {

	public static void main(String[] args) throws Exception {
		List<String> listIn = Arrays.asList(JOptionPane.showInputDialog(null)
				.split("(?<=[-+x/<>=#?À&|])|(?=[-+x/<>=#?À&|])"));
		List<String> resultInfijo = Infijo.calcular(listIn);
		boolean resultEvaluation = Evaluations.evaluate(resultInfijo);
		JOptionPane.showConfirmDialog(null, String.format(
				"El resultado de la evaluacion es %s", resultEvaluation));
	}

}
