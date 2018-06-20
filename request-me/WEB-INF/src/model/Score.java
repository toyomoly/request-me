package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Score {

	private String userId;
	private String password;
	private int level;
	private boolean isCompleted;
	private LocalDateTime completedTime;

	public Score(String userId, String password) {
		this.userId = userId;
		this.password = password;

		this.setLevel(0);

		this.isCompleted = false;
		this.completedTime = null;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (this.level < level) {
			this.level = level;
		}
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public String getUserId() {
		return userId;
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	public String getCompletedTime() {
		if (this.completedTime == null) {
			return "-";
		} else {
			return completedTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		}
	}

	public void completed() {

		if (this.isCompleted == false) {
			this.isCompleted = true;
			this.completedTime = LocalDateTime.now();
		}
	}

}
