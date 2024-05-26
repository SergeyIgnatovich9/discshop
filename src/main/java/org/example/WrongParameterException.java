package org.example;

import java.io.IOException;

public class WrongParameterException extends IOException {
    public WrongParameterException() {
        super("Wrong parameter!");
    }
}
