package notaciones.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import notaciones.infijo.Infijo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InfijoTest {

	@Test
	public void test() throws Exception {

		List<String> listIn = listWith(new String[] { "2", "+", "2" });
		List<String> listResult = listWith(new String[] { "2", "2", "+" });
		assertEquals(Infijo.calcular(listIn), listResult);

		listIn = listWith(new String[] { "2", "x", "2" });
		listResult = listWith(new String[] { "2", "2", "x" });
		assertEquals(Infijo.calcular(listIn), listResult);

		listIn = listWith(new String[] { "2", "x", "2", "/", "(", "2", "+",
				"3", ")" });
		listResult = listWith(new String[] { "2", "2", "2", "3", "+", "/", "x" });
		assertEquals(Infijo.calcular(listIn), listResult);

		listIn = listWith(new String[] { "2", "+", "(", "2", "+", "2", ")" });
		listResult = listWith(new String[] { "2", "2", "2", "+", "+" });
		assertEquals(Infijo.calcular(listIn), listResult);

		listIn = listWith(new String[] { "2", ">", "1" });
		listResult = listWith(new String[] { "2", "1", ">" });
		assertEquals(Infijo.calcular(listIn), listResult);

		listIn = listWith(new String[] { "2", "+", "3", "À", "5" });
		listResult = listWith(new String[] { "2", "3", "+", "5", "À" });
		assertEquals(Infijo.calcular(listIn), listResult);

		listIn = listWith(new String[] { "5", "?", "3", "+", "5" });
		listResult = listWith(new String[] { "5", "3", "5", "+", "?" });
		assertEquals(Infijo.calcular(listIn), listResult);
		
		listIn = listWith(new String[] { "(", "20", "-", "7", "%", "2", ">", "7", "-", "5", ")" });
		listResult = listWith(new String[] { "20", "7", "2", "%", "-", "7", "5", "-", ">" });
		assertEquals(Infijo.calcular(listIn), listResult);
		
		listIn = listWith(new String[] { "(", "3", "+", "5", "<", "2", "+", "3", ")", "&", "(", "20", "-", "7", "%", "2", ">", "7", "-", "5", ")" });
		listResult = listWith(new String[] { "3", "5", "+", "2", "3", "+", "<", "20", "7", "2", "%", "-", "7", "5", "-", ">", "&" });
		assertEquals(Infijo.calcular(listIn), listResult);
		
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testExceptions() throws Exception {
		List<String> listIn = listWith(new String[] { "2", "%", "2" });
		exception.expect(Exception.class);
		Infijo.calcular(listIn);

		listIn = listWith(new String[] { " " });
		exception.expect(Exception.class);
		Infijo.calcular(listIn);

		listIn = listWith(new String[] { "2e" });
		exception.expect(Exception.class);
		Infijo.calcular(listIn);

		listIn = listWith(new String[] { "2e2" });
		exception.expect(Exception.class);
		Infijo.calcular(listIn);
	}

	public static List<String> listWith(String[] strings) {
		List<String> listResult = new ArrayList<String>();
		for (String string : strings) {
			listResult.add(string);
		}
		return listResult;
	}

	public static Stack<String> stackWith(String[] strings) {
		Stack<String> stackResult = new Stack<String>();
		for (String string : strings) {
			stackResult.push(string);
		}
		return stackResult;
	}

}
