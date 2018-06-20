package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class ScoreService {

	private static final String KEY = "scores";
	List<Score> scores;

	@SuppressWarnings("unchecked")
	public ScoreService(ServletContext sc) {

		this.scores = (List<Score>) sc.getAttribute(ScoreService.KEY);

		if (this.scores == null) {
			this.scores = this.createScores();
			sc.setAttribute(ScoreService.KEY, this.scores);
		}
	}

	public Score getScore(String userId) {
		for (Score score : this.scores) {
			if (score.getUserId().equals(userId)) {
				return score;
			}
		}
		return null;
	}

	private List<Score> createScores() {

		List<Score> scores = new ArrayList<>();

		scores.add(new Score("ichiro", "ichiro@example.com"));
		scores.add(new Score("hanako", "hanakko@example.com"));
		scores.add(new Score("yuki", "yuki@example.com"));
		scores.add(new Score("tom", "tom@example.com"));

		return scores;
	}
}
