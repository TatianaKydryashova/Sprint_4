import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.Test;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expectedResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Test name: {0}, Test result: {1}")
    public static Object[][] getNameData() {
        return new Object[][] {
                { "Тимоти Шаламе", true},
                { "Тимоти Шаламе Шаламе", false},
                { "ТимотейШевроле", false},
                { "123Тимотей", false},
                { "Timoty 789", false},
                { "2,7894 789654", false},
                { " Timoty Shalame ", false},
                { "Тимоти Тимоти ТимотиТимотиТимоти-Шаламе ", false},
                { "Ти", false},
                { "Тим", false},
                { "Т м", true},
                { "Тимо", false},
                { "ТимотиТимотиТимоти", false},
                { "ТимотиТиотиТимотии", false},
                { "ТимотиТи тиТимотии", true},
                { "ТимотиТимотиТимотиии", false},
                { "", false},
                {null, false},
        };
    }

    @Test
    public void checkNameToEmboss() {
        Account account = new Account(name);
        assertEquals(expectedResult, account.checkNameToEmboss());
    }
}
