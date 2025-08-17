package com.codencode.logger;

import com.codencode.compiler.Compiler;

public class BeforeLogger extends Logger {
    public BeforeLogger(Compiler compiler) {
        super(compiler);
    }

    @Override
    public void compile(String code) {
        System.out.println("[Before Logger] About to compile code.");
        compiler.compile(code);
    }
}
