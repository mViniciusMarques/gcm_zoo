package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vacina.class)
public abstract class Vacina_ {

	public static volatile SingularAttribute<Vacina, String> codigo;
	public static volatile ListAttribute<Vacina, RegistroClinico> registroClinicoList;
	public static volatile SingularAttribute<Vacina, String> nome;
	public static volatile SingularAttribute<Vacina, Integer> id;

}

