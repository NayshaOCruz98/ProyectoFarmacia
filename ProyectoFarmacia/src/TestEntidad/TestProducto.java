package TestEntidad;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

import model.TbCategoria;
import model.TbProducto;

public class TestProducto {

	public static void main(String[] args) {
		//establecemos conexion con la entidad de persistencia 
		EntityManagerFactory emana =Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejamos las entidades
		EntityManager eman = emana.createEntityManager();
		eman.getTransaction().begin();
		//instanciamos las respectivas entidades
		TbCategoria tbcate=new TbCategoria();
		TbProducto tbprod=new TbProducto();
//		
//		//*******
//		tbcate.setNomcate("Generico");
//		tbcate.setDescrip("Producto de bajo precio y alto precio");
//		
//		//*****ingresamos datos  a la tabla prodcuto
//		tbprod.setNomprod("Cetirizina");
//		tbprod.setPrecio(14);
//		Date fech=new Date();
//		Date fechasql=new Date((fech.getTime()));
//		tbprod.setFechavenc(fechasql);
//		tbprod.setCodbarras("22420");
//		tbprod.setNrolote("L11422");
//		//asignamos el objeto tbcate
//		tbprod.setTbCategoria(tbcate);
//		//
//		eman.persist(tbprod);
//		//emitimos mensaje por pantalla
//		System.out.println("Datos registrados");
//		//confirmamos
//		eman.getTransaction().commit();
//		//cerramos
//		eman.close();
		
		//***Actualizar
		tbcate.setIdcategoria(1);
		tbcate.setNomcate("Generico");
		tbcate.setDescrip("Recomendado por el ministro de salud");
		tbprod.setIdproducto(1);
		tbprod.setNomprod("Paracetamol");
		tbprod.setPrecio(8);
		Date fech=new Date();
		Date fechasql=new Date((fech.getTime()));
		tbprod.setFechavenc(fechasql);
		tbprod.setCodbarras("22420");
		tbprod.setNrolote("L11422");
		//asignamos el objeto tbcate
		tbprod.setTbCategoria(tbcate);
		eman.merge(tbprod);
		//emitimos mensaje por pantalla
		System.out.println("Datos Actualizados");
		//confirmamos
		eman.getTransaction().commit();
		//cerramos
		eman.close();
		
		
		
		
		
	}//fin del metodo main
	
}//fin de la clase testproducto
