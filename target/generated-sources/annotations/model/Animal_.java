package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Animal.class)
public abstract class Animal_ {

	public static volatile SingularAttribute<Animal, String> especie;
	public static volatile SingularAttribute<Animal, Integer> codigo;
	public static volatile SingularAttribute<Animal, Double> peso;
	public static volatile SingularAttribute<Animal, Rotina> rotinaCodigo;
	public static volatile SingularAttribute<Animal, BoletimSaude> boletimSaudeId;
	public static volatile ListAttribute<Animal, Tratador> tratadorList;
	public static volatile ListAttribute<Animal, AgendaConsulta> agendaConsultaList;
	public static volatile SingularAttribute<Animal, String> nome;
	public static volatile SingularAttribute<Animal, String> regiaoOrigem;
	public static volatile SingularAttribute<Animal, Date> dataNascimento;
	public static volatile ListAttribute<Animal, Boletim> boletimList;

}

