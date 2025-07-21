package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

class Boundary {

    Ranking r;
    
    @BeforeEach
    public void setUp() throws Exception{
    	r = new Ranking();
    }
    
    @ParameterizedTest
    @CsvSource({
    	"999, 1, 99, Standard",
    	"9999, 1, 99, Standard",
    	"50000, 1, 500, Standard",
    	"50000, 6, 500, Standard",
    	"50000, 7, 500, Standard",
    	"49999,	1, 500, Silver",
    	"50000, 1, 500, Silver",
    	"75000,	29, 750, Gold",
    	"100000, 30, 500, Gold",
    	"100000, 16, 1000, Platinum"
    	
    })
    void boundaryTest(int purchaseTotal, int freq, int point, String expected) {
    	assertEquals(expected, r.CalculateMembershipRank(purchaseTotal, freq, point));
    }
}
