package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consulta.class)
public abstract class Consulta_ {

	public static volatile SingularAttribute<Consulta, String> horaAtendimento;
	public static volatile SingularAttribute<Consulta, Date> dataAtendimento;
	public static volatile SingularAttribute<Consulta, AgendaConsulta> agendaConsultaId;
	public static volatile SingularAttribute<Consulta, Integer> id;

}

