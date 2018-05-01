package javatips.fsabino.dependency_injection;


public class ClazzIoC {
	
	private ReferencesFactory referencesFactory;

	// Se inyecta la referencia con este método -- lo hace un framework como spring 
	//una alternativa es que se cargue un fichero de propiedades al levantar la aplicacion y este inyecte las dependencias necesarias.
	// es framework es el encargado de proveerle la configuracion y dependencias necesarias a la aplicacion
	// de esta manera la aplicacion reduce su dependencia.
	public void setReferencesFactory(ReferencesFactory referencesFactory) {
		this.referencesFactory = referencesFactory;
	}

	public void method(String key) {
		System.out.println(referencesFactory.getReference(key));
	}

}
