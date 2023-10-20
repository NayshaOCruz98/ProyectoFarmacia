package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IDocumentable;
import model.TbDocumento;
import model.TbEmpleado;

public class ClassCrudDocumentoImp implements IDocumentable{

	@Override
	public void RegistrarDocumento(TbDocumento tdocum) {
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
				emanager.persist(tdocum);
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
	}

	@Override
	public void ActualizarDocumento(TbDocumento tdocum) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		//actualizamos datos
		emanager.merge(tdocum);
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}

	@Override
	public void EliminarDocumento(TbDocumento tdocum) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		
		//recuperar el codigo a eliminar
		TbDocumento elim=emanager.merge(tdocum);
		emanager.remove(elim);
		System.out.println("Dato eliminado de la BD!!!");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}

	@Override
	public List<TbDocumento> ListadoDocumento() {
		// TODO Auto-generated method stub
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		
		//aplicamos el JPQL se basa en entidades
		List<TbDocumento> listado=emanager.createQuery("select e from TbDocumento e", TbDocumento.class).getResultList();
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		return listado;
	}

	@Override
	public TbDocumento BuscarDocumento(TbDocumento tdocum) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		//nos sirve para generar el crud
		EntityManager emanager=conex.createEntityManager();
		//realizamos el proceso
			//iniciamos el proceso
		emanager.getTransaction().begin();
		TbDocumento buscar=emanager.find(TbDocumento.class,tdocum.getIdDocumento());
		return buscar;
	}

}
