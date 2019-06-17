package com.fsabino.javacodingtips.patterns_of_design.behavior.observer.observers;

import com.fsabino.javacodingtips.patterns_of_design.behavior.observer.Observer;
import com.fsabino.javacodingtips.patterns_of_design.behavior.observer.Subject;

public class ObserverA implements Observer {
    private Subject subject;

    public ObserverA(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Observer A: sujeto a cambiado: " + this.subject.getState());
    }
}
