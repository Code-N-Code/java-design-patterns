package com.codencode.logger;

import com.codencode.compiler.Compiler;

public class AfterLogger extends Logger {
    public AfterLogger(Compiler compiler) {
        super(compiler);
    }

    @Override
    public void compile(String code) {
        compiler.compile(code);
        System.out.println("[After Logger] Code compilation complete.");
    }
}
