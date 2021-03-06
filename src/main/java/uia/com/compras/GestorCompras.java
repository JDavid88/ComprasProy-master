package uia.com.compras;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author amiguel
 * @version 1.0
 * @created 12-nov.-2019 11:27:37 a. m.
 */
public class GestorCompras {
	private int opcion;
	//private ListaKClientes miReportname = "Cartucho Tóner"eNS;
    private ListaReportesNivelStock miReporteNS=null;
    //private String name;
    private PeticionOrdenCompra miPeticionOC;

    {
        assert miReporteNS != null;
        miPeticionOC = new PeticionOrdenCompra(miReporteNS.getName());
    }

    public GestorCompras()
	{
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            mapper.writeValue(new FileOutputStream("C:\\Users\\David\\IdeaProjects\\ComprasProy-master\\peticionOrdenCompraV3.json"), miReporteNS);
            /*mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			miReporteNS = mapper.readValue(new FileInputStream("C:\\Users\\David\\IdeaProjects\\ComprasProy-master\\peticionOrdenCompraV3.json"), miReporteNS );
            */
        }
        catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (miReporteNS != null)
        {
            miPeticionOC.agregaItems(miReporteNS);

            System.out.println("----- Items List -----");

            for(int i=0; i<miReporteNS.getItems().size(); i++) {
                InfoComprasUIA miNodo = miReporteNS.getItems().get(i);
                miNodo.print();
            }


            try {
                mapper.writeValue(new FileOutputStream("C:\\TSU-2022\\ComprasProy\\peticionOrdenCompraV2.json"), miPeticionOC);
            }
            catch (JsonParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

	}


    public void print()
    {

    }
}//end KardexListaKClientes