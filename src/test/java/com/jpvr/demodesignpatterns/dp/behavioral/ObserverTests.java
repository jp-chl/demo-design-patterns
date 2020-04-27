package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.observer.MessageStream;
import com.jpvr.demodesignpatterns.dp.behavioral.observer.PhoneClient;
import com.jpvr.demodesignpatterns.dp.behavioral.observer.Subject;
import com.jpvr.demodesignpatterns.dp.behavioral.observer.TabletClient;
import org.junit.jupiter.api.Test;

import java.util.Observable;
import java.util.Observer;

public class ObserverTests {

    @Test
    public void observerTest() {

        Subject subject = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(subject);
        TabletClient tabletClient = new TabletClient(subject);

        phoneClient.addMessage("Here is a new message!");
        tabletClient.addMessage("Here is another message!");
    } // end void observerTest()



    @Test
    public void everydayDemo() {

        TwitterStream messageStream = new TwitterStream();

        Client client1 = new Client("Bob");
        Client client2 = new Client("John");

        messageStream.addObserver(client1);
        messageStream.addObserver(client2);

        messageStream.someoneTweeted();
    } // end void everydayDemo()

    // concrete subject
    class TwitterStream extends Observable {

        public void someoneTweeted() {
            setChanged();
            notifyObservers();
        } // end void someoneTweeted()
    } // end inner class TwitterStream extends Observable

    // concrete observer
    class Client implements Observer {

        private String name;

        public Client(String name) {
            this.name = name;
        }

        @Override
        public void update(Observable o, Object arg) {

            System.out.println("Update " + name + "'s stream, someone tweeted something");
        } // end void update(Observable o, Object arg)
    } // end inner class Client implements Observer
} // end class ObserverTests
