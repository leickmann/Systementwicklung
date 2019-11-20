package Aufgabe7;

public class SchraubenFabrikM10 implements IAbstrakteFabrik {

	@Override
	public ISchraube erzeugeSchraube() {
		return new SchraubeM10();
	}

	@Override
	public IMutter erzeugeMutter() {
		return new MutterM10();
	}

}
