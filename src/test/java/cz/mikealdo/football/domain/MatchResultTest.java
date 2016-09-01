package cz.mikealdo.football.domain;


import org.junit.Test;

import cz.mikealdo.football.domain.MatchResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatchResultTest {

	@Test
	public void shouldNotParseWrongResultString() throws Exception {
        MatchResult matchResult = new MatchResult("2:1:2adsf");

        assertFalse(matchResult.isResultEntered());
    }

	@Test
	public void shouldParseResultThroughConstructor() throws Exception {
		MatchResult result = new MatchResult("2:1");

		assertEquals(2L, result.getHomeGoals());
		assertEquals(1L, result.getVisitorGoals());
		assertTrue(result.isResultEntered());
	}

	@Test
	public void shouldParseResultThroughConstructorWithBlankChars() throws Exception {
		MatchResult result = new MatchResult("2 : 1");

		assertEquals(2L, result.getHomeGoals());
		assertEquals(1L, result.getVisitorGoals());
		assertTrue(result.isResultEntered());
	}

	@Test
	public void shouldReturnTrueForDraw() throws Exception {
		MatchResult result = new MatchResult("1:1");

		assertTrue(result.isDraw());
	}

	@Test
	public void shouldReturnFalseForNotDraw() throws Exception {
		MatchResult result = new MatchResult("2:1");

		assertFalse(result.isDraw());
	}

	@Test
	public void shouldCreateResultWithPenaltiesGiven() throws Exception {
		MatchResult result = new MatchResult("1:1", "(PK:4:5)");
		
		assertEquals(1L, result.getHomeGoals());
		assertEquals(1L, result.getVisitorGoals());
		assertTrue(result.isResultEntered());
		assertTrue(result.isDraw());
		assertTrue(result.isPenaltyShootout());
		assertEquals(4L, result.getHomeGoalsInPenaltyShootout());
		assertEquals(5L, result.getVisitorGoalsInPenaltyShootout());
		
	}
}