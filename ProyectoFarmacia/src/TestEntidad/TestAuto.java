package TestEntidad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.TbAuto;
public class TestAuto {
	public static void main(String[] args) {
		//ESTABLECER la conexion con la unidad de persistencia
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDAutoJPA");
		//gestionar entidades como registrar, actualizar, listar,buscar
		EntityManager emamanager=conex.createEntityManager();
		//iniciamos transaccion
		emamanager.getTransaction().begin();
		
		//realizaremos una instancia
		TbAuto auto = new TbAuto();
		//aplicaremos el switch..
		
			String accion=JOptionPane.showInputDialog("Ingrese la accion");
			switch(accion){
			
			case "Registrar":
				//ingresaremos valores a enviar a la base de datos
				auto.setColor("Rojo");
				auto.setModelo("civic");
				auto.setPrecio(17000);
				auto.setMarca("Honda");
				auto.setFabricacion("2022");
				//registramos los datos con persist
				//persist insert into()
				emamanager.persist(auto);
				//emitimos un mensaje por consolo
				System.out.println("Datos registrados en la BD");
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				break;
			case "Actualizar":
				auto.setIdauto(4);
				//ingresaremos valores a enviar a la base de datos
				auto.setColor("Verde");
				auto.setModelo("Huracán");
				auto.setPrecio(904000);
				auto.setMarca("Lamborghini");
				auto.setFabricacion("2023");
				//realizamos la actualizacion
				//update tbl_auto set color=""
				emamanager.merge(auto);
				//emitimos un mensaje por consola
				System.out.println("Datos actualizados en la BD");
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				break;
			case "Eliminar":
				//codigo a eliminar
				auto.setIdauto(4);
				TbAuto elim=emamanager.merge(auto);
				//realizaremos la eliminacion
				//en jdbc delete from tbl_auto where
				emamanager.remove(elim);//con el metodo remove eliminamos
				//imprimimos el mensaje
				System.out.println("Datos eliminados en la BD");
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				break;
			case "Buscar":
				//en jdbsc : select *from tb auto where 
				TbAuto busc=emamanager.find(TbAuto.class,2);
				//aplicamos condicion
				if(busc==null){
					System.out.println("Registro no encontrado");
				}else{
					System.out.println("Registro encontrado");
					//imprimimos por pantalla las caracteristicas del registro
					System.out.println("codigo--> " + busc.getIdauto() + "\n"+
							"color -->  "+busc.getColor()+ "\n" +"modelo--> "+busc.getModelo()+ "\n" +"precio--> "+
							busc.getPrecio()+"\n"+ "marca --> "+busc.getMarca()+"\n"+ "fabricacion-->"+busc.getFabricacion());
				}
				//confirmamos
				emamanager.getTransaction().commit();
				//cerramos la transaccion
				emamanager.close();
				//salimos
				break;
			case "Listar":
				List<TbAuto> listado=emamanager.createQuery("select a from TbAuto a",TbAuto.class).getResultList();
				for(TbAuto lis:listado){
					//imprimimos dentro del bucle
					System.out.println("-----------------\n"+"codigo--> " + lis.getIdauto() + "\n"+
							"color -->  "+lis.getColor()+ "\n" +"modelo--> "+lis.getModelo()+ "\n" +"precio--> "+
							lis.getPrecio()+"\n"+ "marca --> "+lis.getMarca()+"\n"+ "fabricacion-->"
							+lis.getFabricacion());
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
			case "eliminar2":
				//eliminando el codigo numero 3
				TbAuto elimi2=emamanager.find(TbAuto.class, 3);
				//aplicamos una condicion..
				if(elimi2==null){
					//emitimos un mensaje..
					System.out.println("El codigo no existe en BD!!!!");	
				}else{
					//emitimos un mensaje por pantalla..
					System.out.println("Registro Encontrado");
					//eliminamos el registro..
					emamanager.remove(elimi2);
					//confirmamos
					emamanager.getTransaction().commit();
					//cerramos
					emamanager.close();		
					//emitimos mensaje por consola..
					System.out.println("Codigo Eliminado de la BD!!!  ...");
				}
				break;			
			} //fin del switch
		
	}
}
