package lecture_200217.interfaceTest;

public interface Skill extends Move, Attack{
	
	// 다른 패키지(하위 패키지 포함)에서는 접근할 수 없도록 helpSkill() 작성 및 구현
	// 매개변수	: 없음
	// 기능		: "[도움말] 스킬은 공격과 이동 중에서 선택가능합니다" 출력

	default void helpSkill() {
		System.out.println("[도움말] 스킬은 공격과 이동 중에서 선택가능합니다");
	}
}
