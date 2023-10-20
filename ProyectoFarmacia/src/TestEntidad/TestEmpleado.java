package TestEntidad;

import java.sql.Date;
import java.util.List;

import Dao.ClassCrudEmpleadoImp;
import model.TbEmpleado;

public class TestEmpleado {
	public static void main(String[] args) {
		//realizamos las registramos respectivas instancias 
		TbEmpleado tbemp=new TbEmpleado();
		ClassCrudEmpleadoImp crud=new ClassCrudEmpleadoImp();
		//ingresamos valores
//		tbemp.setNombre("Johan Paul");
//		tbemp.setApellido("Atoche Seminario");
//		tbemp.setSexo("M");
//		tbemp.setEmail("JohanAtoche@gmail.com");
//		tbemp.setDni("75426588");
//		tbemp.setTelefono("982782145");
//		//convertidores la fecha a javasql
//		Date fecha=new Date(1);
//		Date fechasql=new Date(fecha.getTime());
//		tbemp.setFechanac(fechasql);
//		//invocamos el metodo registrar
//		crud.RegistrarEmpleado(tbemp);
//		//emitimos un mensaje por consola
//		System.out.println("datos registrados correctamente");
		
		//***testeando actualizar empleado**//
//		tbemp.setIdempleado(2);
//		tbemp.setNombre("pablo jesus");
//		tbemp.setApellido("atoche seminario");
//		tbemp.setSexo("M");
//		tbemp.setEmail("pablojesus@gmail.com");
//		tbemp.setDni("22562152");
//		tbemp.setTelefono("789245212");
//		//convertimos la fecha a javasql
//		Date fecha=new Date(3);
//		Date fechasql=new Date(fecha.getTime());
//		tbemp.setFechanac(fechasql);
//		//invocamos el metodo actualizar
//		crud.ActualizarEmpleado(tbemp);
//		//emitimos mensaje por consola
//		System.out.println("datos actualizados");
		
		//***testeando el metodo eliminar***//
//		tbemp.setIdempleado(2);
//		crud.EliminarEmpleado(tbemp);
		
		//***testeando el listado
//		List<TbEmpleado>listar=crud.ListadoEmpleado();
//		//aplicamos el bucle
//		for(TbEmpleado lis:listar){
//			//imprimimos por pantalla
//			System.out.println("codigo: "+lis.getIdempleado()+" nombre: "+lis.getNombre()+" apellido: "+lis.getApellido()+
//					" sexo: "+lis.getSexo()+" email: "+lis.getEmail()+" telefono: "+lis.getTelefono()+" fecha_nacimiento: "+
//					lis.getFechanac());
//		}//fin del bucle
		//****testenado el metodo buscar
		tbemp.setIdempleado(4);
		TbEmpleado buscod=crud.BuscarEmpleadoCodigo(tbemp);
		//imprimimos por pantalla
		System.out.println("codigo: "+buscod.getIdempleado()+" nombre: "+buscod.getNombre()+" apellido: "+buscod.getApellido()+
				" sexo: "+buscod.getSexo()+" email: "+buscod.getEmail()+" telefono: "+buscod.getTelefono()+" fecha_nacimiento: "+
				buscod.getFechanac());
		
		
		
	}
}
