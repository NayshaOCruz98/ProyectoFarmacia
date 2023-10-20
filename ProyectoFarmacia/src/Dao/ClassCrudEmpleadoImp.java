package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IEmpleadoable;
import model.TbEmpleado;

public class ClassCrudEmpleadoImp implements IEmpleadoable {

	@Override
	public void RegistrarEmpleado(TbEmpleado tbemp) {
		// TODO Auto-generated method stub
		//establece conexion con la unidad de persistence 
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		//registramos datos 
		emanager.persist(tbemp);
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	}

	@Override
	public void ActualizarEmpleado(TbEmpleado tbemp) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		//actualizamos datos
		emanager.merge(tbemp);
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	}

	@Override
	public void EliminarEmpleado(TbEmpleado tbemp) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		
		//recuperar el codigo a eliminar
		TbEmpleado elim=emanager.merge(tbemp);
		emanager.remove(elim);
		System.out.println("Dato eliminado de la BD!!!");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	}
		


	@Override
	public List<TbEmpleado> ListadoEmpleado() {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		
		//aplicamos el JPQL se basa en entidades
		List<TbEmpleado> listado=emanager.createQuery("select e from TbEmpleado e", TbEmpleado.class).getResultList();
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		return listado;
	}

	@Override
	public TbEmpleado BuscarEmpleadoCodigo(TbEmpleado tbemp) {
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		TbEmpleado buscar=emanager.find(TbEmpleado.class,tbemp.getIdempleado());
		return buscar;
	}

} //fin de la clase
