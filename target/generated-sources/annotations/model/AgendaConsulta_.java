package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AgendaConsulta.class)
public abstract class AgendaConsulta_ {

	public static volatile ListAttribute<AgendaConsulta, Consulta> consultaList;
	public static volatile SingularAttribute<AgendaConsulta, String> atendido;
	public static volatile SingularAttribute<AgendaConsulta, Date> dataAgendamento;
	public static volatile SingularAttribute<AgendaConsulta, Integer> id;
	public static volatile SingularAttribute<AgendaConsulta, String> horarioAgendamento;
	public static volatile SingularAttribute<AgendaConsulta, String> status;
	public static volatile SingularAttribute<AgendaConsulta, Animal> animalCodigo;
	public static volatile SingularAttribute<AgendaConsulta, Veterinario> veterinarioId;

}

