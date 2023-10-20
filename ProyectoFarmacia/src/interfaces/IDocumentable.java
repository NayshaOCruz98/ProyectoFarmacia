package interfaces;

import java.util.List;

import model.TbDocumento;

public interface IDocumentable {
	//declaramos sus metodos
	public void RegistrarDocumento(TbDocumento tdocum);
	public void ActualizarDocumento(TbDocumento tdocum);
	public void EliminarDocumento(TbDocumento tdocum);
	public List<TbDocumento> ListadoDocumento();
	public TbDocumento BuscarDocumento(TbDocumento tdocum);
	
}//fin de la interface
