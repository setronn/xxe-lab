package com.example.demo;

import org.springframework.stereotype.Service;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


@Service
public class MyXMLService {

    public Employee fromXml(String xml, String xsdResourceName) throws Exception {
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File file = new File(xsdResourceName);
        Schema schema = sf.newSchema(file);
        jaxbUnmarshaller.setSchema(schema);

        StringReader stringReader = new StringReader(xml);
        Employee employee = (Employee) jaxbUnmarshaller.unmarshal(stringReader);
        return employee;

        
    }

}

