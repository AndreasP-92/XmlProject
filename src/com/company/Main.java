package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class Main {



    public static void main(String[] args) {
        try {

            File fXmlFile = new File("/Users/mkyong/staff.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("staff");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
   // Main(){

    //}

    // private void writeProductsXLM() throws ParserConfigurationException {
        // DocumentBuilderFactory
       // DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        // DocumentBuilder
        //DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        // Document
        //Document xmlDoc = docBuilder.newDocument();


        // Build XML Elements and Text Nodes
        //<products>
        //  <product>
        //  <name sku"123456">Designer Plate</>
        //  </product>
        //</products>

        //Element rootElement = xmlDoc.createElement("products");

        //Element mainElement = xmlDoc.createElement("product");
        //mainElement.setAttribute("sku","123456");

        //Text productNameText = xmlDoc.createTextNode("Designer Plate");
        //Element productName = xmlDoc.createElement("name");
        //productName.appendChild(productNameText);

        //mainElement.appendChild(productName);

        //rootElement.appendChild(mainElement);

        //xmlDoc.appendChild(rootElement);

        // Set OutputFormat


        // Declare the File
        // Declare the FileOutputStream

        // XMLSerializer to serialize the XML data with
        // the specified output format
    //}