package org.eitorresmendoza.junit5app.ejemplo.models;

import org.eitorresmendoza.junit5app.ejemplo.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {

    Cuenta cuenta;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        this.cuenta = new Cuenta("Enrique Torres", new BigDecimal("10000.123456"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("    Inicializando el método");

        testReporter.publishEntry("Ejecutando: " + testInfo.getDisplayName() +
                ". Método -> " +testInfo.getTestMethod().orElse(null).getName() +
                ". Con las siguientes etiquetas: " + testInfo.getTags());
    }

    @AfterEach
    void tearDown() {
        System.out.println("    Finalizando el método Test");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el Test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el Test");
    }

    @Nested
    @DisplayName("Probando atributos de la cuenta")
    class CuentaTestNombreSaldo {

        @Tag("cuenta")
        @Test
        @DisplayName("Testeando nombre")
        void testNombreCuenta() {
            testReporter.publishEntry(testInfo.getTags().toString());
            if(testInfo.getTags().contains("cuenta")){
                testReporter.publishEntry("Hacer algo con la etiqueta (Tag) 'Cuenta'");
            }
//        cuenta.setPersona("Enrique");
            String nombreEsperado = "Enrique Torres";
            String nombreReal = cuenta.getPersona();
            assertNotNull(nombreReal, () -> "El nombre del titular de la cuenta no puede ser nulo o vacío");
            assertEquals(nombreEsperado, nombreReal, () -> "El nombre esperado del titular de la cuenta no es el nombre esperado\n" +
                    "Se esperaba " + nombreEsperado + ", sin embargo el nombre real fue " + nombreReal);
            assertTrue(nombreReal.equals("Enrique Torres"), () -> "La expresión es falsa, los nombres del titular de la cuenta no son idénticos");
        }

        @Test
        @DisplayName("Test para el saldo")
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
    }


    @Nested
    class CuentaOperacionesTest {

        @Tag("cuenta")
        @Test
        @DisplayName("Test para probar el método débito de una cuenta")
        void testDebitoCuenta() {
            cuenta.debito(new BigDecimal("1000"));
            assertNotNull(cuenta.getSaldo());
            assertEquals(9000, cuenta.getSaldo().intValue());
            assertEquals("9000.123456", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Test
        @DisplayName("Test para probar el método crédito de una cuenta")
        void testCreditoCuenta() {
            cuenta.credito(new BigDecimal("1000"));
            assertNotNull(cuenta.getSaldo());
            assertEquals(11000, cuenta.getSaldo().intValue());
            assertEquals("11000.123456", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Tag("banco")
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
    }


    @Tag("cuenta")
    @Tag("error")
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
    @Tag("cuenta")
    @Tag("banco")
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

    @Nested
    class SistemaOperativoTest {
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
    }

    @Nested
    class JavaVersionTest {
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
    }

    @Nested
    class SystemPropiertiesTest {
        @Test
        void imprimirSystemPropierties() {
            Properties properties = System.getProperties();
            properties.forEach((llave, valor) -> System.out.println(llave + ": " + valor));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = ".*21.*")
        void testJavaVersion() {
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

    @Nested
    class VariablesAmbienteTest {
        @Test
        void imprimirVariablesAmbiente() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> System.out.println(k + " = " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-21.*")
        void testJavaHome() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void testProcesadores() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
        void testEnv() {
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "prod")
        void testEnvProdDisabled() {
        }

    }

    @Test
    @DisplayName("Test Saldo Cuenta Dev)")
    void testSaldoCuentaDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(10000.123456, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @Test
    @DisplayName("Test Saldo Cuenta Dev 2")
    void testSaldoCuentaDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(esDev, () -> {
            assertNotNull(cuenta.getSaldo());
            assertEquals(10000.123456, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        });
    }

    @DisplayName("Probando Débito Cuenta Repetir")
    @RepeatedTest(value = 5, name = "{displayName} - Repetición número {currentRepetition} de {totalRepetitions}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 3) {
            System.out.println("estamos en la repetición " + info.getCurrentRepetition());
        }
        cuenta.debito(new BigDecimal("1000"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(9000, cuenta.getSaldo().intValue());
        assertEquals("9000.123456", cuenta.getSaldo().toPlainString());
    }

    @Tag("param")
    @Nested
    class PruebasParametrizadasTest{
        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"1000", "2000", "3000", "5000", "7000", "10000.123456"})
        void testDebitoCuentaValueSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,1000", "2,2000", "3,3000", "4, 5000", "5,7000", "6,10000.123456"})
        void testDebitoCuentaCsvSource(String index, String monto) {
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1000,1000, santi, santi", "2500,2000, sebas, sebas", "3001,3000, ale, ale", "5500, 5000, Enrique, Enrique",
                "8000,7000, torner, torner", "10000.123456,10000.123456, oscar, oscar"})
        void testDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual) {
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCsvFileSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv")
        void testDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual) {
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    @Tag("param")
    @ParameterizedTest(name = "número {index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("montoList")
    void testDebitoCuentaMethodSource(String monto) {
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> montoList() {
        return Arrays.asList("1000", "2000", "3000", "5000", "7000", "10000.123456");
    }

    @Nested
    @Tag("timeout")
    class EjemploTimeoutTest{

        @Test
        @Timeout(1)
        void pruebaTimeout() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(900);
        }
        @Test
        @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
        void pruebaTimeout2() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(900);
        }

        @Test
        void testTimeoutAssertions() {
            assertTimeout(Duration.ofSeconds(5), () -> {
                TimeUnit.MILLISECONDS.sleep(4900);
            });
        }
    }

}