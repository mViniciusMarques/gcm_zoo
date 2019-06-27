package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Boletim.class)
public abstract class Boletim_ {

	public static volatile SingularAttribute<Boletim, String> observacoes;
	public static volatile SingularAttribute<Boletim, Tratador> tratadorId;
	public static volatile SingularAttribute<Boletim, Date> data;
	public static volatile SingularAttribute<Boletim, String> estadoAnimal;
	public static volatile SingularAttribute<Boletim, Integer> id;
	public static volatile SingularAttribute<Boletim, Animal> animalCodigo;

}

