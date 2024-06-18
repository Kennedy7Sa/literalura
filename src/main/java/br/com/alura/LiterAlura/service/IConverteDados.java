package br.com.alura.LiterAlura.service;

public interface IConverteDados {

    // Receber um Json com um livro e retornar um DadosLivro
    <T> T  obterDados(String json, Class<T> classe);
}
