package com.jpvr.demodesignpatterns.dp.behavioral;

import com.jpvr.demodesignpatterns.dp.behavioral.observer.MessageStream;
import com.jpvr.demodesignpatterns.dp.behavioral.observer.PhoneClient;
import com.jpvr.demodesignpatterns.dp.behavioral.observer.Subject;
import org.junit.jupiter.api.Test;

import java.util.Observable;
import java.util.Observer;

public class ObserverTests {

    @Test
    public void observerTest() {

        Subject subject = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(subject);

        phoneClient.addMessage("Here is a new message!");
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
        }
    }

    // concrete observer
    class Client implements Observer {

        private String name;

        public Client(String name) {
            this.name = name;
        }

        @Override
        public void update(Observable o, Object arg) {

            System.out.println("Update " + name + "'s stream, someone tweeted something");
        }
    }
} // end class ObserverTests
