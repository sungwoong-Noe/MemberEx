package hello.core.member;

public class Member {

    //회원 정보
    private Long id;
    private String name;
    private Gradle gradle;

    //Command + N : Constructor(생성자)
    public Member(Long id, String name, Gradle gradle) {
        this.id = id;
        this.name = name;
        this.gradle = gradle;
    }

    //getter, setter : 데이터를 가져오고 뽑는 메서드, get, set을 통해 위의 private로 선언된 정보들을 설정, 가져오는것을 할 수 있다.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gradle getGradle() {
        return gradle;
    }

    public void setGradle(Gradle gradle) {
        this.gradle = gradle;
    }
}
