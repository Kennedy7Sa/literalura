package br.com.alura.LiterAlura.repository;

import br.com.alura.LiterAlura.model.Idiomas;
import br.com.alura.LiterAlura.model.Autor;
import br.com.alura.LiterAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


// Interage com o banco de dados, realiza operações na Entidade Livro
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByTituloContainingIgnoreCase(String nomeLivro);
    @Query("SELECT a FROM Autor a " +
            "WHERE a.anoDeNascimento <= :ano " +
            "AND (a.anoDeFalecimento IS NULL OR a.anoDeFalecimento >= :ano)")

    List<Autor> obterAutoresVivosEmAno(int ano);

    List<Livro> findByIdiomas(Idiomas idoma);
}