package org.eitorresmendoza.junit5app.ejemplo.models;

import org.eitorresmendoza.junit5app.ejemplo.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.math.BigDecimal;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {

    Cuenta cuenta;
    @BeforeEach
    void setUp() {
        this.cuenta = new Cuenta("Enrique Torres", new BigDecimal("10000.123456"));
        System.out.println("Inicializando el método");
    }
    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el método Test");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el Test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el Test");
    }

    @Test
    @DisplayName("Testeando nombre de la cuenta: not null, equals, true, entre nombre real y esperado")
    void testNombreCuenta() {
//        cuenta.setPersona("Enrique");
        String nombreEsperado = "Enrique Torres";
        String nombreReal = cuenta.getPersona();
        assertNotNull(nombreReal, () -> "El nombre del titular de la cuenta no puede ser nulo o vacío");
        assertEquals(nombreEsperado, nombreReal, () -> "El nombre esperado del titular de la cuenta no es el nombre esperado\n" +
                "Se esperaba " + nombreEsperado + ", sin embargo el nombre real fue " + nombreReal);
        assertTrue(nombreReal.equals("Enrique Torres"), () -> "La expresión es falsa, los nombres del titular de la cuenta no son idénticos");
    }

    @Test
    @DisplayName("Test para el saldo de la cuenta, not null, equals, false y true)")
    void testSaldoCuenta() {
        assertNotNull(cuenta.getSaldo());
        assertEquals(10000.123456, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @Test
    @DisplayName("Test para la referencia de cuentas, con método equals personalizado, valor/referencia")
    void testReferenciaCuenta() {
        Cuenta cuentaReal = new Cuenta("Charly", new BigDecimal("8999.9994"));
        Cuenta cuentaEsperada = new Cuenta("Charly", new BigDecimal("8999.9994"));
//        assertNotEquals(cuentaEsperada, cuentaReal);
        assertEquals(cuentaEsperada, cuentaReal);
    }

    @Test
    @DisplayName("Test para probar el método débito de una cuenta")
    void testDebitoCuenta() {
        cuenta.debito(new BigDecimal("1000"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(9000, cuenta.getSaldo().intValue());
        assertEquals("9000.123456", cuenta.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("Test para probar el método crédito de una cuenta")
    void testCreditoCuenta() {
        cuenta.credito(new BigDecimal("1000"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(11000, cuenta.getSaldo().intValue());
        assertEquals("11000.123456", cuenta.getSaldo().toPlainString());
    }

    @Test
    @DisplayName("Test probar dinero insuficiente de una cuenta al hacer una transacción")
    void testDineroInsuficienteExceptionCuenta() {
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(15000));
        });
        String real = exception.getMessage();
        String esperado = "Dinero insuficiente";
        assertEquals(esperado, real);
    }

    @Test
    @DisplayName("Test para probar el método transferir de una cuenta a otra")
    void transferirDineroCuentas() {
        Cuenta cuentaDestino = new Cuenta("Enrique", new BigDecimal("2500"));
        Cuenta cuentaOrigen = new Cuenta("Sebastian", new BigDecimal("1500.8989"));
        Banco elBanco = new Banco();
        elBanco.setNombre("El banco de México");
        elBanco.transferir(cuentaOrigen, cuentaDestino, new BigDecimal("500"));
        assertEquals("1000.8989", cuentaOrigen.getSaldo().toPlainString());
        assertEquals("3000", cuentaDestino.getSaldo().toPlainString());
    }
    @Test
//    @Disabled
    @DisplayName("Test para probar relación entre el banco y las cuentas, añadir cuentas, assertAll")
    void testRelacionBancoCuentas() {
//        fail();
        Cuenta cuentaDestino = new Cuenta("Sebastian", new BigDecimal("2500"));
        Cuenta cuentaOrigen = new Cuenta("Enrique", new BigDecimal("1500.8989"));
        Banco elBanco = new Banco();

        elBanco.addCuenta(cuentaOrigen);
        elBanco.addCuenta(cuentaDestino);

        elBanco.setNombre("El banco de México");
        elBanco.transferir(cuentaOrigen, cuentaDestino, new BigDecimal("500"));

        assertAll(() -> assertEquals("1000.8989", cuentaOrigen.getSaldo().toPlainString(),
                        () -> "El saldo de la cuenta de origen correspondiente al titular con el nombre " + cuentaOrigen.getPersona() +
                                "\nNo tiene el valor esperado"),
                () -> assertEquals("3000", cuentaDestino.getSaldo().toPlainString(),
                        () -> "El saldo de la cuenta de destino correspondiente al titular con el nombre " + cuentaDestino.getPersona() +
                                "\nNo tiene el valor esperado"),
                () -> assertEquals(2, elBanco.getCuentas().size(),
                        () -> "El número de cuentas existentes en " + elBanco.getNombre() +
                                ", no coincide con el valor esperado, favor de verificar los datos"),
                () -> assertEquals("El banco de México", cuentaOrigen.getElBanco().getNombre(),
                        () -> "El nombre del banco del titular de la cuenta de la persona " + cuentaOrigen.getPersona() +
                                " no es el esperado, favor de verificar los datos"),
                () -> assertEquals("El banco de México", cuentaDestino.getElBanco().getNombre(),
                        () -> "El nombre del banco del titular de la cuenta de la persona " + cuentaDestino.getPersona() +
                                " no es el esperado, favor de verificar los datos"),
                () -> assertEquals("Enrique", elBanco.getCuentas().stream()
                        .filter(cuenta -> cuenta.getPersona().equals("Enrique"))
                        .findFirst()
                        .get().getPersona(), () -> "El nombre del titular de la cuenta no coincide con el nombre esperado, favor de verificar los datos"),
                () -> assertTrue(elBanco.getCuentas().stream()
                        .anyMatch(cuenta -> cuenta.getPersona().equals("Enrique")), () -> "El valor de la expresión es falso, verifique los datos esperados y reales")
        );
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindows() {
    }
    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testMacLinux() {
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNoWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testSoloJdk8() {
    }
    @Test
    @EnabledOnJre(JRE.OTHER)
    void testSoloJdk21() {
    }
    @Test
    @DisabledOnJre(JRE.OTHER)
    void testNoJdk21() {
    }

    @Test
    void imprimirSystemPropierties() {
        Properties properties = System.getProperties();
        properties.forEach((llave, valor) -> System.out.println(llave + ": " + valor));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = ".*21.*")
    void  testJavaVersion() {
    }

    @Test
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testSolo64Bit() {
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testNo64Bit() {
    }

    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "siril")
    void testUsername() {
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void testDev() {
    }
    
}