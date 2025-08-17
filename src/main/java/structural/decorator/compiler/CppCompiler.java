package com.codencode.compiler;

public class CppCompiler implements Compiler {
    @Override
    public void compile(String code) {
        System.out.println("Compiler: CPP");
        System.out.println("Compiling Code\n" + code);
    }
}
