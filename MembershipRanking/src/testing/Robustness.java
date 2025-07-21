package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;


class Robustness {

	Ranking r;
	
	@BeforeEach
	public void setUp() throws Exception{
		r = new Ranking();
	}
	
	@ParameterizedTest
	@CsvSource({

        "-1, 2, 100, Invalid Input",
        "0, 2, 100, Standard",
        "10000, 2, 100, Silver",
        "99999, 5, 500, Gold",
        "1000000, 6, 1000, Platinum",

        "10000, -1, 100, Invalid Input",
        "10000, 0, 100, Standard",
        "10000, 2, 100, Silver",
        "50000, 5, 500, Gold",
        "100000, 8, 1000, Standard",

        "10000, 2, -1, Invalid Input",
        "10000, 2, 0, Standard",
        "10000, 2, 100, Silver",
        "50000, 31, 500, Gold",
        "100000, 6, 10000, Platinum",

        "9999999, 10, 99999, Platinum",
        "100000, 30, 1000, Platinum"
		
	})
	
	void robustTest(int total, int freq, int point, String expected) {
		assertEquals(expected, r.CalculateMembershipRank(total, freq, point));
	}
}
