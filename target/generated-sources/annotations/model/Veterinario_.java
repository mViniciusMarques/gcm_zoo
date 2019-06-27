package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Veterinario.class)
public abstract class Veterinario_ {

	public static volatile SingularAttribute<Veterinario, String> senha;
	public static volatile SingularAttribute<Veterinario, String> telefone;
	public static volatile ListAttribute<Veterinario, RegistroClinico> registroClinicoList;
	public static volatile SingularAttribute<Veterinario, Date> dataRegistro;
	public static volatile ListAttribute<Veterinario, Receita> receitaList;
	public static volatile SingularAttribute<Veterinario, String> crmv;
	public static volatile SingularAttribute<Veterinario, Endereco> enderecoId;
	public static volatile SingularAttribute<Veterinario, String> matricula;
	public static volatile ListAttribute<Veterinario, AgendaConsulta> agendaConsultaList;
	public static volatile SingularAttribute<Veterinario, String> nome;
	public static volatile SingularAttribute<Veterinario, Integer> id;

}

