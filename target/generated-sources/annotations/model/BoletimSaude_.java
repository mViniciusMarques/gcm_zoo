package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BoletimSaude.class)
public abstract class BoletimSaude_ {

	public static volatile ListAttribute<BoletimSaude, Animal> animalList;
	public static volatile ListAttribute<BoletimSaude, RegistroClinico> registroClinicoList;
	public static volatile SingularAttribute<BoletimSaude, String> nome;
	public static volatile SingularAttribute<BoletimSaude, Integer> id;

}

