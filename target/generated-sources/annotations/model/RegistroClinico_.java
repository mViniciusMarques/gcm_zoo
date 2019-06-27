package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegistroClinico.class)
public abstract class RegistroClinico_ {

	public static volatile SingularAttribute<RegistroClinico, String> diagnostico;
	public static volatile SingularAttribute<RegistroClinico, BoletimSaude> boletimSaudeId;
	public static volatile ListAttribute<RegistroClinico, Vacina> vacinaList;
	public static volatile SingularAttribute<RegistroClinico, String> observacaoGeral;
	public static volatile SingularAttribute<RegistroClinico, Integer> id;
	public static volatile SingularAttribute<RegistroClinico, String> tipoAtendimento;
	public static volatile SingularAttribute<RegistroClinico, Veterinario> veterinarioId;

}

