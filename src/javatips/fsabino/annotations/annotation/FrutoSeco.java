package javatips.fsabino.annotations.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FrutoSeco {
	
	//propiedad no obligatoria en la annotation
	boolean tieneVitaminaE() default false;
	
	int calorias();
	
	//propiedad no obligatoria en la annotation
	String arbolQueDaEsteFruto() default "";	
}
