package interfaces;

import java.util.List;

import model.TbEmpleado;

public interface IEmpleadoable {
	//creamos los respectivos metodos
	public void RegistrarEmpleado(TbEmpleado tbemp);
	public void ActualizarEmpleado(TbEmpleado tbemp);
	public void EliminarEmpleado(TbEmpleado tbemp);
	public List<TbEmpleado> ListadoEmpleado();
	public TbEmpleado BuscarEmpleadoCodigo(TbEmpleado tbemp);
}
