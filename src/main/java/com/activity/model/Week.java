package com.activity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "week")
public class Week {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int weekId;

	@Column(name="weekDays")
	private String weekDays;

	public int getWeekId() {
		return weekId;
	}

	public void setWeekId(int weekId) {
		this.weekId = weekId;
	}

	public String getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}

	public Week() {
		super();
	}

	public Week(int weekId, String weekDays) {
		super();
		this.weekId = weekId;
		this.weekDays = weekDays;
	}

	@Override
	public String toString() {
		return "Week [weekId=" + weekId + ", weekDays=" + weekDays + "]";
	}

}
