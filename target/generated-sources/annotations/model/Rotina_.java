package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rotina.class)
public abstract class Rotina_ {

	public static volatile ListAttribute<Rotina, Animal> animalList;
	public static volatile SingularAttribute<Rotina, Integer> codigo;
	public static volatile SingularAttribute<Rotina, Date> dataValidade;
	public static volatile ListAttribute<Rotina, Receita> receitaList;
	public static volatile ListAttribute<Rotina, Tratador> tratadorList;
	public static volatile ListAttribute<Rotina, Tarefas> tarefasList;

}

