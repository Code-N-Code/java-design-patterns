package com.codencode.logger;

import com.codencode.compiler.Compiler;

public class AroundLogger extends Logger {
    public AroundLogger(Compiler compiler) {
        super(compiler);
    }

    @Override
    public void compile(String code) {
        System.out.println("[Around Logger] About to compile code.");
        compiler.compile(code);
        System.out.println("[Around Logger] Code compilation complete.");
    }
}
