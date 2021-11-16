package uia.com.compras;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;
import java.lang.String;

public class PeticionOrdenCompra extends InfoComprasUIA
{
    private final String tipo;
    private  int id;
    private  String name;
    private int cantidad;
    private String unidad="";
    private String codigo="";



    @JsonCreator
    public PeticionOrdenCompra(@JsonProperty("id") int id, @JsonProperty("name") String name,
                               @JsonProperty("codigo") String codigo, @JsonProperty("unidad") String unidad,
                               @JsonProperty("cantidad") int cantidad, String tipo, String tipo1)
    {
        super(id, name);
        this.id = id;
        this.name = name;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.codigo = codigo;
        this.tipo = tipo1;
        this.setType(tipo);
    }

    public PeticionOrdenCompra(int id, String name, String descripcion, String pza, int pedidoProveedor, String itemsOPC, int id1, String tipo, String tipo1) {

        this.tipo = tipo1;
    }

    public PeticionOrdenCompra(String tipo) {

        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public java.lang.String getUnidad() {
        return unidad;
    }

    public void setUnidad(java.lang.String unidad) {
        this.unidad = unidad;
    }

    public java.lang.String getCodigo() {
        return codigo;
    }

    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }



    public PeticionOrdenCompra(int id, String tipo) {
        super(-1, "");
        this.id = id;
        this.tipo = tipo;
        name = null;
    }

    public void agregaItems(ListaReportesNivelStock miReporteNS)
    {
        PeticionOrdenCompra nodo;
        for(int i=0; i<miReporteNS.getItems().size(); i++)
        {
            InfoComprasUIA miNodo = miReporteNS.getItems().get(i);
            List<InfoComprasUIA> miLista;
            if(miNodo.getPedidoProveedor() > 0)
            {
                nodo = new PeticionOrdenCompra(miNodo.getId(), miNodo.getName(), miNodo.getDescripcion(),
                        "PZA", miNodo.getPedidoProveedor(), "itemsOPC", null);
                if(this.getItems() == null)
                {
                    miLista = new ArrayList<>();
                    this.setItems(miLista);
                }
                this.getItems().add(nodo);
            }
            miNodo.print();
        }

    }
}
