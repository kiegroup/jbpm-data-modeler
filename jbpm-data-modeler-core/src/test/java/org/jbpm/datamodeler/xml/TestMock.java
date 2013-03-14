package org.jbpm.datamodeler.xml;


import org.jbpm.datamodeler.xml.impl.DataModelMock;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TestMock {
    
    public static void main(String[] args) {

        try {
            new TestMock().marshal();

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    void marshal() throws JAXBException {

        DataModelMock mock = new DataModelMock();
        mock.setName("Modelo1");
        mock.setPackageName("org.jbpm.datamodeler.pojos");
        mock.getDataObjects().add("Objeto1");
        mock.getDataObjects().add("Objeto2");



        File file = new File("/tmp/file.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(DataModelMock.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(mock, file);
        jaxbMarshaller.marshal(mock, System.out);

        unmarshal();
    }

    void unmarshal() {

        try {

            File file = new File("/tmp/file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(DataModelMock.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DataModelMock mock = (DataModelMock) jaxbUnmarshaller.unmarshal(file);
            System.out.println(mock);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
