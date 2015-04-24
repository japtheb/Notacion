import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import evaluaciones.Evaluations;
import notaciones.infijo.Infijo;

public class Main {

	public static void main(String[] args) throws Exception {
		List<String> listIn = Arrays
				.asList(JOptionPane
						.showInputDialog(null)
						.split("(?<=[-+x/<>=#?À&|%\\(\\) ])|(?=[-+x/<>=#?À&|%\\(\\)])"));
		List<String> resultInfijo = Infijo.calcular(listIn.subList(1,
				listIn.size()));
		String resultEvaluation = Evaluations.evaluate(resultInfijo);
		JOptionPane
				.showMessageDialog(
						null,
						String.format(
								"La operaci—n en orden posfijo es %s y el resultado de la evaluacion es %s",
								resultInfijo.toString(), resultEvaluation));
	}

}
