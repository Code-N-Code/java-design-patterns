package com.codencode.compiler;

public class JavaCompiler implements Compiler {
    @Override
    public void compile(String code) {
        System.out.println("Compiler: Java");
        System.out.println("Compiling Code\n" + code);
    }
}
