/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTests;

import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import model.Veterinario;

import org.junit.Test;

/**
 *
 * @author daniela.costa
 */
public class VeterinarioTest extends TestCase {

    Veterinario veterinario;

    @Override
    public void setUp() throws Exception {
        veterinario = new Veterinario();
    }

    @Test
    public void testCrmvVazio() {
        veterinario.setCrmv("");

        assertEquals("É necessário informar o CRMV.", veterinario.validarVeterinario());
    }

    @Test
    public void testCrmvInvalido() {
        veterinario.setCrmv("ABC12");

        assertEquals("O CRMV informado não é válido.", veterinario.validarVeterinario());
    }

    @Test
    public void testMatriculaVazia() {
        veterinario.setCrmv("ABC123");
        veterinario.setMatricula("");

        assertEquals("É necessário informar a matrícula.", veterinario.validarVeterinario());
    }

    @Test
    public void testMatriculaInvalida() {
        veterinario.setCrmv("ABC123");
        veterinario.setMatricula("12345");

        assertEquals("A matrícula informada não é válida.", veterinario.validarVeterinario());
    }

    @Test
    public void testNomeVazio() {
        veterinario.setCrmv("ABC123");
        veterinario.setMatricula("123456");
        veterinario.setNome("");

        assertEquals("É necessário informar o nome.", veterinario.validarVeterinario());
    }

    @Test
    public void testSenhaVazia() {
        veterinario.setCrmv("ABC123");
        veterinario.setMatricula("123456");
        veterinario.setNome("Daniela");
        veterinario.setSenha("");

        assertEquals("É necessário informar a senha.", veterinario.validarVeterinario());
    }

    @Test
    public void testSenhaInvalida() {
        veterinario.setCrmv("ABC123");
        veterinario.setMatricula("123456");
        veterinario.setNome("Daniela");
        veterinario.setSenha("1a2b3");

        assertEquals("A senha deverá ter no mínimo 6 dígitos.", veterinario.validarVeterinario());
    }

    @Test
    public void testTelefoneVazio() {
        veterinario.setCrmv("ABC123");
        veterinario.setMatricula("123456");
        veterinario.setNome("Daniela");
        veterinario.setSenha("1a2b3c");
        veterinario.setTelefone("");

        assertEquals("É necessário informar o telefone.", veterinario.validarVeterinario());
    }

    @Test
    public void testTelefoneInvalido() {
        veterinario.setCrmv("ABC123");
        veterinario.setMatricula("123456");
        veterinario.setNome("Daniela");
        veterinario.setSenha("1a2b3c");
        veterinario.setTelefone("1234567890");

        assertEquals("O telefone informado não é válido.", veterinario.validarVeterinario());
    }

    @Test
    public void testCadastroValido() {
        veterinario.setCrmv("ABC123");
        veterinario.setMatricula("123456");
        veterinario.setNome("Daniela");
        veterinario.setSenha("1a2b3c");
        veterinario.setTelefone("01234567890");

        assertEquals("Veterinário cadastrado com sucesso!", veterinario.validarVeterinario());
    }
}
