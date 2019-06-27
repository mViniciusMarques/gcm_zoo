package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Receita.class)
public abstract class Receita_ {

	public static volatile SingularAttribute<Receita, String> observacoes;
	public static volatile SingularAttribute<Receita, String> dose;
	public static volatile ListAttribute<Receita, Medicamento> medicamentoList;
	public static volatile SingularAttribute<Receita, String> frequenciaDeAplicacao;
	public static volatile SingularAttribute<Receita, Rotina> rotinaCodigo;
	public static volatile SingularAttribute<Receita, Integer> id;
	public static volatile SingularAttribute<Receita, Date> dataEnvio;
	public static volatile SingularAttribute<Receita, Veterinario> veterinarioId;

}

