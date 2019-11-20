package Aufgabe7;

public class SchraubenFabrikM6 implements IAbstrakteFabrik {

	@Override
	public ISchraube erzeugeSchraube() {
		return new SchraubeM6();
	}

	@Override
	public IMutter erzeugeMutter() {
		return new MutterM6();
	}

}
