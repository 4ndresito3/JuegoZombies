/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author hkiva
 */
public class Persistencia {
    
    public static void guardarJuego() {
    try {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("juego");
        doc.appendChild(rootElement);
        
        Element turnoElement = doc.createElement("turnoJugador");
        turnoElement.appendChild(doc.createTextNode(String.valueOf(Juego.getTurnoJugador())));
        rootElement.appendChild(turnoElement);

        Element supervivientesElement = doc.createElement("supervivientes");
        for (Superviviente superviviente : Juego.getSupervivientes()) {
            Element supervivienteElement = doc.createElement("superviviente");
            
            Element nombreElement = doc.createElement("nombre");
            nombreElement.appendChild(doc.createTextNode(superviviente.getNombre()));
            supervivienteElement.appendChild(nombreElement);
            
            Element posicionElement = doc.createElement("posicion");
            posicionElement.appendChild(doc.createTextNode(superviviente.devolverCoordenada().toString()));
            supervivienteElement.appendChild(posicionElement);
            
            // Crear método vivotoString()
            Element vivoElement = doc.createElement("vivo");
            vivoElement.appendChild(doc.createTextNode(String.valueOf(superviviente.isVivo())));
            supervivienteElement.appendChild(vivoElement);
            
            Element numAccionesElement = doc.createElement("numAcciones");
            numAccionesElement.appendChild(doc.createTextNode(String.valueOf(superviviente.getNumAcciones())));
            supervivienteElement.appendChild(numAccionesElement);
            
            Element elimZombiesElement = doc.createElement("elimZombies");
            elimZombiesElement.appendChild(doc.createTextNode(String.valueOf(superviviente.getElimZombies())));
            supervivienteElement.appendChild(elimZombiesElement);
            
            Element heridasElement = doc.createElement("heridas");
            heridasElement.appendChild(doc.createTextNode(String.valueOf(superviviente.getHeridas())));
            supervivienteElement.appendChild(heridasElement);
            
            Element armasActElement = doc.createElement("armasActivas");
            for(EArmas arma : superviviente.getArmasActivas()){
                Element armaElement = doc.createElement("arma");
                
                Element nombreArmaElement = doc.createElement("nombre");                
                nombreArmaElement.appendChild(doc.createTextNode(arma.getNombre()));
                armaElement.appendChild(nombreArmaElement);
                
                Element potenciaArmaElement = doc.createElement("potencia");                
                potenciaArmaElement.appendChild(doc.createTextNode(String.valueOf(arma.getPotencia())));
                armaElement.appendChild(potenciaArmaElement);
                
                Element alcanceArmaElement = doc.createElement("alcanceMax");                
                alcanceArmaElement.appendChild(doc.createTextNode(String.valueOf(arma.getAlcanceMax())));
                armaElement.appendChild(alcanceArmaElement);
                
                Element dadosArmaElement = doc.createElement("numDados");                
                dadosArmaElement.appendChild(doc.createTextNode(String.valueOf(arma.getNumDados())));
                armaElement.appendChild(dadosArmaElement);
                
                Element exitoArmaElement = doc.createElement("valorExito");                
                exitoArmaElement.appendChild(doc.createTextNode(String.valueOf(arma.getValorExito())));
                armaElement.appendChild(exitoArmaElement);
                
                armasActElement.appendChild(armaElement);
            }
            supervivienteElement.appendChild(armasActElement);
            
            Element inventarioElement = doc.createElement("inventario");
            for (Equipo equipo : superviviente.getInventario()) {
                if (equipo instanceof EArmas) {
                    Element armaElement = doc.createElement("arma");
                    
                    Element nombreArmaElement = doc.createElement("nombre");
                    nombreArmaElement.appendChild(doc.createTextNode(equipo.getNombre()));
                    armaElement.appendChild(nombreArmaElement);
                    
                    Element potenciaElement = doc.createElement("potencia");
                    potenciaElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).getPotencia())));
                    armaElement.appendChild(potenciaElement);
                    
                    Element alcanceMaxElement = doc.createElement("alcanceMax");
                    alcanceMaxElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).getAlcanceMax())));
                    armaElement.appendChild(alcanceMaxElement);
                            
                    Element numDadosElement = doc.createElement("numDados");
                    numDadosElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).getNumDados())));
                    armaElement.appendChild(numDadosElement);
                    
                    Element valorExitoElement = doc.createElement("valorExito");
                    valorExitoElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).getValorExito())));
                    armaElement.appendChild(valorExitoElement);
                    
                    inventarioElement.appendChild(armaElement);
                } else if (equipo instanceof EProvisiones) {
                    Element provisionElement = doc.createElement("provision");
                    
                    Element nombreProvisionElement = doc.createElement("nombre");
                    nombreProvisionElement.appendChild(doc.createTextNode(equipo.getNombre()));
                    provisionElement.appendChild(nombreProvisionElement);
                    
                    Element valorEnergeticoElement = doc.createElement("valorEnergetico");
                    valorEnergeticoElement.appendChild(doc.createTextNode(String.valueOf(((EProvisiones) equipo).getValorEnergetico())));
                    provisionElement.appendChild(valorEnergeticoElement);
                    
                    Element fechaCaducidadElement = doc.createElement("fechaCaducidad");
                    fechaCaducidadElement.appendChild(doc.createTextNode(String.valueOf(((EProvisiones) equipo).getCaducidad())));
                    provisionElement.appendChild(fechaCaducidadElement);
                    
                    inventarioElement.appendChild(provisionElement);
                }
            }
            supervivienteElement.appendChild(inventarioElement);
            
            Element exitosElement = doc.createElement("exitos");
            exitosElement.appendChild(doc.createTextNode(String.valueOf(superviviente.getExitos())));
            supervivienteElement.appendChild(exitosElement);
            
            supervivientesElement.appendChild(supervivienteElement);
        }
        rootElement.appendChild(supervivientesElement);
        
        Element zombiesElement = doc.createElement("zombies");
        for (Zombi zombi : Juego.getZombis()) {
            Element preZombiElement = doc.createElement("zombi");
            
            Element zombiElement = doc.createElement("clase");
            zombiElement.appendChild(doc.createTextNode(zombi.obtenerTipo()));
            preZombiElement.appendChild(zombiElement);
            
            Element posicionElement = doc.createElement("posicion");
            posicionElement.appendChild(doc.createTextNode((zombi.devolverCoordenada().toString())));
            preZombiElement.appendChild(posicionElement);
            
            Element vivoElement = doc.createElement("vivo");
            vivoElement.appendChild(doc.createTextNode(String.valueOf(zombi.isVivo())));
            preZombiElement.appendChild(vivoElement);
           
            zombiesElement.appendChild(preZombiElement);
         }
        rootElement.appendChild(zombiesElement);
        
        Element objetivoElement = doc.createElement("objetivo");
        objetivoElement.appendChild(doc.createTextNode(Juego.getObjetivo().toString()));
        rootElement.appendChild(objetivoElement);
        
        Element tamanoCuadriculaElement = doc.createElement("tamanoCuadricula");
        tamanoCuadriculaElement.appendChild(doc.createTextNode(Juego.getTamanoCuadricula().toString()));
        rootElement.appendChild(tamanoCuadriculaElement);
        
        Element casillasBuscadasElement = doc.createElement("listaCasillasBuscadas");
        for(Punto casilla: Juego.getListaCasillasBuscadas()) {
            Element casillaElement = doc.createElement("casilla");
            casillaElement.appendChild(doc.createTextNode(casilla.toString()));
            casillasBuscadasElement.appendChild(casillaElement);
        }
        rootElement.appendChild(casillasBuscadasElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src\\juegozombies\\partidaZombiesGuardada.xml"));
        transformer.transform(source, result);
        
    } catch (ParserConfigurationException | TransformerConfigurationException e) {
        e.printStackTrace();
    } catch (TransformerException e) {
        e.printStackTrace();
    }
    
    }
    
    public static Juego cargarJuego() {
    try {
        Juego juego = new Juego();
        File archivoXML = new File("src\\juegozombies\\partidaZombiesGuardada.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(archivoXML);
        doc.getDocumentElement().normalize();

        Node turnoNode = doc.getElementsByTagName("turnoJugador").item(0);
        juego.setTurnoJugador(Integer.parseInt(turnoNode.getTextContent()));
        
        ArrayList<Superviviente> listaSupervivientes = new ArrayList<>();
        NodeList listSupervivientes = doc.getElementsByTagName("superviviente");
        for (int i = 0; i < listSupervivientes.getLength(); i++) {
            Node nodoSuperviviente = listSupervivientes.item(i);
            if (nodoSuperviviente.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoSuperviviente = (Element) nodoSuperviviente;
                String nombre = elementoSuperviviente.getElementsByTagName("nombre").item(0).getTextContent();
                Punto prePosicion = new Punto();
                Punto posicion = prePosicion.parsePunto(elementoSuperviviente.getElementsByTagName("posicion").item(0).getTextContent());
                Superviviente superviviente = new Superviviente(nombre, posicion);
                Boolean vivo = Boolean.parseBoolean(elementoSuperviviente.getElementsByTagName("vivo").item(0).getTextContent());
                superviviente.setVivo(vivo);
                int numAcciones = Integer.parseInt(elementoSuperviviente.getElementsByTagName("numAcciones").item(0).getTextContent());
                superviviente.setNumAcciones(numAcciones);
                int elimZombies = Integer.parseInt(elementoSuperviviente.getElementsByTagName("elimZombies").item(0).getTextContent());
                superviviente.setElimZombies(elimZombies);
                int heridas = Integer.parseInt(elementoSuperviviente.getElementsByTagName("heridas").item(0).getTextContent());
                superviviente.setHeridas(heridas);
                
                Element elementoActiva = (Element) elementoSuperviviente.getElementsByTagName("armasActivas").item(0);
                NodeList activaNodeList = elementoActiva.getChildNodes();
                ArrayList<EArmas> armasActivas = new ArrayList<>();
                for(int j=0; j < activaNodeList.getLength(); j++){
                    Node activaNode = activaNodeList.item(j);
                    if (activaNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element actElement = (Element) activaNode;
                        String nombreArma = actElement.getElementsByTagName("nombre").item(0).getTextContent();
                        int potencia = Integer.parseInt(actElement.getElementsByTagName("potencia").item(0).getTextContent());
                        int alcanceMax = Integer.parseInt(actElement.getElementsByTagName("alcanceMax").item(0).getTextContent());
                        int numDados = Integer.parseInt(actElement.getElementsByTagName("numDados").item(0).getTextContent());
                        int valorExito = Integer.parseInt(actElement.getElementsByTagName("valorExito").item(0).getTextContent());
                        EArmas arma = new EArmas(nombreArma, potencia, alcanceMax, numDados, valorExito);
                        armasActivas.add(arma);
                    }   
                }
                superviviente.setArmasActivas(armasActivas);
                
                Element elementoInventario = (Element) elementoSuperviviente.getElementsByTagName("inventario").item(0);
                NodeList equiposNodeList = elementoInventario.getChildNodes();
                ArrayList<Equipo> inventario = new ArrayList<>();
                
                for(int j = 0; j < equiposNodeList.getLength(); j++) {
                    Node equipoNode = equiposNodeList.item(j);

                if (equipoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element equipoElement = (Element) equipoNode;
                    
                if (equipoElement.getNodeName().equals("arma")) {
                    
                    String nombreArma = equipoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    int potencia = Integer.parseInt(equipoElement.getElementsByTagName("potencia").item(0).getTextContent());
                    int alcanceMax = Integer.parseInt(equipoElement.getElementsByTagName("alcanceMax").item(0).getTextContent());
                    int numDados = Integer.parseInt(equipoElement.getElementsByTagName("numDados").item(0).getTextContent());
                    int valorExito = Integer.parseInt(equipoElement.getElementsByTagName("valorExito").item(0).getTextContent());
                    EArmas arma = new EArmas(nombreArma, potencia, alcanceMax, numDados, valorExito);
                    inventario.add(arma);
                } else if (equipoElement.getNodeName().equals("provision")) {
            
                    String nombreProvision = equipoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    int valorEnergetico = Integer.parseInt(equipoElement.getElementsByTagName("valorEnergetico").item(0).getTextContent());
                    String fechaCaducidad = equipoElement.getElementsByTagName("fechaCaducidad").item(0).getTextContent();

                    EProvisiones provision = new EProvisiones(nombreProvision, valorEnergetico);
                    provision.setCaducidad(fechaCaducidad);
                    inventario.add(provision);
                    }
                }
            }
                superviviente.setInventario(inventario);
        
                int exitos = Integer.parseInt(elementoSuperviviente.getElementsByTagName("exitos").item(0).getTextContent());
                superviviente.setExitos(exitos);
                listaSupervivientes.add(superviviente);
            }
        }
        
        juego.setSupervivientes(listaSupervivientes);
        
        ArrayList<Zombi> listaZombies = new ArrayList<>();
        NodeList listZombies = doc.getElementsByTagName("zombi");
        for (int i = 0; i < listZombies.getLength(); i++) {
            Node nodoZombi = listZombies.item(i);
            if (nodoZombi.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoZombi = (Element) nodoZombi;
                Punto prePosicion = new Punto();
                Punto posicion = prePosicion.parsePunto(elementoZombi.getElementsByTagName("posicion").item(0).getTextContent());
                Boolean vivo = Boolean.parseBoolean(elementoZombi.getElementsByTagName("vivo").item(0).getTextContent());
                String clase = elementoZombi.getElementsByTagName("clase").item(0).getTextContent(); 
                switch (clase){
                    case "ZAbominacionBerserker" -> {
                        ZAbominacionBerserker zombi = new ZAbominacionBerserker(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                    
                    case "ZAbominacionNormal" ->{
                        ZAbominacionNormal zombi = new ZAbominacionNormal(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                    
                    case "ZAbominacionToxico" -> {
                        ZAbominacionToxico zombi = new ZAbominacionToxico(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                    
                    case "ZCaminanteBerserker" -> {
                        ZCaminanteBerserker zombi = new ZCaminanteBerserker(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                    
                    case "ZCaminanteNormal" -> {
                        ZCaminanteNormal zombi = new ZCaminanteNormal(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                    
                    case "ZCaminanteToxico" -> {
                        ZCaminanteToxico zombi = new ZCaminanteToxico(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                    
                    case "ZCorredorBerserker" -> {
                        ZCorredorBerserker zombi = new ZCorredorBerserker(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                        
                    case "ZCorredorNormal" -> {
                        ZCorredorNormal zombi = new ZCorredorNormal(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                    
                    case "ZCorredorToxico" -> {
                        ZCorredorToxico zombi = new ZCorredorToxico(posicion, vivo);
                        listaZombies.add(zombi);
                    }
                 }
            }
        }
        
        juego.setZombis(listaZombies);
        
        Node objetivoNode = doc.getElementsByTagName("objetivo").item(0);
        Punto obj = new Punto();
        juego.setObjetivo(obj.parsePunto(objetivoNode.getTextContent()));
        
        Node tamanoCuadriculaNode = doc.getElementsByTagName("tamanoCuadricula").item(0);
        Punto tamanoCuadricula = new Punto();
        juego.setTamanoCuadricula(tamanoCuadricula.parsePunto(tamanoCuadriculaNode.getTextContent()));
        
        Element elementoCasillasBuscadas = (Element) doc.getElementsByTagName("listaCasillasBuscadas").item(0);
        NodeList casillasBuscadas = elementoCasillasBuscadas.getChildNodes();
        ArrayList<Punto> listaCasillasBuscadas = new ArrayList<>();
        
        for (int i = 0; i < casillasBuscadas.getLength(); ++i) {
            Node casillaNode = casillasBuscadas.item(i);
            
            if (casillaNode.getNodeType() == Node.ELEMENT_NODE) {
                Element casillaElement = (Element) casillaNode;
                Punto casilla = new Punto();
                casilla.parsePunto(casillaElement.getTextContent());
                listaCasillasBuscadas.add(casilla);
            }
        }
        
        juego.setListaCasillasBuscadas(listaCasillasBuscadas);      
        return juego;
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
        return null;
    }

    
}
}
