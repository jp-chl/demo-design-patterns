package com.jpvr.demodesignpatterns.dp.creational;

import com.jpvr.demodesignpatterns.dp.creational.factory.creditcard.CardType;
import com.jpvr.demodesignpatterns.dp.creational.factory.creditcard.CreditCard;
import com.jpvr.demodesignpatterns.dp.creational.factory.creditcard.CreditCardFactory;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AbstractFactoryTests {

    @Test
    public void test() throws ParserConfigurationException, IOException, SAXException {

        String xml = "<document><body><stock>AAPL</stock></body></document>";
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder factory = abstractFactory.newDocumentBuilder();
        Document doc = factory.parse(bais);

        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        System.out.println(abstractFactory.getClass());
        System.out.println(factory.getClass());

    } // end void test()

    @Test
    public void abstractFactoryDemo() {

        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(700);

        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);

        System.out.println(card.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(600);

        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);

        System.out.println(card2.getClass());
    } // end void abstractFactoryDemo()
} // end class AbstractFactoryTests
