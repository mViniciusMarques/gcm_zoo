package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile ListAttribute<Endereco, Veterinario> veterinarioList;
	public static volatile SingularAttribute<Endereco, String> cidade;
	public static volatile SingularAttribute<Endereco, String> estado;
	public static volatile SingularAttribute<Endereco, Integer> numero;
	public static volatile SingularAttribute<Endereco, String> bairro;
	public static volatile ListAttribute<Endereco, Tratador> tratadorList;
	public static volatile SingularAttribute<Endereco, Integer> id;
	public static volatile SingularAttribute<Endereco, String> rua;

}

