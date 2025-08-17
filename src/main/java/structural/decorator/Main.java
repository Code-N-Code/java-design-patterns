package com.codencode;


import com.codencode.compiler.Compiler;
import com.codencode.compiler.CppCompiler;
import com.codencode.logger.AroundLogger;

public class Main {
    public static void main(String[] args) {
        Compiler compiler = new CppCompiler();

        compiler = new AroundLogger(compiler);
        compiler.compile("Hello World");
    }
}
