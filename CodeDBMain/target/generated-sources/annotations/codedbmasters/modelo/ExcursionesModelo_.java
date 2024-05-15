package codedbmasters.modelo;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExcursionesModelo.class)
public abstract class ExcursionesModelo_ {

	public static volatile SingularAttribute<ExcursionesModelo, String> descripcion;
	public static volatile SingularAttribute<ExcursionesModelo, LocalDate> fecha;
	public static volatile SingularAttribute<ExcursionesModelo, String> codigo;
	public static volatile SingularAttribute<ExcursionesModelo, Double> precio;
	public static volatile SingularAttribute<ExcursionesModelo, Integer> n_dias;

	public static final String DESCRIPCION = "descripcion";
	public static final String FECHA = "fecha";
	public static final String CODIGO = "codigo";
	public static final String PRECIO = "precio";
	public static final String N_DIAS = "n_dias";

}

