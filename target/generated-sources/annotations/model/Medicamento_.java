package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medicamento.class)
public abstract class Medicamento_ {

	public static volatile ListAttribute<Medicamento, Receita> receitaList;
	public static volatile SingularAttribute<Medicamento, String> nome;
	public static volatile SingularAttribute<Medicamento, Integer> id;

}

