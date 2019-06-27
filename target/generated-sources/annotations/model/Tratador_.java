package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tratador.class)
public abstract class Tratador_ {

	public static volatile ListAttribute<Tratador, Animal> animalList;
	public static volatile SingularAttribute<Tratador, String> senha;
	public static volatile SingularAttribute<Tratador, String> telefone;
	public static volatile ListAttribute<Tratador, Rotina> rotinaList;
	public static volatile SingularAttribute<Tratador, Endereco> enderecoId;
	public static volatile SingularAttribute<Tratador, String> matricula;
	public static volatile SingularAttribute<Tratador, String> nome;
	public static volatile SingularAttribute<Tratador, Integer> id;
	public static volatile ListAttribute<Tratador, Boletim> boletimList;

}

