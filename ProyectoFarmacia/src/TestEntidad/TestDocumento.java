package TestEntidad;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TbCliente;
import model.TbDocumento;
import model.TbTipodocumento;

public class TestDocumento {
	public static void main(String[] args) {
		//establecer conexion con la unidad de persistencia
		EntityManagerFactory facto=Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejar las entidades
		EntityManager entima=facto.createEntityManager();	
		//iniciamos las transaccion
		entima.getTransaction().begin();
		//instanciar las entidades 
		TbTipodocumento tipodoc=new TbTipodocumento();
		TbDocumento tdocu=new TbDocumento();
//		//ingresamos nuevos valores
//		tipodoc.setNomdocu("Proforma");
//		tipodoc.setDescripcion("proforma de producto");
//		entima.persist(tipodoc);//aceptamos los datos
//		tdocu.setNroDocumento("1455");
//		tdocu.setProveDocument("Farma curando S.A.A");
//		tdocu.setRucDocument("2078545566");
//		Date fecha = new Date();
//		Date fechasql = new Date();
//		tdocu.setFecha(fechasql);
//		tdocu.setDescripciondocument("Mostrar precios al cliente");
//		tdocu.setTbTipodocumento(tipodoc);
//		entima.persist(tdocu);
//		//emitimos por consola
//		System.out.println("Dato registrado");
//		//confirmamos
//		entima.getTransaction().commit();
//		//cerramos
//		entima.close();
		
		//ejemplo de ******Actualizar*****
//		tipodoc.setIdtipoDoc(1);
//		tipodoc.setNomdocu("ticket");
//		tipodoc.setDescripcion("para llevar control interno");
//		entima.merge(tipodoc);
//		tdocu.setIdDocumento(1);
//		tdocu.setNroDocumento("785669");
//		tdocu.setProveDocument("policlinico lima");
//		tdocu.setRucDocument("2020156465");
//		Date fecha = new Date();
//		Date fechasql = new Date(fecha.getTime());
//		tdocu.setFecha(fechasql);
//		tdocu.setDescripciondocument("comprobante de pago");
//		tdocu.setTbTipodocumento(tipodoc);
//		entima.merge(tdocu);
//		//emitamos mensaje por consola
//		System.out.println("datos actualizado");
//		//confimamos 
//		entima.getTransaction().commit();
//		//cerramos
//		entima.close();
		
		
		//listado
//		List<TbDocumento> listado=entima.createQuery("select docu from TbDocumento docu",TbDocumento.class).getResultList();
//		//aplicamos el bucle for
//		for(TbDocumento lis:listado){
//			//imprimimos dentro del bucle
//			System.out.println("-----------------\n"+"codigo--> " + lis.getIdDocumento() + "\n"+
//					"nro documento -->  "+lis.getNroDocumento()+ "\n" +"nombre proveedor--> "+lis.getProveDocument()+ "\n" +"ruc documento--> "+
//					lis.getRucDocument()+"\n"+ "Fecha --> "+lis.getFecha()+"\n"+ "Descrip document-->"+lis.getDescripciondocument()+"\n"+ "codigo tipo documentio-->"+lis.getTbTipodocumento().getIdtipoDoc()+"\n"+ "Descrip document-->"+
//					"nombre documento ----> "+lis.getTbTipodocumento().getNomdocu());
//		}//fin del bucle for 
//		//confirmamos
//		entima.getTransaction().commit();
//		//cerramos
//		entima.close();
		
		//buscar por codigo
//		TbDocumento buscar=entima.find(TbDocumento.class, 3);
//		//imprimos mensaje por pantalla
//		System.out.println("-----------------\n"+"codigo--> " + buscar.getIdDocumento() + "\n"+
//				"nro documento -->  "+buscar.getNroDocumento()+ "\n" +"nombre proveedor--> "+buscar.getProveDocument()+ "\n" +"ruc documento--> "+
//				buscar.getRucDocument()+"\n"+ "Fecha --> "+buscar.getFecha()+"\n"+ "Descrip document-->"+buscar.getDescripciondocument()+"\n"+ "codigo tipo documentio-->"+buscar.getTbTipodocumento().getIdtipoDoc()+"\n"+ "Descrip document-->"+
//				"nombre documento ----> "+buscar.getTbTipodocumento().getNomdocu());
//		//confirmamos
//		entima.getTransaction().commit();
//		//cerramos
//		entima.close();
		//ejemplo de eliminar
		tipodoc.setIdtipoDoc(1);
		TbTipodocumento elim=entima.merge(tipodoc);
		entima.remove(elim);
		tdocu.setIdDocumento(1);
		TbDocumento elimi=entima.merge(tdocu);
		entima.remove(elimi);
		System.out.println("Dato eliminado");
		entima.getTransaction().commit();
		entima.close();
		
		
		}
}
