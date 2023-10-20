package TestEntidad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import model.TbCliente;

public class TestCliente {
	public static void main(String[] args) {
		//ESTABLECER la conexion con la unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//gestionar entidades como registrar, actualizar, listar,buscar
		EntityManager emamanager=conex.createEntityManager();
		//iniciamos transaccion
		emamanager.getTransaction().begin();
		
		//realizaremos una instancia
		TbCliente cliente = new TbCliente();
		//aplicaremos el switch..
		
			String accion=JOptionPane.showInputDialog("Ingrese la accion");
			switch(accion){
			
			case "Registrar":
				//ingresaremos valores a enviar a la base de datos
				cliente.setNombre("Carlos");
				cliente.setApellido("Panta");
				cliente.setEmail("Panzon@gmail.com");
				cliente.setDni("7847821");
				cliente.setSexo("Mascu");
				//registramos los datos con persist
				//persist insert into()
				emamanager.persist(cliente);
				//emitimos un mensaje por consolo
				System.out.println("Datos registrados en la BD");
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				break;
			case "Actualizar":
				cliente.setIdcliente(1);
				//ingresaremos valores a enviar a la base de datos
				cliente.setNombre("Naysha Nicoll");
				cliente.setApellido("Ortiz cruz");
//				cliente.setEmail("Mariolacruz@gmail.com");
//				cliente.setDni("00348652");
//				cliente.setSexo("Feme");
				//realizamos la actualizacion
				//update tbl_cliente set color=""
				emamanager.merge(cliente);
				//emitimos un mensaje por consola
				System.out.println("Datos actualizados en la BD");
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				break;
			case "Eliminar":
				//codigo a eliminar
				cliente.setIdcliente(4);
				TbCliente elim=emamanager.merge(cliente);
				//realizaremos la eliminacion
				//en jdbc delete from tbl_cliente where
				emamanager.remove(elim);//con el metodo remove eliminamos
				//imprimimos el mensaje
				System.out.println("Datos eliminados en la BD");
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				break;
			case "Buscar":
				//en jdbsc : select *from tb cliente where 
				TbCliente busc=emamanager.find(TbCliente.class,2);
				//aplicamos condicion
				if(busc==null){
					System.out.println("Registro no encontrado");
				}else{
					System.out.println("Registro encontrado");
					//imprimimos por pantalla las caracteristicas del registro
					System.out.println("codigo--> " + busc.getIdcliente() + "\n"+
							"nombre -->  "+busc.getNombre()+ "\n" +"Apellido--> "+busc.getApellido()+ "\n" +"Email--> "+
							busc.getEmail()+"\n"+ "Dni --> "+busc.getDni()+"\n"+ "Sexo-->"+busc.getSexo());
				}
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				//salimos
				break;
			case "Listar":
				List<TbCliente> listado=emamanager.createQuery("select a from TbCliente a",TbCliente.class).getResultList();
				for(TbCliente lis:listado){
					//imprimimos dentro del bucle
					System.out.println("-----------------\n"+"codigo--> " + lis.getIdcliente() + "\n"+
							"nombre -->  "+lis.getNombre()+ "\n" +"Apellido--> "+lis.getApellido()+ "\n" +"Email--> "+
							lis.getEmail()+"\n"+ "Dni --> "+lis.getDni()+"\n"+ "Sexo-->"+lis.getSexo());
				}//fin del bucle for 
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				//salimos
				break;
				default:
						//emitimos mensajes nos pantalla
						System.out.println("Accion no encontrada");
						//salimos
						break;
			} //fin del switch
			
		
	}
}
