package Krieg;

public class EclEmmaTest {

	public static void main(String[] args) {
		Schadensevaluator schad = new Schadensevaluator();
		
		schad.abzug(Waffe.Messer, Waffe.Speer);
		schad.abzug(Waffe.Bogen, Waffe.Bogen);

	}

}
