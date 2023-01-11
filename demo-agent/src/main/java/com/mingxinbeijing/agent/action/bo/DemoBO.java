package com.mingxinbeijing.agent.action.bo;

public class DemoBO {

	/**
	 * 课程ID
	 *
	 * @mbg.generated
	 */
	private Long lessonId;

	/**
	 * 课程名称
	 *
	 * @mbg.generated
	 */
	private String lessonName;

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	@Override
	public String toString() {
		return "DemoBO [lessonId=" + lessonId + ", lessonName=" + lessonName + "]";
	}
}
