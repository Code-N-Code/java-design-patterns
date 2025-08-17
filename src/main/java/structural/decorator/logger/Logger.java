package com.codencode.logger;

import com.codencode.compiler.Compiler;

public abstract class Logger implements Compiler {
    protected Compiler compiler;

    public Logger(Compiler compiler) {
        this.compiler = compiler;
    }
}
